package topics

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-05-03
 */

fun main() {
    testWhen(1)
    testWhen("Hello")
    testWhen(15)
    testWhen(-1)
//    One
//    A string was entered, its length is: 5
//    From 10 to 20
//    Something else

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