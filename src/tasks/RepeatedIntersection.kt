package tasks

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-05-05
 */

fun main() {
    // get an array from the input data where the elements intersect and the minimum number of duplicates
    // input: [1, 2, 3, 2, 0, 2, 2] and [5, 1, 2, 3, 2]
    // result: [1, 2, 2, 3]

    val arr1 = intArrayOf(1, 2, 3, 2, 0, 2, 2)
    val arr2 = intArrayOf(5, 1, 2, 3, 2)

    println(getRepeatedIntersection(arr1, arr2))
}

fun getRepeatedIntersection(a1: IntArray, a2: IntArray): List<Int> {
    val s1 = a1.toHashSet()
    val s2 = a2.toHashSet()

    val result = mutableListOf<Int>()

    for (el in s1) {
        if (s2.contains(el)) {
            val numOfRepeats = minOf(a1.count { it == el }, a2.count { it == el })
            repeat(numOfRepeats) { result.add(el) }
        }
    }
    return result
}