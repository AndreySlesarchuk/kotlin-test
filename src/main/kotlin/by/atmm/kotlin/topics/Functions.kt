package topics

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-05-03
 */

fun main() {
    // From Kotlin Koans
    // https://play.kotlinlang.org/koans/Introduction/Named%20arguments/Task.ktghj

    println(testSimple(1, 2))
    println(testString(10))
    println(testNamedArguments(y = 10, z = 1, x = 5))

    testDefaultArguments()
    testDefaultArguments(5)
    testDefaultArguments(y = 6)
    testDefaultArguments(33, 44)

    printEven(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    // printEven(*intArrayOf(9, 8, 7, 6, 5), 6, 7, 8, 9, 10)

    println("Max: ${max(11, 22)}")
    println("Crop: ${crop("JavaKotlin")}")
    println("Crop: ${crop("Java")}")
    println("Sum: ${sum(1, 2, 3, 4, 5, 6, 7)}")

    val numbers = mutableListOf<Int>(5, 8, 12, -3, 7, 6)  // arrayOf(5, 8, 12, -3, 7, 6)
    var result = sort(numbers)
    for (i in result) print(" $i")
    result = sort(5, 8, 12, -3, 7, 6)
    for (i in result) print(" $i")
    val numbersA = arrayOf(5, 8, 12, -3, 7, 6)
    result = sort(numbersA)
    for (i in result) print(" $i")
    println()

    printInfo("Slesarchuk", "Mike", "Andreevich")
    printInfo(firstName = "Andrey", patronymic = "Vasilyevich")
    printInfo(firstName = "Dennis", patronymic = null)

    show(square(8))
    show(square(maxV(8, square(3))))

    val listOfNumbers = mutableListOf<Int>()
    for (i in 0..99) listOfNumbers.add(i)
    val listOfEvenNumbers = listOfNumbers.filter { it % 2 == 0 }
    showList(listOfEvenNumbers)

    val names = listOf("Vasiliy", "Andrey", "Mike", "Anna")
    showList(names.filter { it.startsWith("A") })

    val numbers2 = (0..100).toList()
    //val doubleNumbers = numbers2.map {n -> n * 2 }
    val doubleNumbers = numbers2.map { it * 2 }
    showList(doubleNumbers)
    val employees = numbers2.map { "Employee №$it" }
    showList(employees)
    val array = arrayOf(8, 13, -7, 49, 19)
    showList(array.sorted())
    showList(array.sortedDescending())

    val initArray = mutableListOf<Int>()
    for (i in 0 until 100) initArray.add((Math.random() * 1000).toInt())
    val result1 = initArray
        .filter { it % 5 == 0 || it % 3 == 0 }.map { it * it }
        .sortedDescending().map { "$it" }
    showList(result1)

    var first30employee = employees.take(30)
    showList(first30employee)
    var last30employee = employees.takeLast(30)
    showList(last30employee)
    first30employee = employees.drop(30)
    showList(first30employee)
    last30employee = employees.dropLast(970)
    showList(last30employee)

    val array3 = generateSequence(0) { it + 2 }
    showList(array3.take(10).toList())

}


val square: (Int) -> Int = { it * it }
val maxV: (Int, Int) -> Int = { a, b -> if (a > b) a else b }
val show: (Any) -> Unit = {
    println(it)
}
val showList: (List<*>) -> Unit = {
    for (i in it) print("$i ")
    println()
}


fun printInfo(lastName: String = "", firstName: String = "", patronymic: String? = "") {
    if (lastName.isNotEmpty()) {
        print("Last name: $lastName ")
    }
    if (firstName.isNotEmpty()) {
        print("First name: $firstName ")
    }
    if (patronymic?.isNotEmpty() == true) {
        print("Patronymic: $patronymic")
    }
    print("\n")
}

fun sort(numbers: MutableList<Int>): List<Int> {
    for (i in 1 until numbers.size) {
        for (j in numbers.size - 1 downTo i) {
            if (numbers[j] < numbers[j - 1]) {
                val temp = numbers[j]
                numbers[j] = numbers[j - 1]
                numbers[j - 1] = temp
            }
        }
    }
    return numbers
}

fun sort(numbers: Array<Int>) = sort(numbers.toMutableList())
fun sort(vararg numbers: Int) = sort(numbers.toMutableList())

//fun testSimple(x:Int, y:Int): Int {
//    return x + y
//}
fun testSimple(x: Int, y: Int): Int = x + y

fun max(x: Int, y: Int) = if (x > y) x else y

fun crop(str: String) = str.substring(0, Math.min(5, str.length))

fun sum(vararg numbers: Int): Int {
    var result = 0
    for (num in numbers) {
        result += num
    }
    return result
}

//fun testString(x: Int): String {
//    return "String is $x"
//}
fun testString(x: Int): String = "String is $x"

fun testNamedArguments(x: Int, y: Int, z: Int): List<Int> {
    return listOf(x, y, z)
}

// void
fun testDefaultArguments(x: Int = 11, y: Int = 22) {
    println(x + y)
}

// vararg
fun printEven(vararg numbers: Int) {
    numbers.forEach { e -> if (e % 2 == 0) println(e) }
}