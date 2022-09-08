package by.atmm.kotlin.topics.classes.database

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-09-08
 */

class Test {
    fun insertTestData(str: String) {
        DatabaseClass.getInstance().insertData(str)
    }

    fun insertTestDataV2(str: String) {
        Database.insertData(str)
    }

}