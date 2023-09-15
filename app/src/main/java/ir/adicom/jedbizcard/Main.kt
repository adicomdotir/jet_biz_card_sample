package ir.adicom.jedbizcard

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun main() {
    str = "adicom"
    println(str)

    stringOne = "adicom"
    println(stringOne)
}

var stringOne by CustomDelegated()

var str: String = ""
    set(value) {
        field = "Hi $value"
    }

class CustomDelegated : ReadWriteProperty<Any?, String> {
    private var newStr = ""

    override fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return newStr
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        newStr = "New: $value"
    }

}