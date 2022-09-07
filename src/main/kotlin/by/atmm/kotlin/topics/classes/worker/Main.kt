package by.atmm.kotlin.topics.classes.worker

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-09-04
 */

fun main() {

    val workersA = mutableListOf<WorkerAbstract>()
    workersA.add(Seller("Egor", 27))
    workersA.add(Seller("Ivan", 30))
    workersA.add(Seller("Sergey", 34))
    workersA.add(Programmer("Mike", 13, "Kotlin"))
    workersA.add(Programmer("Andrey", 49, "Java"))
    workersA.add(Chief("Vasily", 74))

    val cleaners = workersA.filter {it is Cleaner}.map { it as Cleaner }
    cleaners.forEach { print(" ${it.clean()}") }
    println()

    for (worker in workersA) {
        worker.work()
        if (worker is Programmer) {
            println(worker.language)
        }
        if (worker is Cleaner) {
            worker.clean()
        }
    }

    val workers = mutableListOf<Worker>()
    workers.add(Worker("Egor", 27, "", 2018))
    workers.add(Worker("Ivan", 30, "", 2018))
    workers.add(Worker("Sergey", 34, "", 2018))

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