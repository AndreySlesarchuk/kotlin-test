package by.atmm.kotlin.topics.classes.company

import java.time.LocalDateTime

class CompanyRegistrationService {
    private val smsMain = "1111"
    private val numberOfAttemptsMax = 5
    private val periodOfTimesMax = 5L

    fun companyRegister(companyRegistrationRo: CompanyRegistrationRo) {
        println("company register ${validateData(companyRegistrationRo)}")
    }

    private fun validateData(companyRegistrationRo: CompanyRegistrationRo): CompanyRegistrationRo? {
        val eventDate = LocalDateTime.now()
        if (companyRegistrationRo.phoneNumber.isEmpty()) return null
        val companyRegistration = fetchCompanyRegistration(companyRegistrationRo.phoneNumber)
        return if (companyRegistration == null) {
            createCompanyRegistration(eventDate, companyRegistrationRo.phoneNumber)
        } else {
            if (companyRegistration.numberOfAttempts > numberOfAttemptsMax) return null
            return if (companyRegistration.smsTime.plusMinutes(periodOfTimesMax).isBefore(eventDate)) {
                if (companyRegistrationRo.sms.isEmpty()) return null
                if (companyRegistrationRo.sms == companyRegistration.smsMain)
                    CompanyRegistrationRo(companyRegistration.phoneNumber, companyRegistration.smsMain)
                else null
            } else {
                return null
            }
        }
    }

    private fun fetchCompanyRegistration(phoneNumber: String): CompanyRegistration? {
        return CompanyRegistrationData.findData(phoneNumber)
    }

    private fun createCompanyRegistration(eventDate: LocalDateTime, phoneNumber: String): CompanyRegistrationRo {
        val companyRegistration = CompanyRegistration(
            phoneNumber, smsMain, LocalDateTime.now(), 0
        )
        CompanyRegistrationData.insertData(companyRegistration)
        return CompanyRegistrationRo(
            companyRegistration.phoneNumber, companyRegistration.smsMain
        )
    }

}