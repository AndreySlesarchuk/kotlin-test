package by.atmm.kotlin.topics

/**
 *  @author Andrey Slesarchuk
 *  @date 2025-03-31
 */

fun main() {

    for (i in 9 downTo 0) {
        println("for downTo $i") // 9, 8, 7...
    }

//  Since Kotlin 1.9 there’s a new stable syntax for the until operator (..<) as well:
//    for (i in 0 ..< 10) {
//        println("for until $i")
//    }

    // loop is exclusive
    for (i in 0 until 10) {
        println(i)
    }

    // loop is inclusive
    for (i in 0..9) {
        println(i)
    }

    val jokers = listOf("Heath Ledger", "Joaquin Phoenix", "Jack Nicholson")
    for (j in jokers) {
        println(j)
    }

    for (c in "Word") {
        println(c)
    }


}