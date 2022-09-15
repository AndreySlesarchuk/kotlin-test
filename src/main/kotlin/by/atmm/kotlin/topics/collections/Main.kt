package by.atmm.kotlin.topics.collections

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-09-08
 */

fun main() {
    val list = MyArrayList.myListOf("A", "B", "C", 1,2,3)

    for (i in 0 until list.size()) {
        println(list.get(i))
    }

    for (i in 0..100) {
        list.add("$i")
    }

    for (i in 0..90) {
        list.removeAt(0)
    }
    for (i in 0 until list.size()) {
        println(list.get(i))
    }
}