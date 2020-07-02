package co.com.elkin.study.kotlin.javatokotlin.nullabilityfunctionalprogweekthree

fun main2() {
    val list = listOf<Employee>(Employee(28, "Elkin"), Employee(26, "Mafe "))
    list.filter { it.name == "Elkin" }.map { it.age }.average()

    // groupBy, partition, associateBy
    // associate => list to map
    // zip => two list in one
    //flatten => combined list in unique list
    // flatMap => "abc" "def" un a list of abcdef

}

fun testLambdaExpressions () {
    // Creating a Lambda expression
    val isEven: (Int) -> Boolean = { i: Int -> i % 2 == 0}
    // storing the result of a lambda expression
    val result: Boolean = isEven(42)
    println(result)

    // We can pass a lambda expression inside a method
    val list = listOf<Int>(1, 2, 3)
    list.any(isEven)
    list.filter(isEven)

    // Call lambda directly
    run { println("Hey!") }
}

// SAM interfaces
fun lambdasAndJava() {

    // Java Function
    // void postponeComputation(int delay, Runnable computation)

    // Kotlin function
    // postponeComputation(1000) { println(42) }

    // we need to create a function with a single abstract method for passing a lambda to Java
    val runnable = Runnable { println(42) }
    // postponeComputation(1000, runnable)
}

fun functionTypesAndNullability() {
    // () -> Int? vs (() -> Int)?
    // first means that returns type is nullable, second means whole type is nullable

    // Which lines won't compile?
    // #1 val f1: () -> Int? = null
    // #2 val f2: () -> Int? = { null } ------------------> lambda without arguments that always returns null
    // #3 val f3: (() -> Int)? = null --------------------> either lambda returning Int or null reference
    // #4 val f4: (() -> Int)? = { null }
    // lines #1 and #4 won't compile!!!!!!!!!

    val f3: (() -> Int)? = null
    // 2 ways to call f3
    // first way
    if (f3 != null)
        f3()
    // second way
    f3?.invoke()
}

// bound and unbound references
fun references() {
    fun isEven(i: Int): Boolean = i % 2 == 0
    // we cant assign a function in a variable ----> compiler error !!!!!!!!!!!
    // val predicate = isEven
    val predicate = ::isEven //passing the reference instead of the whole lambda

    //  non-bound --> reference to a class
    // bound --> reference to a instance
}














