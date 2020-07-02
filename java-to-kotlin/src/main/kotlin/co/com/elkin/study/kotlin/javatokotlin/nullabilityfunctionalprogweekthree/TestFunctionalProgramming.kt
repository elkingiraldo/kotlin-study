package co.com.elkin.study.kotlin.javatokotlin.nullabilityfunctionalprogweekthree

class TestFunctionalProgramming {

    fun List<Int>.allNonZero() =  all { it != 0 }
    fun List<Int>.allNonZero1() =  none { it == 0 }
    fun List<Int>.allNonZero2() = !any { it == 0 }

    fun List<Int>.containsZero() =  any { it == 0 }
    fun List<Int>.containsZero1() = !all { it != 0 }
    fun List<Int>.containsZero2() = !none { it == 0 }

    fun main(args: Array<String>) {
        val list1 = listOf(1, 2, 3)
        list1.allNonZero() == true
        list1.allNonZero1() == true
        list1.allNonZero2() == true

        list1.containsZero() == false
        list1.containsZero1() == false
        list1.containsZero2() == false

        val list2 = listOf(0, 1, 2)
        list2.allNonZero() == false
        list2.allNonZero1() == false
        list2.allNonZero2() == false

        list2.containsZero() == true
        list2.containsZero1() == true
        list2.containsZero2() == true
    }

}