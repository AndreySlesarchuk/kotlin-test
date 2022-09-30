package main.java.by.atmm.kotlin.tasks

import java.util.*

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

    val result = text
        .lowercase(Locale.getDefault())
        .split("\\W+|\\s+".toRegex())
        .groupingBy { it }
        .eachCount()
        .maxByOrNull { it.value }
        ?.key
    return result

}
