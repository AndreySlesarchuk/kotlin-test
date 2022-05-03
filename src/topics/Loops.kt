package topics

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-05-03
 */

fun main() {
    val items = listOf("apple", "banana", "orange") // List.of() Java 9
    val items2 = mutableListOf("carrot", "potato", "onion") // ArrayList
    items2.add("cucumber")

    // for
    for (item in items2)
        println(item)

    // while
    var index = 0
    while (index < items2.size)
        println("Item at $index is ${items2[index++]}") // println(items2[index++])

    // Ranges
    println("Is orange in items: ${"orange" in items}")

    for (i in 3..10)
        println(i)

    for (i in 1 until 10)
        println(i)

    for (i in 20 downTo 10)
        println(i)

    for (i in 0..100 step 10)
        println(i)

}