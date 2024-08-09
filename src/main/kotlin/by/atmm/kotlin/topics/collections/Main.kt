package by.atmm.kotlin.topics.collections

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-09-08
 */

fun main() {
    val teeth = intArrayOf(
        11, 12, 13, 14, 15, 16, 17, 18, 21, 22, 23, 24, 25, 26, 27, 28, 31, 32, 33, 34, 35, 36, 37, 38, 51, 52, 53, 54, 55, 61, 62, 63, 64, 65, 71, 72, 73, 74,
        75, 81, 82, 83, 84, 85
    )

    println(teeth.size)

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