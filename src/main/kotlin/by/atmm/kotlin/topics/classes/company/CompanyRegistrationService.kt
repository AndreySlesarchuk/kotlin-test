package by.atmm.kotlin.topics.classes.company

import java.time.LocalDateTime

class CompanyRegistrationService {

    private val defaultSms = "0000"
    private val numberOfAttemptsMax = 2
    private val periodOfTimesMax = 1L

    fun companyRegister(companyRegistrationRo: CompanyRegistrationRo) {
        println("company register ${validateData(companyRegistrationRo)}")
    }

    private fun validateData(itemRO: CompanyRegistrationRo): CompanyRegistrationRo? {
        val eventDateTime = LocalDateTime.now()
        if (itemRO.phoneNumber.isEmpty()) return null
        val companyRegistrationExist = fetchCompanyRegistration(
            itemRO.phoneNumber
        )
        return if (companyRegistrationExist == null) {
            if (itemRO.isSendNewSms)
                createCompanyRegistration(eventDateTime, itemRO.phoneNumber)
            else
                CompanyRegistrationRo(itemRO.phoneNumber, itemRO.sms, false, "validateData: No action provided")
        } else {
            if (itemRO.isSendNewSms) {
                deleteCompanyRegistration(itemRO.phoneNumber)
                createCompanyRegistration(eventDateTime, itemRO.phoneNumber)
            } else {
                if (companyRegistrationExist.numberOfAttempts > numberOfAttemptsMax) {
                    deleteCompanyRegistration(itemRO.phoneNumber)
                    return CompanyRegistrationRo(itemRO.phoneNumber, itemRO.sms, false, "validateData: Number of attempts completed")
                }
                if (companyRegistrationExist.smsTime.plusMinutes(periodOfTimesMax) < eventDateTime) {
                    deleteCompanyRegistration(itemRO.phoneNumber)
                    return CompanyRegistrationRo(itemRO.phoneNumber, itemRO.sms, false, "validateData: Validation time expired")
                }
                return if (itemRO.sms == companyRegistrationExist.smsMain) {
                    deleteCompanyRegistration(itemRO.phoneNumber)
                    CompanyRegistrationRo(itemRO.phoneNumber, itemRO.sms, false, "validateData: Sms code is correct")
                } else {
                    deleteCompanyRegistration(itemRO.phoneNumber)
                    companyRegistrationExist.numberOfAttempts += 1
                    CompanyRegistrationData.insertData(companyRegistrationExist)
                    CompanyRegistrationRo(itemRO.phoneNumber, itemRO.sms, false, "validateData: Invalid sms code")
                }
            }
        }
    }

    private fun deleteCompanyRegistration(phoneNumber: String) {
        CompanyRegistrationData.deleteData(phoneNumber)
    }

    private fun fetchCompanyRegistration(phoneNumber: String): CompanyRegistration? {
        return CompanyRegistrationData.findData(phoneNumber)
    }

    private fun createCompanyRegistration(eventDate: LocalDateTime, phoneNumber: String): CompanyRegistrationRo {
        val companyRegistration = CompanyRegistration(phoneNumber, defaultSms, eventDate, 0)
        CompanyRegistrationData.insertData(companyRegistration)
        return CompanyRegistrationRo(
            companyRegistration.phoneNumber, companyRegistration.smsMain, true, "createCompanyRegistration: Success"
        )
    }
}
