package by.atmm.kotlin.topics

import kotlin.math.min

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-08-27
 */

var name: String? = null

fun main() {

    name = "Andrey"
    // if name is null then "let" will not run
    name?.let {
        if (it.length > 5) {
            println("The length of name greater than 5")
        } else {
            println("The length of name less than 5 or equal")
        }
    }

    val list = mutableListOf<Int>()
    with(list) {
        for (i in 0 until 1000) {
            add((Math.random() * 100).toInt())
        }
//        println("Sum: ${sum()} Average: ${average()} Min: ${min()} Max: ${max()} First: ${first()} Last: ${last()}  ")
    }

//    println("${list.sum()} ${list.average()} ${list.min()} ${list.max()} ${list.first()} ${list.last()}")

    val obj = mutableMapOf<String, String>()
    obj["1"] = "One"
    obj["2"] = "Two"
    obj["3"] = "Three"

    myWith(obj) {
        keys
        values.stream()
        for (v in values) {
            println(v)
        }
    }
}

inline fun <T, R> myWith(obj: T, operation: T.() -> R): R {
    return obj.operation()
}