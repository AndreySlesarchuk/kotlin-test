package tasks

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-05-09
 */

fun main() {
    // Get the most common word
    // input: text
    // output: word

    val text =
        "Java has 51 keywords in total. Null, true, and false might seem like keywords but they are not in Java. Java and Kotlin are good languages"
    println(getFrequentWord(text))
}

fun getFrequentWord(text: String): String? {
    val testMap = mutableMapOf<String, Int>()
    text.split(" ", ".").groupBy { it }.map { w -> testMap.put(w.key, w.value.size) }
    return testMap.maxByOrNull { it.value }?.key
}
