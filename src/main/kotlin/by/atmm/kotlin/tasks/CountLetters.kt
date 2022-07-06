package main.java.by.atmm.kotlin.tasks

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-05-06
 */

fun main() {
    // get a string from the input string where will be letters with it's count repeating
    // input: AAAAAABBBBCCCDDEFFFFFFFF
    // result: A6B4C3D2EF8

    println(countLetters("AAAAAABBBBCCCDDEFFFFFFFF"))
}

fun countLetters(str: String): String {
    var result = ""
    var letter: Char = str.get(0)
    var count = 1
    for (ch in str.substring(1)) {
        if (ch != letter) {
            result += "$letter"
            if (count > 1) result += "$count"
            letter = ch
            count = 1
        } else {
            count++
        }
    }
    result += "${letter}"
    if (count > 1) result += "$count"
    return result
}