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
    data class User(val name: String, val age: Int) // 11
    val user = User(name = testName, age = testAge)
    println("User is: $user")


}

// 1. If a function has only one line, you can skip {} and return.
fun square(n: Int) = n * n
// 2. You can assign default values to function parameters to avoid overloading methods.
fun greet(name: String, greeting: String = "Hello") = println("$greeting, $name!")
// 3. Named arguments make it clear which parameter is which.
// 4. $variable inside a string automatically replaces with its value.
// 5. "when" is cleaner and more readable than multiple if-else with count > 2.
// 6. If Kotlin knows obj is a String, it automatically lets you use .length.
// 7.1 ?. → Safe call (calls .length only if name is not null
// 7.2 ?: → Elvis operator (provides a default value if name is null)
// 8. apply lets you set properties inside a block instead of writing multiple lines.
// 9. let executes code only if the value is not null.
// 10. Lazy Initialization: by lazy means the variable is only initialized when first accessed.
// 11. data class automatically provides toString(), equals(), and copy() functions