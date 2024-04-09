package backend

abstract class Data {
    abstract override fun toString(): String
}

object NullData: Data() {
    override fun toString(): String = "NULL"
}

class IntData(val value:Int): Data() {
    override fun toString(): String = "$value"
}

class StringData(val value: String) : Data() {
    override fun toString() = value
}


class BooleanData(val value:Boolean): Data() {
    override fun toString() = 
    "${value}"
}

