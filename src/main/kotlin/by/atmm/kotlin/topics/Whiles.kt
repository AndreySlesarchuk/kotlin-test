package by.atmm.kotlin.topics

/**
 *  @author Andrey Slesarchuk
 *  @date 2025-03-31
 */

fun main() {

    var x = 5
    do {
        println("do while $x")
        x--
    } while (x > 0)

    x = 0
    while (x < 10) {
        x++
        println("while $x")
    }
}

