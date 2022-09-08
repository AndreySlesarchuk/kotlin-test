package by.atmm.kotlin.topics.classes.calculate

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-09-08
 */

class Calc {
    companion object {
        const val PI = 3.14
        fun square(num: Int) = num * num
        fun lenghtOfCircle(radius: Float) = 2 * PI * radius
    }
}