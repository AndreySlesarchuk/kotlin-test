package by.atmm.kotlin.topics.classes.company

fun main() {
    val phoneNumber = "+375123456789"
    val testCreate = CompanyRegistrationRo(phoneNumber, "", true, "")
    val testWrongSms = CompanyRegistrationRo(phoneNumber, "1111", false, "")
    val testValidSms = CompanyRegistrationRo(phoneNumber, "0000", false, "")
    val testEmpty = CompanyRegistrationRo("", "", true, "")
    val companyRegistrationService: CompanyRegistrationService = CompanyRegistrationService()
    println("CompanyRegistrationData: ${CompanyRegistrationData.DB_NAME}")
    println("CompanyRegistrationData version: ${CompanyRegistrationData.version}")
    // create data
    companyRegistrationService.companyRegister(testCreate)
    // check with wrong sms
    companyRegistrationService.companyRegister(testWrongSms)
    // check with valid sms
    companyRegistrationService.companyRegister(testValidSms)
    // check nothing to do
    companyRegistrationService.companyRegister(testValidSms)
    // check with empty data
    companyRegistrationService.companyRegister(testEmpty)
    // check number of attempts
    companyRegistrationService.companyRegister(testCreate)
    for (i in 1..4) {
        companyRegistrationService.companyRegister(testWrongSms)
    }
    companyRegistrationService.companyRegister(testValidSms)
    companyRegistrationService.companyRegister(testWrongSms)
}