package by.atmm.kotlin.topics.classes.player

fun main() {

    val player = Player("Andrei")
    player.score = -1
    println("Player: ${player.name}, score: ${player.score}" )

    println("Player: ${player.name}, roll dice: ${player.rollDice()}" )
}