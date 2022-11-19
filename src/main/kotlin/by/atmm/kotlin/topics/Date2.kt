package by.atmm.kotlin.topics

import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

fun main() {

    println("minutes from the beginning of the day ${getDayMinutes(Date(), null)} here ${TimeZone.getDefault()} ")
    val timeZone1 = TimeZone.getTimeZone("America/Chicago")
    println("minutes from the beginning of the day ${getDayMinutes(Date(), timeZone1.toZoneId())}  there $timeZone1 ")
    val timeZone2 = TimeZone.getTimeZone("Europe/Warsaw")
    println("minutes from the beginning of the day ${getDayMinutes(Date(), timeZone2.toZoneId())}  there $timeZone2 ")

}

private fun getDayMinutes(date: Date, zoneId: ZoneId?): Int {

    val localDateTime = dateToLocalDateTime(date, zoneId)
    return localDateTime.hour * 60 + localDateTime.minute

}

private fun dateToLocalDateTime(date: Date, zoneId: ZoneId?): LocalDateTime {

    return LocalDateTime.ofInstant(date.toInstant(), zoneId ?: ZoneId.systemDefault())

}

private fun localDateTimeToDate(localDateTime: LocalDateTime, zoneId: ZoneId?): Date? {

    return Date.from(localDateTime.atZone(zoneId ?: ZoneId.systemDefault()).toInstant())

}
