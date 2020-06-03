package co.com.elkin.study.kotlin.javatokotlin.general

import java.io.IOException


fun main(args: Array<String>) {

    //when multiple
    println(callWhenFunctionMultipleInput("yes"))
    println(callWhenFunctionMultipleInput("y"))

    //instance of change by is

    iterateLoops();

}

fun callWhenFunctionMultipleInput(value: String) = when (value) {
    "y", "yes" -> "Agreeee"
    "n", "no" -> "Sorry"
    else -> "I don't understand"
}

fun iterateLoops() {

    val map = mapOf<Int, String>(1 to "one",
            2 to "two",
            3 to "three"
    )
    for ((key, value) in map) {
        println("$key = $value")
    }

    val list = listOf<String>("a", "b", "c")
    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }

    // for with bound
    for (i in 1..9) {
        println(i)
    }
    // for without bound
    for (i in 1 until 9) {
        println(i)
    }
    // with steps and descending
    for (i in 9 downTo 9 step 2) {
        println(i)
    }

    val s = "hola"
    for ((i, c) in s.withIndex()) {
        println("$i -> $c")
    }
}

@Throws(IOException::class) // For java implementation
fun callException(s: String) {
    if (s.isEmpty()) throw IOException() else "no error"
}