package by.atmm.kotlin.topics.classes.worker

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-09-03
 */

class Programmer(name: String, age: Int, val language: String) : Worker(name, age, "", 2018) {
    override fun work() {
        println("Write cod in $language")
    }
}