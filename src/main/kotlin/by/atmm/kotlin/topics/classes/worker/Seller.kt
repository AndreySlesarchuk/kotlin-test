package by.atmm.kotlin.topics.classes.worker

class Seller(name: String, age: Int) : WorkerAbstract(name, age) {
    override fun work() {
        println("Sell goods")
    }
}