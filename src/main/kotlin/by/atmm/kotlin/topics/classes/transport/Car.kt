package by.atmm.kotlin.topics.classes.transport

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-09-07
 */

class Car(override var name: String = "Car") : Transport(name) {
    override fun drive() {
        println("A car is driving")
    }

    fun startEngine(): Boolean {
        println("Start engine...")
        return true
    }

}