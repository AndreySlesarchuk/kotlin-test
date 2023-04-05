package by.atmm.kotlin.topics.classes.waterboy

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-09-07
 */

fun main() {

    val sportsman = Sportsman()
    sportsman.invokeWaterBoy(object : WaterBoy {
        override fun bringWater() {
            println("Water brought!")
        }
    })

    sportsman.invokeWaterBoy { println("Water2 brought!") }

}