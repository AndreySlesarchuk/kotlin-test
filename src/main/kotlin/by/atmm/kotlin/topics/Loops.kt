package topics

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-05-03
 */

fun main() {

    val array = arrayOfNulls<Int?>(101)
    for (i in 0 until array.size) array[i] = i
    for ((index, i) in array.withIndex()) {
        array[index] = i?.times(2)
    }
    for (i in array) print(i)
    println()
    println("-----------------------------------------------------------------")
    val arr = arrayOfNulls<Int?>(301)
    for ((index, i) in (300..600).withIndex()) {
        arr[index] = i
    }
    for (i in arr.size - 1 downTo 0 step 5) print(i)
    println()
    println("-----------------------------------------------------------------")

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