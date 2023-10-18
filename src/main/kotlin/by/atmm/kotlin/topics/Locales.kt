package by.atmm.kotlin.topics

import java.util.*

/**
 *  @author Andrei Slesarchuk
 *  @date 2023-10-17
 */

fun main() {

    val localeFRANCE = Locale.FRANCE
    val localeEnglish = Locale.ENGLISH
    Locale.setDefault(Locale("ru"))

    println("Default locale is ${Locale.getDefault()}")
    println("France locale is $localeFRANCE")
    println("English locale is $localeEnglish")

}

