package main.java.by.atmm.kotlin.tasks

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-05-07
 */

fun main() {
    // group words by equal common letters
    // input: ["eat", "tea", "ten", "ate", "tan", "nat", "bat"]
    // result: [[eat, tea, ate], [ten], [tan, nat], [bat]]

    println(groupWords(arrayOf("eat", "tea", "ten", "ate", "tan", "nat", "bat")))
}

fun groupWords(words: Array<String>): List<List<String>> {
    val result: MutableList<List<String>> = mutableListOf()

    val map = mutableMapOf<String, MutableList<String>>()

    for (word in words) {
        val sortedWord = word.toCharArray().sorted().joinToString("")

        if (map.containsKey(sortedWord))
            map[sortedWord]?.add(word)
        else
            map[sortedWord] = mutableListOf(word)
    }

    for (entity in map) {
        result.add(entity.value)
    }

    return result
}