/**
 *  @author Andrey Slesarchuk
 *  @date 2022-08-30
 */

fun main() {
    val data = mapOf(
        "January" to listOf(101, 100, 100, 100),
        "February" to listOf(100, 300, -100, 100),
        "March" to listOf(100, 100, 100, 100),
        "April" to listOf(100, 113, 100, 100),
        "May" to listOf(100, 100, 100, 100),
        "Jun" to listOf(100, 100, 150, 100),
        "July" to listOf(100, 100, 100, 100),
        "August" to listOf(100, 114, 100, 100),
        "September" to listOf(100, 100, 100, 100),
        "October" to listOf(100, 200, 100, 100),
        "November" to listOf(100, 100, 200, 100),
        "December" to listOf(100, 100, 100, 100)
    )

    printInfo(data)
}

fun printInfo(data: Map<String, List<Int>>) {
    val validData = data.filterNot {
        it.value.any {
            it < 0
        }
    }
    val averageWeek = validData.flatMap {
        it.value
    }.average()
    println("Average revenue peer week: $averageWeek")

    val listOfSum = validData.map {
        it.value.sum()
    }
    val max = listOfSum.max()
    val min = listOfSum.min()
    val averageMonth = listOfSum.average()

    val maxMonth = validData
        .filter { it.value.sum() == max }.keys
    val minMonth = validData
        .filter { it.value.sum() == min }.keys

    println("Average revenue per month: $averageMonth")
    println("Maximum revenue per month: $max")
    print(" was in the following months: ")
    maxMonth.forEach { print(" $it") }
    println()
    println("Minimum revenue per month: $min")
    print(" was in the following months: ")
    minMonth.forEach { print(" $it") }
    println()
}