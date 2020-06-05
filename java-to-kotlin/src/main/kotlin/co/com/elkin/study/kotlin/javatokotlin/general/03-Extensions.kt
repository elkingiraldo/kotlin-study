package co.com.elkin.study.kotlin.javatokotlin.general

//String is the receiver of lastChar Function
fun String.lastChar() = this.get(this.length - 1)
fun String.lastChar1() = get(length - 1)

//FOR call it from java
// 03-Extensionskt.repeat("Hola", 3)

// the following function si transformed to a extension

//fun sum(list: List<Int>): Int {
//    var result = 0
//    for (i in list) {
//        result += i
//    }
//    return result
//}
fun List<Int>.sum(): Int {
    var result = 0
    for (i in this) {
        result += i
    }
    return result
}
// member win extensions .get for string for example

fun main(args: Array<String>) {
    val sum = listOf(1, 2, 3).sum()
    println(sum)    // 6
}