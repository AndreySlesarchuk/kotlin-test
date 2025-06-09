package by.atmm.kotlin.topics.notes

import topics.Person

/**
 *  @author Andrey Slesarchuk
 *  @date 2025-06-06
 */

fun main() {
    val testName = "Andrei"
    val testAge = 52
    val testDayNum = 2
    val testString: String? = null

    println(square(2)) // 1
    greet(testName) // 2
    greet(name = testName, greeting = "Hi") // 3
    println("My name is: $testName and I am $testAge years old") // 4
    val dayName: Any = when (testDayNum) { // 5
        1 -> "Monday"
        2 -> "Tuesday"
        else -> "Unknown"
    }
    println(dayName)
    if (dayName is String) println(dayName.length) // 6
    println(testString?.length ?: "testString is null") // 7.1, 7.2
    val person = Person().apply { // 8
        firstName = testName
        age = testAge
    }
    println("Person is: $person")
    testString?.let { println(it.uppercase()) } // 9
    val data: String by lazy { dayName as String } // 10
    println(data.uppercase())
    val user = User(name = testName, age = testAge) // 11
    println("User is: $user")
    Database.query("SELECT * FROM user;") // 12
    println(testName.makeUpperCase()) // 13
    val totalMoney = Money(13.37) + Money(10.13) // 14
    println("totalMoney is: ${totalMoney.amount}")
    println("calculate 14 and 22 is: ${calculate(14, 22, { x, y -> x + y })}") // 15
    Utils.printMessage() // 16
    val point2dim = Pair(10, 20)
    val point3dim = Triple(10, 20, 30)
    println("point2dim is: $point2dim and point3dim third is: ${point3dim.third}") // 18
    val (x, y, z) = point3dim // 19
    println("x is: $x, y is: $y, z is $z")
    val numbers = listOf(1, 2, 3, 4, 5) // 20
    val evens = numbers.filter { it % 2 == 0 }
    println("evens are: $evens")

    var messageType: MessageType = msgFailure as MessageType // 17
    println(getMessage(messageType))
    messageType = msgSuccess as MessageType
    println(getMessage(messageType))
}

// 1. If a function has only one line, you can skip {} and return.
// 2. You can assign default values to function parameters to avoid overloading methods.
// 3. Named arguments make it clear which parameter is which.
// 4. $variable inside a string automatically replaces with its value.
// 5. "When" is cleaner and more readable than multiple if-else with count > 2.
// 6. If Kotlin knows obj is a String, it automatically lets you use .length.
// 7.1 ?. → Safe call (calls .length only if name is not null
// 7.2 ?: → Elvis operator (provides a default value if name is null)
// 8. Apply lets you set properties inside a block instead of writing multiple lines.
// 9. Let executes code only if the value is not null.
// 10. Lazy Initialization: by lazy means the variable is only initialized when first accessed.
// 11. DData class automatically provides toString(), equals(), and copy() functions
// 12. Object creates a single instance of a class (Singleton).
// 13. Adds functions to existing classes (even built-in ones).
// 14. You can override operators like +, -, *, etc.
// 15. You can pass functions as parameters.
// 16. Companion object lets you call methods like static functions in Java.
// 17. Sealed classes restrict inheritance to only within the same file.
// 18. Pair and Triple help you group values without a class.
// 19. Destructuring Declarations: val (x, y) = Pair(10, 20) automatically extracts values.
// 20. Filtering collections: filter selects only matching elements.

fun square(n: Int) = n * n // 1

fun greet(name: String, greeting: String = "Hello") = println("$greeting, $name!") // 2

data class User(val name: String, val age: Int) // 11

object Database { // 12
    fun query(sql: String) { println("Executing SQL: $sql") }
}

fun String.makeUpperCase() = this.uppercase() // 13

class Money(val amount: Double) { // 14
    operator fun plus(other: Money) = Money(this.amount + other.amount)
}

fun calculate(a: Int, b: Int, op: (Int, Int) -> Int): Int { //15
    return op(a, b)
}

class Utils { // 16
    companion object {
        fun printMessage() = println("Utils printMessage()")
    }
}

sealed class MessageType { //17
    class Success(var msg: String) : MessageType()
    class Failure(var msg: String, var e: Exception) : MessageType()
}
fun getMessage(messageType: MessageType): String {
    val msg = when(messageType) {
        is MessageType.Success -> messageType.msg
        is MessageType.Failure -> messageType.msg + " " + messageType.e.message
    }
    return msg
}

val msgSuccess = MessageType.Success("Success!") // 17
val msgFailure = MessageType.Failure("Failure!", Exception("Something went wrong!"))
