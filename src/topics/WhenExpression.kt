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
}

//testWhen(Odject object)
fun testWhen(input: Any) {
    when (input) {
        1 -> println("One")
        2 -> println("Two")
        in 10..20 -> println("From 10 to 20")
        is String -> println("A string was entered, its length is: ${input.length} ")
        else -> println("Something else")
    }

}
