package by.atmm.kotlin.topics.functions

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-05-03
 */

fun main() {
    val a = listOf(1, 2, 3, 4, 5)

    a.forEach { e -> println(e) }
    a.forEach { println(it) }

    println(a.map { e -> e * 2 })
    println(a.filter { e -> e % 2 == 0 })
    println(a.reduce { sum, i -> sum + i })

    println(a.sorted())
    println(a.sortedDescending())
    println(a.sortedBy { it })
    println(a.sortedByDescending { it })

    println(a.any { it > 10 }) // false
    println(a.all { it < 10 }) // true
    println(a.sum()) // 15

    // partitions
    val numbers = listOf(1, 3, -4, 2, -11, -5)
    val (positive, negative) = numbers.partition { it > 0 }
    println("positive is: ${positive.sorted()}") // [1, 2, 3]
    println("negative is: ${negative.sortedDescending()}") // [-4, -5, -11]

    // group by length
    val result = listOf("a", "b", "kotlin", "ba", "ccc", "ad").groupBy { it.length } // HashMap or LinkedHashMap
    println(result) // {1=[a, b], 6=[kotlin], 2=[ba, ad], 3=[ccc]}
    val longWordSize = result.maxOf { it.key }
    println(result.getValue(longWordSize)) // [kotlin]

    // group by value
    val longString =
        "Java has 51 keywords in total. Null, true, and false might seem like keywords but they are not in Java. Java and Kotlin are good languages"
    val wordGroups = longString.split(" ", ".").groupBy { it }
    val wordMap = mutableMapOf<String, Int>()
    wordGroups.map { w -> wordMap.put(w.key, w.value.size) }
    println("wordGroups is: $wordGroups") // {1=[a, b], 6=[kotlin], 2=[ba, ad], 3=[ccc]}

    val frequentlyWordCount = wordGroups.maxOf { it.value.size }
    println("Max word common count: $frequentlyWordCount")
    println("And this first word is: ${wordMap.maxByOrNull { it.value }?.key}")

    val testMap = mutableMapOf<String, Int>()
//    longString.split(" ", ".").groupBy { it }.map { w -> testMap.put(w.key, w.value.size) }
    longString.split(" ", ".").groupBy { it }.map { testMap.put(it.key, it.value.size) }
    println("Test word is: ${testMap.maxByOrNull { it.value }?.key}")

    val words = longString.split("\\W+|\\s+".toRegex())
    val wordToCount = words.groupingBy { it }.eachCount()
    val resultWord = wordToCount.maxByOrNull { it.value }?.key
    println("Test word2 is: ${resultWord}")

}