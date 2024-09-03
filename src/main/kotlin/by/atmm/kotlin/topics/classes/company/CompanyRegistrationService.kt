package by.atmm.kotlin.topics.classes.company

import java.time.LocalDateTime

class CompanyRegistrationService {

    private val defaultSms = "0000"
    private val defaultToken = "00000000"
    private val numberOfAttemptsMax = 2
    private val periodOfTimesMax = 1L

    fun companyRegister(companyRegistrationRo: CompanyRegistrationRo) {
        println("company register ${validateData(companyRegistrationRo)}")
    }

    private fun validateData(itemRO: CompanyRegistrationRo): CompanyRegistrationRo? {
        val eventDateTime = LocalDateTime.now()
        if (itemRO.phoneNumber.isEmpty()) return null
        val itemExist = fetchCompanyRegistration(itemRO.phoneNumber) ?: return handleCompanyRegistrationIsNotExist(eventDateTime, itemRO)
        if (itemRO.isSendNewSms) {
            deleteCompanyRegistration(itemRO.phoneNumber)
            return createCompanyRegistration(eventDateTime, itemRO.phoneNumber)
        }
        return if (itemExist.token != "") {
            handleVerification(eventDateTime, itemExist, itemRO)
        } else {
            handleRegistration(eventDateTime, itemExist, itemRO)
        }
    }

    private fun handleVerification(eventDateTime: LocalDateTime, item: CompanyRegistration, itemRO: CompanyRegistrationRo): CompanyRegistrationRo {
        return if (item.eventTime.plusMinutes(periodOfTimesMax) < eventDateTime) {
            deleteCompanyRegistration(itemRO.phoneNumber)
            CompanyRegistrationRo(itemRO.phoneNumber, itemRO.sms, "", false, "verification: Token time expired")
        } else {
            CompanyRegistrationRo(item.phoneNumber, item.smsMain, item.token, false, "verification: Token is good")
        }
    }

    private fun handleRegistration(eventDateTime: LocalDateTime, item: CompanyRegistration, itemRO: CompanyRegistrationRo): CompanyRegistrationRo {

        if (item.numberOfAttempts > numberOfAttemptsMax) {
            deleteCompanyRegistration(itemRO.phoneNumber)
            return CompanyRegistrationRo(itemRO.phoneNumber, itemRO.sms, "", false, "validateData: Number of attempts completed")
        }
        if (item.eventTime.plusMinutes(periodOfTimesMax) < eventDateTime) {
            deleteCompanyRegistration(itemRO.phoneNumber)
            return CompanyRegistrationRo(itemRO.phoneNumber, itemRO.sms, "", false, "validateData: Validation time expired")
        }
        return if (itemRO.sms == item.smsMain) {
            handleSmsIsValid(eventDateTime, item, itemRO)
        } else {
            handleSmsIsInvalid(item, itemRO)
        }

    }

    private fun handleCompanyRegistrationIsNotExist(eventDateTime: LocalDateTime, itemRO: CompanyRegistrationRo): CompanyRegistrationRo {
        return if (itemRO.isSendNewSms)
            createCompanyRegistration(eventDateTime, itemRO.phoneNumber)
        else
            CompanyRegistrationRo(itemRO.phoneNumber, itemRO.sms, "", false, "validateData: No action provided")
    }

    private fun handleSmsIsValid(eventDateTime: LocalDateTime, item: CompanyRegistration, itemRO: CompanyRegistrationRo): CompanyRegistrationRo {
        deleteCompanyRegistration(itemRO.phoneNumber)
        val companyVerification = CompanyRegistration(
            item.phoneNumber,
            "",
            defaultToken,
            eventDateTime,
            0
        )
        CompanyRegistrationData.insertData(companyVerification)
        val responseEntity = CompanyRegistrationRo(companyVerification)
        responseEntity.isSendNewSms = itemRO.isSendNewSms
        responseEntity.note = "validateData: Create company verification token"
        return responseEntity
    }

    private fun handleSmsIsInvalid(item: CompanyRegistration, itemRO: CompanyRegistrationRo): CompanyRegistrationRo {
        deleteCompanyRegistration(itemRO.phoneNumber)
        item.numberOfAttempts += 1
        CompanyRegistrationData.insertData(item)
        return CompanyRegistrationRo(
            itemRO.phoneNumber,
            itemRO.sms,
            "",
            false,
            "validateData: Invalid sms code"
        )
    }


    private fun deleteCompanyRegistration(phoneNumber: String) {
        CompanyRegistrationData.deleteData(phoneNumber)
    }

    private fun fetchCompanyRegistration(phoneNumber: String): CompanyRegistration? {
        return CompanyRegistrationData.findData(phoneNumber)
    }

    private fun createCompanyRegistration(eventDate: LocalDateTime, phoneNumber: String): CompanyRegistrationRo {
        val companyRegistration = CompanyRegistration(phoneNumber, defaultSms, "", eventDate, 0)
        CompanyRegistrationData.insertData(companyRegistration)
        return CompanyRegistrationRo(
            companyRegistration.phoneNumber, companyRegistration.smsMain, "", true, "createCompanyRegistration: Success"
        )
    }
}
