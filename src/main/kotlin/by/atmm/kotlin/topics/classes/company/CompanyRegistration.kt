package by.atmm.kotlin.topics.classes.company

import java.time.LocalDateTime

data class CompanyRegistration (
    val phoneNumber: String,
    val smsMain: String,
    val token: String,
    val eventTime : LocalDateTime,
    var numberOfAttempts : Int,
)