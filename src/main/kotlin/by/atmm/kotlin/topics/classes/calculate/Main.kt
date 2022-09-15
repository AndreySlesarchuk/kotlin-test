package by.atmm.kotlin.topics.classes.calculate

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-09-08
 */

fun main() {
    println(MyRandom.randomInt(20, 50))
    println(MyRandom.randomBoolean())
    println(MyRandom.randomDayOfWeek())
    println(MyRandom.getRandomString(5))
    println(MyRandom.getRandomString(16))

    println(Calc.square(2))
    println(Calc.lenghtOfCircle(3f))
}