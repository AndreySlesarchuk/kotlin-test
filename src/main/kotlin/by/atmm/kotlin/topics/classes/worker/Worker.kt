package by.atmm.kotlin.topics.classes.worker

import java.util.Calendar

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-09-01
 */

class Worker(val name: String, val position: String, val startYear: Int) {
    val expirience: Int
        get() = Calendar.getInstance().get(Calendar.YEAR) - startYear

//    fun printInfo() {
//        println("Working")
//    }
}

