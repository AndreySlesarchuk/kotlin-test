package by.atmm.kotlin.topics.classes.worker

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-09-04
 */

fun main() {

    val workersAbstract = mutableListOf<WorkerAbstract>()
    workersAbstract.add(Seller("Egor", 27))
    workersAbstract.add(Seller("Ivan", 30))
    workersAbstract.add(Seller("Sergey", 34))

    for (worker in workersAbstract) {
        worker.work()
    }

    val workers = mutableListOf<Worker>()
    workers.add(Worker("Egor", 27, "", 2018))
    workers.add(Worker("Ivan", 30, "", 2018))
    workers.add(Worker("Sergey", 34, "", 2018))
    workers.add(Programmer("Mike", 13, "Kotlin"))
    workers.add(Programmer("Andrey", 49, "Java"))

    for (worker in workers) {
        worker.work()
    }


    val programmer = Worker("Mike", 13, "Programmer", 2018)
    programmer.printInfo()
}

// class functions extend. without access to the class.
fun Worker.printInfo() {
    println("Name: $name Position: $position Experience: $expirience")
}