package co.com.elkin.study.kotlin.javatokotlin.general

import java.io.IOException
import java.lang.IllegalArgumentException


fun main(args: Array<String>) {

    //when multiple
    println(callWhenFunctionMultipleInput("yes"))
    println(callWhenFunctionMultipleInput("y"))

    //instance of change by is

    iterateLoops();

    //callException("", 105)
    //callException("", 98)
    callException("dsfgh", 98)

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

//No difference between checked and unchecked exceptions
//throw is an expression in kotlin, you can assign this result to a variable
// try is an expression too
@Throws(IOException::class) // For java implementation
fun callException(s: String, number: Int) {

    val percentage =
        if (number in 0..100)
            number
        else
            throw IllegalArgumentException("Fail the number is: $number")

    println(if (s.isEmpty()) throw IOException() else "no error")
}