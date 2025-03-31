package by.atmm.kotlin.topics.textandpdf

fun main() {
    val hero = "Batman"
    println("Archenemy of $hero is ${archenemy(hero)}")

    println("From \"Alice's Adventures in Wonderland\"")
    println("""From "Alice's Adventures in Wonderland"""")

    println(
        "Twinkle, Twinkle Little Bat\n" +
                "How I wonder what you're at!\n" +
                "Up above the world you fly,\n" +
                "Like a tea tray in the sky.\n" +
                "Twinkle, twinkle, little bat!\n" +
                "How I wonder what you're at!"
    )

    println(
        """Twinkle, Twinkle Little Bat
How I wonder what you're at!
Up above the world you fly,
Like a tea tray in the sky.
Twinkle, twinkle, little bat!
How I wonder what you're at!""".trimIndent()
    )
}

fun archenemy(heroName: String) = when (heroName) {
    "Batman" -> "Joker"
    "Superman" -> "Lex Luthor"
    "Spider-Man" -> "Green Goblin"
    else -> "Sorry, no idea"
}