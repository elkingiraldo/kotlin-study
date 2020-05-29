@file:JvmName("Basic") // Now for calling functions outside Basics.weather(8)
package co.com.elkin.study.kotlin.javatokotlin.general

fun main(args: Array<String>) {
    val person = Person("Elkin", 28)
    println(person.name + " es una chimba")

    println(getNameFromPerson(person) + " tiene " + person.age + " años")

    weather(8)
    println(weather(8)) // Kotlin.Unit -> void function in Java
    weather2(30)

    println("Hello, ${args.getOrNull(0)}!")
    val helloWord = if (args.isNotEmpty()) args[0] else "Kotlin"
    println("Hello, $helloWord!")

    val testName = "Elkin"
    //testName = "hola" //not possible to change its value

    val mutableList = mutableListOf("Java")
    mutableList.add("Kotlin") // val not guarantee nothing about the content of an object, it can be easy modifiable

    val list = listOf("Java")
    // list.add("Kotlin")   // not possible to modify because of it's a read-only list

    //Functions can be defined on top-level (package level), member function (inside a class) or local function(inside a function)

    println(listOf("a", "b", "c").joinToString(separator = "; ", prefix = "--(", postfix = ")--"))

    displaySeparator()
    displaySeparator('7')
    displaySeparator(times = 10)
    displaySeparator(times = 2, character = '6')
    // displaySeparator(2, '6') // Not compile because of signature order

}

private fun getNameFromPerson(name: Person): String {
    val person = Person("Elkin", 28)
    return person.name
}

fun weather(degrees: Int){
    val (description, color) = when {
        degrees < 10 -> Pair("cold", Colors.BLUE)
        degrees > 25 -> Pair("mild", Colors.ORANGE)
        else -> Pair("hot", Colors.RED)
    }
    println("$description - $color")
}

fun weather2(degrees: Int){
    val (description, color) = when {
        degrees < 10 -> "cold" to Colors.BLUE
        degrees > 25 -> "mild" to Colors.ORANGE
        else -> "hot" to Colors.RED
    }
    println(message = "$description - $color")
}

// Function with a block body
fun addition(a: Int, b: Int): Int {
    return a+b
}

// Function with expression body
fun max(a: Int, b: Int) = if (a > b) a else b

@JvmOverloads // for calling this function only with one of the arguments
fun displaySeparator(character: Char = '#', times: Int = 4) {
    repeat(times) {
        print(character)
    }
}