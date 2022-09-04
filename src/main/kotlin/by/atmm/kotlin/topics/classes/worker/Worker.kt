package by.atmm.kotlin.topics.classes.worker

import java.util.Calendar

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-09-01
 */

open class Worker(val name: String, val age: Int, val position: String, val startYear: Int) {
    open fun work() {
        println("Working")
    }

    val expirience: Int
        get() = Calendar.getInstance().get(Calendar.YEAR) - startYear

//    fun printInfo() {
//        println("Working")
//    }
}

