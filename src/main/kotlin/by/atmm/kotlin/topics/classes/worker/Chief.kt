package by.atmm.kotlin.topics.classes.worker

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-09-07
 */

class Chief(name: String, age: Int)

    : WorkerAbstract(name, age) {
    override fun work() {
        println("Process control")
    }

}