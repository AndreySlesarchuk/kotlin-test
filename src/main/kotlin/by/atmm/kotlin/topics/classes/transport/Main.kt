package by.atmm.kotlin.topics.classes.transport

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-09-07
 */

fun main() {

    travel(object : Transport("Bus") {
        override fun drive() {
            println("Bus is driving...")
        }
    })

//    val testCar = Car()
//    travel(testCar)

    val car: Transport = Car()
    val bike: Transport = Bike()
    // if (car !is Car) return
    // if (car is Car && car.startEngine())
    // if (car !is Car || car.startEngine())
    if (car is Car) {
        car.name = "Car2"
    }
    bike.drive()

}

fun travel(transport: Transport) {
    transport.drive()
}