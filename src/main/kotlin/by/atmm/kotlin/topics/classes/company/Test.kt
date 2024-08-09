package by.atmm.kotlin.topics.classes.company

fun main() {

    val testData = CompanyRegistrationRo("+375293237573", "")
    val companyRegistrationService: CompanyRegistrationService = CompanyRegistrationService()
    companyRegistrationService.companyRegister(testData)
    companyRegistrationService.companyRegister(testData)

}