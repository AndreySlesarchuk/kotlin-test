package by.atmm.kotlin.topics.functions

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-08-30
 */

fun main() {

    val data = mapOf(
        "file1" to listOf(1, 2, 3, 4, 5),
        "file2" to listOf(6, 7, 88, -9, 0),
        Pair("file3", listOf(9, 8, 7, 6, 5))
    )

    val dataAverage = data.flatMap { it.value }.average()
    println("Data average: $dataAverage")

    val dataCheckAverage = data
        .filter { it.value.all { it > 0 } }.flatMap { it.value }.average()
    val dataCheckAverage2 = data
        .filterNot { it.value.any { it < 0 } }.flatMap { it.value }.average()
    println("Data check average : $dataCheckAverage")
    println("Data check average2: $dataCheckAverage2")

    val revenueByWeek = listOf(
        listOf(5, 7, 6, 4, 8),
        listOf(7, 3, 6, 4, 8),
        listOf(4, 4, 5, 6, 7),
        listOf(8, 3, 6, 4, 8)
    )

    val totalNew = revenueByWeek.flatten()
    //val totalNew = revenueByWeek.flatMap { it }

    val totalOld = mutableListOf<Int>()
    revenueByWeek.map {
        for (i in it) {
            totalOld.add(i)
        }
    }

    val average = totalNew.average()
    show(average)
    showListWithHeader("Total old array:", totalOld)
    showListWithHeader("Total new array:", totalOld)

}