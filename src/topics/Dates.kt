package topics

import java.time.*
import java.util.*

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-05-05
 */

fun main() {

    val localDate1 = LocalDate.now()
    val localDate2 = LocalDate.parse("2002-10-13")

    // from Date
    val date = Date()
    val localDate3: LocalDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
    val localDate4 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
    val localDate5 = Instant.ofEpochMilli(date.time).atZone(ZoneId.systemDefault()).toLocalDate()

    // from LocalDate
    val startOfDay1: LocalDateTime = localDate1.atStartOfDay()
    val startOfDay2 = LocalDateTime.of(localDate2, LocalTime.MIDNIGHT)
    val endOfDate1 = LocalTime.MAX.atDate(localDate1)

    // from LocalDateTime
    val startOfDay3 = localDate3.toLocalDate().atTime(LocalTime.MIN)
    val endOfDate3 = localDate3.toLocalDate().atTime(LocalTime.MAX)

    println(" localDate1 is $localDate1 day1Start: $startOfDay1 day1End: $endOfDate1")
    println(" localDate2 is $localDate2 day2Start: $startOfDay2")
    println(" localDate3 is $localDate3 day3Start: $startOfDay3 day3End: $endOfDate3")
    println(" localDate4 is $localDate4 localDate5 is: $localDate5")

    iterateBetweenDates(localDate2, localDate2.plusDays(5))

}

fun iterateBetweenDates(start: LocalDate, end: LocalDate?) {
    var date = start
    while (date.isBefore(end)) {
        println(date)
        date = date.plusDays(1)
    }
}