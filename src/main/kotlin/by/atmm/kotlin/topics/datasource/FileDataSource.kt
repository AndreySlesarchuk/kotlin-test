package by.atmm.kotlin.topics.datasource

import java.io.File
import java.io.FileOutputStream
import java.io.FileReader
import java.io.IOException

class FileDataSource(val name: String) : DataSource {

     override fun writeData(data: String) {
        val file = File(name)
        try {
            FileOutputStream(file).use { fos -> fos.write(data.toByteArray(), 0, data.length) }
        } catch (ex: IOException) {
            println(ex.message)
        }
    }

    override fun readData(): String {
        lateinit var buffer: CharArray
        val file = File(name)
        try {
            FileReader(file).use { reader ->
                buffer = CharArray(file.length().toInt())
                reader.read(buffer)
            }
        } catch (ex: IOException) {
            println(ex.message)
        }
        return String(buffer)
    }
}
