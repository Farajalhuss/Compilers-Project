package backend

abstract class Expr {
    abstract fun eval(runtime: Runtime): Data
}

object NullExpr: Expr() {
    override fun eval(runtime:Runtime): Data = NullData
    
}

class IntLiteral(private val lexeme: String) : Expr() {
    override fun eval(runtime: Runtime): Data = IntData(lexeme.toInt())
}

class StringLiteral(private val lexeme: String) : Expr() {
    override fun eval(runtime: Runtime): Data = StringData(lexeme)
}

class BooleanLiteral(private val lexeme: String) : Expr() {
    override fun eval(runtime: Runtime): Data = BooleanData(lexeme.toBoolean())
}

class PrintExpr(private val expr: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val result = expr.eval(runtime)
        println(result)
        return result
    }
}

enum class Operator {
    Add,
    Sub,
    Mul,
    Div
}

class Arithmetics(
    val op:Operator,
    val left:Expr,
    val right:Expr
): Expr() {
    override fun eval(runtime:Runtime): Data {
        val x = left.eval(runtime)
        val y = right.eval(runtime)
        if(x !is IntData || y !is IntData) {
            throw Exception("cannot handle non-integer")
        }
        
        return IntData(
            when(op) {
                Operator.Add -> x.value + y.value
                Operator.Sub -> x.value - y.value
                Operator.Mul -> x.value * y.value
                Operator.Div -> {
                    if(y.value != 0) {
                        x.value / y.value
                    } else {
                        throw Exception("cannot divide by zero")
                    }
                }
                else -> throw Exception("Unknown operator")
            }
        )
    }
}

class Assign(val symbol: String, val expr: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val result = expr.eval(runtime)
        runtime.symbolTable[symbol] = result
        
        return result
    }
}

class Deref(val name: String) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val data = runtime.symbolTable[name]
        if (data == null) {
            throw Exception("$name is not assigned.")
        }
        
        return data
    }
}

class Block(val exprList: List<Expr>): Expr() {
    override fun eval(runtime:Runtime): Data {
        var result:Data = NullData
        exprList.forEach {
            result = it.eval(runtime)
        }
        
        return result
    }
}

class StringRepeatExpr(val stringExpr: Expr, val timesExpr: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val str = stringExpr.eval(runtime) as? StringData
        val times = timesExpr.eval(runtime) as? IntData
        
        if (str != null && times != null) {
            return StringData(str.value.repeat(times.value))
        } else {
            throw RuntimeException("Operands for string repetition are not of the correct type.")
        }
    }  
    override fun toString(): String = "StringRepeatExpr(${stringExpr.toString()}, ${timesExpr.toString()})"
}

class StringConcatExpr(val left: Expr, val right: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val leftStr = left.eval(runtime).toString()
        val rightStr = right.eval(runtime).toString()
        return StringData(leftStr + rightStr)
    }
}

class ForLoop(
    val variable: String,
    val start: Expr,
    val end: Expr,
    val body: Expr
) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val startVal = (start.eval(runtime) as IntData).value
        val endVal = (end.eval(runtime) as IntData).value
        var lastEval: Data = NullData
        for (i in startVal..endVal) {
            runtime.symbolTable[variable] = IntData(i)
            lastEval = body.eval(runtime)
        }
        return lastEval
    }
}

class FuncData(
    val name: String,
    val params: List<String>,
    val body: Expr
): Data() {
    override fun toString()
    = params.joinToString(", ").let {
        "$name($it) { ... }"
    }
}

class Declare(
    val name: String,
    val params: List<String>,
    val body: Expr
): Expr() {
    override fun eval(runtime:Runtime):Data
    = FuncData(name, params, body).also {
        runtime.symbolTable[name] = it
    }
}

class Invoke(val name:String, val args:List<Expr>):Expr() {
    override fun eval(runtime:Runtime):Data {
        val func:Data? = runtime.symbolTable[name]
        if(func == null) {
            throw Exception("$name does not exist")
        }
        if(func !is FuncData) {
            throw Exception("$name is not a function.")
        }
        if(func.params.size != args.size) {
            throw Exception(
                "$name expects ${func.params.size} arguments "
                + "but received ${args.size}"
            )
        }
        
        val r = runtime.subscope(
            func.params.zip(args.map {it.eval(runtime)}).toMap()
        )
        return func.body.eval(r)
    }
}

enum class Comparator {
    LT,
    LE,
    GT,
    GE,
    EQ,
    NE,
}

class Compare(
    val comparator: Comparator,
    val left: Expr,
    val right: Expr
): Expr() {
    override fun eval(runtime:Runtime): Data {
        val x = left.eval(runtime)
        val y = right.eval(runtime)
        if(x is IntData && y is IntData) {
            return BooleanData(
                when(comparator) {
                    Comparator.LT -> x.value < y.value
                    Comparator.LE -> x.value <= y.value
                    Comparator.GT -> x.value > y.value
                    Comparator.GE -> x.value >= y.value
                    Comparator.EQ -> x.value == y.value
                    Comparator.NE -> x.value != y.value
                }
            )
        } else {
            throw Exception("Non-integer data in comparison")
        }
    }
}

class Ifelse(
    val cond:Expr,
    val trueExpr:Expr,
    val falseExpr:Expr
): Expr() {
    override fun eval(runtime:Runtime): Data {
        val cond_data = cond.eval(runtime)
        if(cond_data !is BooleanData) {
            throw Exception("need boolean data in if-else")
        }
        return if(cond_data.value) {
            return trueExpr.eval(runtime)
        } else {
            return falseExpr.eval(runtime)
        }
    }
}

class ElementAccess(private val varName: String, private val indexExpr: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val variable = runtime.symbolTable[varName] ?: throw Exception("$varName is not defined.")
        val index = indexExpr.eval(runtime) as? IntData ?: throw Exception("Index must be an integer.")
        
        return when (variable) {
            is TupleData -> variable.elements.getOrElse(index.value) {
                throw IndexOutOfBoundsException("Tuple index out of bounds.")
            }
            is ListData -> variable.elements.getOrElse(index.value) {
                throw IndexOutOfBoundsException("List index out of bounds.")
            }
            else -> throw Exception("$varName is neither a tuple nor a list.")
        }
    }
}

class Tuple(val elements: List<Expr>) : Expr() {
    override fun eval(runtime: Runtime): Data {
        return TupleData(elements.map { it.eval(runtime) })
    }
}

class OurList (val elements: MutableList<Expr>) : Expr() {
    override fun eval(runtime: Runtime): Data {
        return ListData(elements.map { it.eval(runtime) }.toMutableList())
    }
}

class ListAssignment(private val listName: String, private val indexExpr: Expr, private val newElementExpr: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val index = indexExpr.eval(runtime) as? IntData ?: throw Exception("list index is not an integer.")
        val newValue = newElementExpr.eval(runtime)
        runtime.updateListElement(listName, index.value, newValue)
        return newValue
    }
}

class Length(private val target: Expr) : Expr() {
    override fun eval(runtime: Runtime): Data {
        val result = target.eval(runtime)
        if (result is TupleData) {
            return IntData(result.elements.size)
        } 
        else if (result is ListData){
            return IntData(result.elements.size)
        }
        else {
            return IntData(result.toString().length)
        }
    }
}

