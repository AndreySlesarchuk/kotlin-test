package by.atmm.kotlin.topics.classes.company

data class CompanyRegistrationRo(
    val phoneNumber: String = "",
    val sms: String = "",
    val isSendNewSms: Boolean = false,
    val note: String = ""
)