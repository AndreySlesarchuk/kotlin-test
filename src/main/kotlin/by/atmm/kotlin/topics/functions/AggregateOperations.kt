/**
 *
 *  https://www.baeldung.com/kotlin/aggregate-operations
 *  @date 2022-12-14
 */

fun main() {
    val numbers = listOf(1, 15, 3, 8)
    val count = numbers.count()  // 4
    val sum = numbers.sum()  // 27
    val average = numbers.average() // 6.75
    val sumBy = numbers.sumOf { it * 5 } // 135
    val sumByDouble = numbers.sumOf { it.toDouble() / 8 }


}