package by.atmm.kotlin.topics.classes.worker

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-09-03
 */

class Programmer(name: String, age: Int, val language: String)
    : WorkerAbstract(name, age), Cleaner {
    override fun work() {
        println("Write cod in $language")
    }

    override fun clean() {
        println("Programmer is cleaning")
    }
}