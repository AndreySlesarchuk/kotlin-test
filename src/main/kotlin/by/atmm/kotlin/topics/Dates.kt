package topics

import org.apache.poi.ss.usermodel.DateUtil.toLocalDateTime
import java.time.*
import java.time.temporal.ChronoUnit
import java.util.*


/**
 *  @author Andrey Slesarchuk
 *  @date 2022-05-05
 */

fun main() {

    val nowTimeMinus5Minutes1 = Date.from(
        Instant.now().minusSeconds(300)
            .truncatedTo(ChronoUnit.MINUTES)
    )
    println(" nowTimeMinus5Minutes1 is: $nowTimeMinus5Minutes1")

    val nowTimeMinus5Minutes2 = ZonedDateTime.of(toLocalDateTime(Date()), ZoneOffset.UTC)
        .truncatedTo(ChronoUnit.MINUTES).minusMinutes(5)

    println(" nowTimeMinus5Minutes2 is:  $nowTimeMinus5Minutes2")

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

    // https://code.luasoftware.com/tutorials/kotlin/localdatetime-to-timestamp-epoch-milliseconds/
    val now = LocalDateTime.now(ZoneId.systemDefault())
    val milliseconds = now.atZone(ZoneId.systemDefault())?.toInstant()?.toEpochMilli()
    val millisecondsOfCurrentTime = LocalDateTime.now().atZone(ZoneId.systemDefault())?.toInstant()?.toEpochMilli()

    val millisecondsOfStartCurrentDay = LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault())?.toInstant()?.toEpochMilli()

    val dateFromMillis: Long? = LocalDateTime.now().toMillis()
    val dateToMillis: Long? = LocalDateTime.now().minusDays(7).toMillis()
    println(" dateFromMillis is $dateFromMillis dateToMillis: $dateToMillis")
    val dateFrom: Date = Date.from(Instant.ofEpochMilli(dateFromMillis!!))
    val dateTo: Date = Date.from(Instant.ofEpochMilli(dateToMillis!!))

    println(" dateFrom is $dateFrom dateTo: $dateTo")
    println(" milliseconds is $milliseconds")
    println(" localDateTime is $now")
    println(" milliseconds of current time is $millisecondsOfCurrentTime")
    println(" milliseconds of start current day is $millisecondsOfStartCurrentDay")
    println(" date of current day is ${Date.from(Instant.ofEpochMilli(millisecondsOfStartCurrentDay!!))}")

}

fun LocalDateTime.toMillis(zone: ZoneId = ZoneId.systemDefault()) = atZone(zone)?.toInstant()?.toEpochMilli()

fun iterateBetweenDates(start: LocalDate, end: LocalDate?) {

    var date = start
    while (date.isBefore(end)) {
        println(date)
        date = date.plusDays(1)
    }

}

