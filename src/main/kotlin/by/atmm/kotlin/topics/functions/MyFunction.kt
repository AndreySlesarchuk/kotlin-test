/**
 *  @author Andrey Slesarchuk
 *  @date 2022-08-31
 */

fun main() {
    // Function extensions
    val age = 21
    if (age.isAgeValid()) {
        println("Valid")
    } else {
        println("Invalid")
    }

    val name = "Andrey"
    if (name.isNotEmpty()) {
        println(name)
    }

    println((-13).isPositive())
    println(13.isPrime())

    // Self-made high order functions
    val result = modifyString("Hello world!") { it.uppercase() }
    println(result)

    val list = (0..100).toList()
    modifyList(list) { println(it.sum()) }
}

fun Int.isAgeValid() = this in 6..100
fun Int.isPositive() = this >=0
fun Int.isPrime(): Boolean {
    if (this <=3 ) return true
    for (i in 2 until this) {
        if (this % i == 0) return false
    }
    return true
}

inline fun modifyString(input: String, modify: (String) -> String): String {
    return modify(input)
}

inline fun modifyList(list: List<Int>, operator: (List<Int>) -> Unit) {
    operator(list)
}