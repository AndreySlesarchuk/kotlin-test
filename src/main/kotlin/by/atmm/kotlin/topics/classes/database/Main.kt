package by.atmm.kotlin.topics.classes.database

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-09-08
 */

fun main() {

    val db2 = Database
    db2.insertData("1")
    db2.insertData("2")
    val test = Test()
    test.insertTestDataV2("3")
    test.insertTestDataV2("4")

    val db = DatabaseClass.getInstance()
    db.insertData("1")
    db.insertData("2")

    test.insertTestData("3")
    test.insertTestData("4")
    db.data.forEach { print(it) }
    println()

    println("Database: ${db2.name}, version: ${db2.version}")
    for (str in db2.data) {
        println(str)
    }

}