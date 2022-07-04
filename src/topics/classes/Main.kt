package topics.classes

import topics.Person
import topics.Rectangle

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-07-03
 */

fun main() {

    val p2 = Person("Mike", "Andreev", 13)
    val p1 = Person("Andrey", "Vasilev", 49, p2);
    p1.children.add(p2)
    println(p1.children.get(0).equals(p1.children.get(1))) // true
    println(p1.children[0] == p1.children[1]) // true
    val p3 = Person() // Person is created
    println(p3.age) // 0

    val rectangle1 = Rectangle(5.0, 2.0)
    println("The perimeter is ${rectangle1.perimeter}") // The perimeter is 14.0

    val rectangle2 = Rectangle(5.0, 2.0)
    println(rectangle1 == rectangle2) // true
    println(rectangle2.test.toString()) // 2
    rectangle2.test = 4
    println(rectangle2.test.toString()) // 5

    val user = User()
    user.name = "Mike"
    user.age = 13
    println("User Name: ${user.name} Age: ${user.age}") // User Name: Mike Age: 13
    user.name = null
    user.age = -15
    println("User Name: ${user.name} Age: ${user.age}") // User Name: Mike Age: 13

    val dog = Dog()
    dog.name = "spevak"
    dog.age = 7
    dog.weight = 5.5F
    println("Dog Name: ${dog.name} Age: ${dog.age} Weight: ${dog.weight} ") // Dog Name: Spevak Age: 7 Weight: 5.5
    dog.name = "ace"
    dog.age = -7
    dog.weight = -5.5F
    println("Dog Name: ${dog.name} Age: ${dog.age} Weight: ${dog.weight} ") // Dog Name: Ace Age: 7 Weight: 5.5

    // Country
    val country = Country("Belarus", 9255524)
    println("Country Name: ${country.name}") // Country name
    println("Country Population: ${country.population}") // Country population

    // Book
    val book = Book("One Hundred Years of Solitude")
    println("Book Name: ${book.name}") // Country name
    println("Book Name: ${book.name}  Year: ${book.year}  Price: ${book.price} ")
    book.year = 1967
    book.price = 25
    println("Book Name: ${book.name}  Year: ${book.year}  Price: ${book.price} ")

}