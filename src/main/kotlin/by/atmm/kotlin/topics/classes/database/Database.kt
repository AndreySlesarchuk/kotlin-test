package by.atmm.kotlin.topics.classes.database

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-09-08
 */

object Database {
    val name = "main2.db"
    val version = 2
    val data = mutableListOf<String>()

    fun insertData(str: String) {
        data.add(str)
    }
}