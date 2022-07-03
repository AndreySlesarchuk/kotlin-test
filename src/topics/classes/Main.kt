package topics.classes

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-05-03
 */

fun main() {
    val user = User()
    user.name = "Mike"
    user.age = 13
    println("Name: ${user.name} Age: ${user.age}")

    user.name = null
    user.age = -15
    println("Name: ${user.name} Age: ${user.age}")

}