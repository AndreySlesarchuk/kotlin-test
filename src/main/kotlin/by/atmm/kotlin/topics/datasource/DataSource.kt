package by.atmm.kotlin.topics.datasource

interface DataSource {
    fun writeData(data: String)
    fun readData(): String
}