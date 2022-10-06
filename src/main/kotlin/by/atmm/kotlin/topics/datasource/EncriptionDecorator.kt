package by.atmm.kotlin.topics.datasource

import java.util.*

class EncryptionDecorator(source: DataSource) : DataSourceDecorator(source) {

    override fun writeData(data: String) {
        super.writeData(encode(data))
    }

    override fun readData(): String {
        return decode(super.readData())
    }

    private fun encode(data: String): String {
        val result = data.toByteArray()
        for (i in result.indices) {
            result[i].inc()
        }
        return Base64.getEncoder().encodeToString(result)
    }

    private fun decode(data: String): String {
        val result = Base64.getDecoder().decode(data)
        for (i in result.indices) {
            result[i].dec()
        }
        return String(result)
    }
}