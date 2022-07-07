package topics

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-05-03
 */

fun main() {
    testWhen(1)
    testWhen("Hello")
    testWhen(10)
    testWhen(-1)
//    One
//    Season: Winter
//    A string was entered, its length is: 5
//    Season: Not found
//    From 10 to 20
//    Season: Autumn
//    Something else
//    Season: Not found

    testIf(50)
//    Do something
//    You might to buy the following product: Pizza, you still have: 20 dollars
//    You might to buy the following product: null, you still have: 15 dollars
}

// testWhen(Odject object)
fun testWhen(input: Any) {
    when (input) {
        1 -> println("One")
        2 -> println("Two")
        in 10..20 -> println("From 10 to 20")
        is String -> println("A string was entered, its length is: ${input.length} ")
        else -> println("Something else")
    }

    val season = when (input) {
        1, 2, 3 -> {
            "Winter"
        }
        in 3..5 -> "Spring"
        in 6..8 -> "Summer"
        in 9..11 -> "Autumn"
        else -> {
            "Not found"
        }
    }
    println("Season: $season")
}


// testIF
fun testIf(incomeCount: Any) {
    var count: Int = incomeCount as Int
    // food1 - variable type - String
    val food1 = if (count > 30) {
        count -= 30
        println("Do something")
        "Pizza"
    } else if (count > 20) {
        count -= 20
        "Hamburger"
    } else {
        count -= 3
        "Hot dog"
    }
    println("You might to buy the following product: $food1, you still have: $count dollars  ")

    // food2 - variable type - Any
    val food2 = if (count > 30) {
        count -= 30
        println("Do something")
        "Pizza"
    } else if (count > 20) {
        count -= 20
        300
    } else {
        count -= 5
        null
    }
    // println(food2::class.java.typeName)
    println("You might to buy the following product: $food2, you still have: $count dollars  ")

}