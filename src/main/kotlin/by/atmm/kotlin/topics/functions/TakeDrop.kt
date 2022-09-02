import by.atmm.kotlin.topics.functions.showListWithHeader

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-08-30
 */

fun main() {
    val array = (0..50).toList()
    val employees = array.map { "Employee № $it" }
    val first30 = employees.take(30)
    showListWithHeader("take 30 : ", first30)
    val last30 = employees.takeLast(30)
    showListWithHeader("take last 30 : ", last30)
    val drop30 = employees.drop(30)
    showListWithHeader("drop 30 : ", drop30)
    val dropLast30 = employees.dropLast(30)
    showListWithHeader("drop last 30 : ", dropLast30)

    var array2 = generateSequence(0) {
        println(" generated: ${it + 2}")
        it + 2
    }
    var evenList = array2.take(10)
    for (i in evenList) {
        print(" $i")
    }

    array2 = generateSequence {
        (Math.random() * 100).toInt()
    }
    evenList = array2.take(10)
    for (i in evenList) {
        print(" $i")
    }

}