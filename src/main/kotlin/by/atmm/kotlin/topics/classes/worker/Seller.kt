package by.atmm.kotlin.topics.classes.worker

class Seller(name: String, age: Int)
    : WorkerAbstract(name, age), Cleaner {
    override fun work() {
        println("Sell goods")
    }

    override fun clean() {
        println("Seller is cleaning")
    }
}