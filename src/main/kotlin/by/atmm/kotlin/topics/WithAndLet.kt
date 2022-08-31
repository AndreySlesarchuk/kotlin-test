package by.atmm.kotlin.topics

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
        }
    }

    val list = mutableListOf<Int>()
    with(list) {
        for (i in 0 until 1000) {
            add((Math.random() * 100).toInt())
        }

        println(sum())
        println(average())
        println(min())
        println(max())
        println(first())
        println(last())
    }

    for (i in 0 until 1000) {
        list.add((Math.random() * 100).toInt())
    }

    println(list.sum())
    println(list.average())
    println(list.min())
    println(list.max())
    println(list.first())
    println(list.last())




}