package by.atmm.kotlin.topics.classes.player

import java.util.*

class Player(name: String) {
    val name = name
        get() = field.uppercase(Locale.getDefault())
    var score: Int = 0
        set(value) {
            println(value)
            field = if (value >= 0) value else 0
        }

    // class members and functions
}