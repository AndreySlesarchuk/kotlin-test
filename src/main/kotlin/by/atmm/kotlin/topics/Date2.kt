package by.atmm.kotlin.topics

import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

fun main() {
    val tZ1 = TimeZone.getTimeZone("America/Chicago")
    val tZ2 = TimeZone.getTimeZone("Europe/Warsaw")

    val lDT = LocalDateTime.parse("2023-05-05T16:03:22")
    println("Test hour:${lDT.withHour(9).withMinute(15).withSecond(10)}")
    println(
        "Convert lDT with tZ1 to milliseconds: " +
                "${localDateTimeToMillis(lDT, tZ1, 1020)}"
    )

    println(
        "Convert lDT with tZ2 to milliseconds: " +
                "${localDateTimeToMillis(lDT, tZ2, 1035)}"
    )

    println(
        "minutes from the beginning of the day ${
            getDayMinutes(
                Date(),
                null
            )
        } here ${TimeZone.getDefault()} "
    )

    println(
        "minutes from the beginning of the day ${
            getDayMinutesV2(
                Date(),
                tZ1.toZoneId()
            )
        }  there $tZ1 "
    )

    println(
        "minutes from the beginning of the day ${
            getDayMinutes(
                Date(),
                tZ2.toZoneId()
            )
        }  there $tZ2 "
    )

}

private fun localDateTimeToMillis(
    date: LocalDateTime,
    timeZone: TimeZone,
    minutes: Int
): Long {
    return date
        .withHour(minutes / 60)
        .withMinute(minutes % 60)
        .withSecond(0)
        .atZone(timeZone.toZoneId())
        .toInstant()
        .toEpochMilli()
}


private fun getDayMinutes(date: Date, zoneId: ZoneId?): Int {
    val localDateTime = dateToLocalDateTime(date, zoneId)
    return localDateTime.hour * 60 + localDateTime.minute
}

fun getDayMinutesV2(date: Date, zoneId: ZoneId?): Int {
    return dateToLocalDateTime(date, zoneId).toLocalTime().toSecondOfDay() / 60
}


private fun dateToLocalDateTime(date: Date, zoneId: ZoneId?): LocalDateTime {

    return LocalDateTime.ofInstant(date.toInstant(), zoneId ?: ZoneId.systemDefault())

}

private fun localDateTimeToDate(localDateTime: LocalDateTime, zoneId: ZoneId?): Date? {

    return Date.from(localDateTime.atZone(zoneId ?: ZoneId.systemDefault()).toInstant())

}
