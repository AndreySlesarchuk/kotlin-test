package topics

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-05-03
 */

fun main() {
    val test1 = "Hello"
    //test1 = "Good Bye" - won't work
    println("Value of test1 $test1")

    var test2 = "Hello"
    test2 = "Good Bye"

    println("Value of test2 $test2")

    val test3 = 15
    //test1 = "Good Bye"

    var test4 = 21
    test4 = 49

    println("Sum of test3 and test4 is ${test3 + test4}")

}