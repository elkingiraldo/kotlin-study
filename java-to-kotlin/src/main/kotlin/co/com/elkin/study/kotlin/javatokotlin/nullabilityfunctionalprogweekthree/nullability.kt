package co.com.elkin.study.kotlin.javatokotlin.nullabilityfunctionalprogweekthree

import org.jetbrains.annotations.NotNull

fun main() {
    println(isLengthThree(null))
    println(isLengthThree("2"))
    println(isLengthThree("222"))

    val s1: String? = null
    val s2: String? = ""
    s1.isEmptyOrNull() == true
    s2.isEmptyOrNull() == true

    val s3 = "   "
    s3.isEmptyOrNull() == false
}

fun isLengthThree(s: String?) = s?.length == 3

fun safeGoInNullString () {
    val hola: String = "hola"
    val nulll: String? = null

    hola.length

    // nulll.length not possible becaus can be null
    // if not null access to length
    nulll?.length
}

fun safeInt() {
    val s: String? = null

    // length or null (nullable int)
    val length: Int? = s?.length
    // length or 0 when null
    val length2: Int = s?.length ?: 0
    // length or 0 when null into if
    val length3: Int = if (s != null) s.length else 0
}

fun elvisOperator() {
    // foo ?: bar
    // if foo != null => foo
    // if foo == null => bar
}

fun smartCast() {
    val s: String? = null
    if (s == null) return
    // We can access s.length instead of s?.length because we already validated null of s in the past line
    s.length
}

fun kotlinNullPointerException() {
    // foo!!
    // if foo != null => foo
    // if foo == null => NPE
}

// Same function in kotlin and java NULL
fun nullFun(): String = "foo"
//@NotNull
//public static final String nullFun2() {
//    return "foo";
//}

// Same function in kotlin and java NULLABLE
fun nullableFun(): String? = "foo"
//@Nullable
//public static final String nullFun2() {
//    return "foo";
//}

fun String?.isEmptyOrNull(): Boolean {
    return (this == null) || (this == "")
}

// is => instanceOf; as => typecast
// as? safe cast => return null
fun safecast(any: String) {
    if (any is String) {
        val s = any as String
        s.toUpperCase()
    }
}

//Type cast as throws ClassCastException, if the cast is unsuccessful.
// Safe cast as? returns null, if the cast is unsuccessful. Declare the s variable
// to make the first line print null and the second one throw an exception.eifglffblgujjc
fun main(args: Array<String>) {
    val s = "hola"
    println(s as? Int)    // null       => Safe cast
    println(s as Int?)    // exception  => jgngkgt
}









