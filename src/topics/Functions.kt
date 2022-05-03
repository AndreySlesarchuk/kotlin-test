package topics

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-05-03
 */

fun main() {
    // From Kotlin Koans
    // https://play.kotlinlang.org/koans/Introduction/Named%20arguments/Task.ktghj

    println(testSimple(1, 2))
    println(testString(10))
    println(testNamedArguments(y = 10, z = 1, x = 5))

    testDefaultArguments()
    testDefaultArguments(5)
    testDefaultArguments(y = 6)
    testDefaultArguments(33, 44)

    printEven(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    printEven(*intArrayOf(1, 2, 3, 4, 5), 6, 7, 8, 9, 10)
}

//fun testSimple(x:Int, y:Int): Int {
//    return x + y
//}
fun testSimple(x: Int, y: Int): Int = x + y

//fun testString(x: Int): String {
//    return "String is $x"
//}
fun testString(x: Int): String = "String is $x"

fun testNamedArguments(x: Int, y: Int, z: Int): List<Int> {
    return listOf(x, y, z)
}

// void
fun testDefaultArguments(x: Int = 11, y: Int = 22) {
    println(x + y)
}

// vararg
fun printEven(vararg numbers: Int) {
    numbers.forEach { e -> if (e % 2 == 0) println(e) }
}