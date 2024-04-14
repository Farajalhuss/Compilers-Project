package backend

class Runtime() {
    val symbolTable:MutableMap<String, Data> = mutableMapOf()

    fun subscope(bindings:Map<String, Data>):Runtime {
        val parentSymbolTable = this.symbolTable
        return Runtime().apply {
            symbolTable.putAll(parentSymbolTable)
            symbolTable.putAll(bindings)
        }
    }

    fun updateListElement(listName: String, index: Int, newValue: Data) {
        val listData = this.symbolTable[listName] as? ListData ?: throw Exception("List name not found.")
        if (index < 0 || index >= listData.elements.size) throw IndexOutOfBoundsException("List index out of bounds.")
        listData.elements[index] = newValue
    }

    override fun toString():String =
        symbolTable.map { 
            entry -> "${entry.key} = ${entry.value}"
        }.joinToString("; ")
}


