package by.atmm.kotlin.topics.classes.database

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-09-08
 */

class DatabaseClass private constructor() {
    val name= "main.db"
    val data = mutableListOf<String>()

    fun insertData(str: String) {
        data.add(str)
    }

    companion object {
        var db: DatabaseClass? = null

        fun getInstance(): DatabaseClass {
            db?.let {
                return it
            }
            val instance = DatabaseClass()
            db = instance
            return instance
        }
    }
}