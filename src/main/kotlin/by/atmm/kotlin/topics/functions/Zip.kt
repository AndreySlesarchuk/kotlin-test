import by.atmm.kotlin.topics.functions.showList
import by.atmm.kotlin.topics.functions.showListWithHeader

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-08-29
 */

fun main() {
    val names = mutableListOf<String>()
    val phones = mutableListOf<Long>()
    val fullNames = mutableListOf<String>()

    for (i in 0..10) {
        names.add("Name$i")
        phones.add(375_00_000_00_00 + (Math.random() * 1_000_000_000).toLong())
    }

    val users = names.zip(phones)
    showList(users)

    for (i in 0..10) {
        fullNames.add("Name$i LastName$i")
    }
    val names2 = fullNames.map { it.substringBefore(" ") }.toMutableList()
    val lastNames = fullNames.map { it.substringAfter(" ") }
    val users2 = fullNames
        .map { Pair(it.substringBefore(" "), it.substringAfter(" ")) }
    showListWithHeader("Names: ", names2)
    showListWithHeader("Last names: ", lastNames)
    showListWithHeader("Users2: ", users2)

}