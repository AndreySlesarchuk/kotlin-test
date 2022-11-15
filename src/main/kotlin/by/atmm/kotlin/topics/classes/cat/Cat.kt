package by.atmm.kotlin.topics.classes.cat

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-09-01
 */

class Cat(val name: String, var age: Int, val weight: Float= 0f) {

    val isOld: Boolean
        get() = age >= 12

//    fun printInfo() {
//        println("Nikname: $name Age: $age Weight: $weight")
//    }
}

