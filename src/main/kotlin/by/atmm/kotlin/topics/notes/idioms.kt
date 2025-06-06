package by.atmm.kotlin.topics.notes

/**
 *  @author Andrey Slesarchuk
 *  @date 2025-06-06
 */


fun main() {
    val testName = "Andrei"
    val testAge = 52
    val testDayNum = 2

    println(square(2)) // 1
    greet(testName) // 2
    greet(name = testName, greeting = "Hi") // 3
    println("My name is: $testName and I am $testAge years old") // 4
    val dayName = when (testDayNum) { // 5
        1 -> "Monday"
        2 -> "Tuesday"
        else -> "Unknown"
    }
    println(dayName)

}

// 1. If a function has only one line, you can skip {} and return.
fun square(n: Int) = n * n

// 2. You can assign default values to function parameters to avoid overloading methods.
fun greet(name: String, greeting: String = "Hello") = println("$greeting, $name!")

// 3. Named arguments make it clear which parameter is which.
// 4. $variable inside a string automatically replaces with its value.
// 5. "when" is cleaner and more readable than multiple if-else with count > 2.