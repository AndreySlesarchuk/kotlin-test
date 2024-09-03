package by.atmm.kotlin.topics.classes.company

data class CompanyRegistrationRo(
    var phoneNumber: String = "",
    var sms: String = "",
    var token: String = "",
    var isSendNewSms: Boolean = false,
    var note: String = ""
) {
    constructor(item: CompanyRegistration) : this() {
        this.phoneNumber = item.phoneNumber
        this.sms = item.smsMain
        this.token = item.token
    }
}