package by.atmm.kotlin.topics.functions

/**
 *  @author Andrei Slesarchuk
 *  @date 2025-08-23
 */

fun main() {
    displayMsg { morning() }
    displayMsg(::evening)
}

fun displayMsg(mes: () -> Unit) {
    mes()
}

fun morning() {
    println("Good Morning")
}

fun evening() {
    println("Good Evening")
}