package by.atmm.kotlin.topics.classes.transport

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-09-07
 */

class Bike : Transport("Bike") {
    override fun drive() {
        println("A bike is driving")
    }
}