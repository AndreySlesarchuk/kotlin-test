package by.atmm.kotlin.topics.classes.company

import java.time.LocalDateTime

object CompanyRegistrationData {

    val name = "companyRegistrationData.db"
    val version = LocalDateTime.now()
    val data = mutableListOf<CompanyRegistration>()

    fun insertData(item: CompanyRegistration) {
        data.add(item)
    }

    fun findData(phoneNumber: String): CompanyRegistration? {
        return data.find { it.phoneNumber == phoneNumber}
    }

    fun deleteData(phoneNumber: String) {
        data.removeIf { it.phoneNumber == phoneNumber }
    }

}