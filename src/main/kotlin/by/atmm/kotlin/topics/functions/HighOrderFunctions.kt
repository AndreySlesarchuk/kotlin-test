package by.atmm.kotlin.topics.functions

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-08-29
 */

fun main() {

    val initArray = mutableListOf<Int>()
    for (i in 0..100) {
        initArray.add((Math.random() * 1000).toInt())
    }
    val result = initArray
        .filter { it % 5 == 0 || it % 3 == 0 }
        .map { it * it }
        .sortedDescending()
        .map { "$it" }
    showList(result)

    val listOfNumbers = mutableListOf<Int>()
    for (i in 0..99) {
        listOfNumbers.add(i)
    }
    //val listOfEvenNumbers = listOfNumbers.filter { a -> a % 2 == 0 }
    val listOfEvenNumbers = listOfNumbers.filter { it % 2 == 0 }
    showList(listOfEvenNumbers)

    val names = listOf("Mike", "Vasil", "Valentina", "Andrey")
    val namesStartsFromV = names.filter { it.startsWith("V") }
    showList(namesStartsFromV)

    val numbers = (0..100).toList()
    val doubledNumbers = numbers.map { it * 2 }
    showList(doubledNumbers)
    val employees = numbers.map { "Employee № $it " }
    showList(employees)
    showList(names.sortedDescending())

}