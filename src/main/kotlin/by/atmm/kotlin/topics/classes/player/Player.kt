package by.atmm.kotlin.topics.classes.player

import java.util.*
import kotlin.random.Random

class Player(name: String): DiceRoller {
    val name = name
        get() = field.uppercase(Locale.getDefault())
    var score: Int = 0
        set(value) {
            println(value)
            field = if (value >= 0) value else 0
        }

    override fun rollDice(): Int {
        return Random.nextInt(0,6)
    }

    // class members and functions
}