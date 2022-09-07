package by.atmm.kotlin.topics.classes.waterboy

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-09-07
 */

class Sportsman {
    fun invokeWaterBoy(waterBoy: WaterBoy) {
        waterBoy.bringWater()
    }

    inline fun invokeWaterBoy(bringWater: () -> Unit) {
        bringWater()
    }

}
