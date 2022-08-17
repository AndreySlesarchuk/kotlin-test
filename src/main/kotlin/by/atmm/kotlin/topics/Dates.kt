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
    val date = Date(1642302800000L)
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

    val localDateTime1 = LocalDateTime.of(2008, Month.OCTOBER, 10, 23, 10, 0)

    println(" date is: $date")
    println(" localDate1 is $localDate1 day1Start: $startOfDay1 day1End: $endOfDate1")
    println(" localDate2 is $localDate2 day2Start: $startOfDay2")
    println(" localDate3 is $localDate3 day3Start: $startOfDay3 day3End: $endOfDate3")
    println(" localDate4 is $localDate4 localDate5 is: $localDate5")
    println(" localDateTime1 is $localDateTime1")

    iterateBetweenDates(localDate2, localDate2.plusDays(5))

    val now = LocalDateTime.now(ZoneId.systemDefault())
    val milliseconds = now.atZone(ZoneId.systemDefault())?.toInstant()?.toEpochMilli()

    val dateFromMillis: Long? = LocalDateTime.now().toMillis()
    val dateToMillis: Long? = LocalDateTime.now().minusDays(7).toMillis()
    println(" dateFromMillis is $dateFromMillis dateToMillis: $dateToMillis")
    val dateFrom: Date = Date.from(Instant.ofEpochMilli(dateFromMillis!!))
    val dateTo: Date = Date.from(Instant.ofEpochMilli(dateToMillis!!))
    println(" dateFrom is $dateFrom dateTo: $dateTo")
    println(" milliseconds is $milliseconds")
    println(" localDateTime is $now")

}

fun LocalDateTime.toMillis(zone: ZoneId = ZoneId.systemDefault()) = atZone(zone)?.toInstant()?.toEpochMilli()

fun iterateBetweenDates(start: LocalDate, end: LocalDate?) {
    var date = start
    while (date.isBefore(end)) {
        println(date)
        date = date.plusDays(1)
    }
}