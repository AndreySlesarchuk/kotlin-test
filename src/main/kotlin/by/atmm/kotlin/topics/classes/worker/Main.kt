package by.atmm.kotlin.topics.classes.worker

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-09-01
 */

fun main() {
    val programmer = Worker("Mike", "Programmer", 2018)
    programmer.printInfo()
}

// class functions extend. without access to the class.
fun Worker.printInfo() {
    println("Name: $name Position: $position Experience: $expirience")
}