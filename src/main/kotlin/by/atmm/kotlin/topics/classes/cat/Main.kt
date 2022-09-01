package by.atmm.kotlin.topics.classes.cat

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-09-01
 */

fun main() {
    val cat = Cat("Kesha", 13, 3f)
    println(cat.isOld) // true
    cat.age = 10
    println(cat.isOld) // false
    cat.printInfo() // Nikname: Kesha Age: 10 Weight: 3.0
}

// class functions extend. without access to the class.
fun Cat.printInfo() {
    println("Nikname: $name Age: $age Weight: $weight")
}