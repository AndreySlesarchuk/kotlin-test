package by.atmm.kotlin.topics.classes.company

import java.time.LocalDateTime

object CompanyRegistrationData {

    const val DB_NAME = "companyRegistrationData.db"
    val version: LocalDateTime = LocalDateTime.now()
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