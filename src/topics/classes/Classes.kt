package topics

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-05-03
 */

fun main() {
    val p2 = Person("Mike", "Slesarchuk", 13)
    val p1 = Person("Andrey", "Slesarchuk", 49, p2);
    p1.children.add(p2)
    println(p1.children.get(0).equals(p1.children.get(1)))
    println(p1.children[0] == p1.children[1])
    val p3 = Person()
    println(p3.age) // 0

    val rectangle1 = Rectangle(5.0, 2.0)
    println("The perimeter is ${rectangle1.perimeter}")

    val rectangle2 = Rectangle(5.0, 2.0)
    println(rectangle1 == rectangle2) // true
    println(rectangle2.test.toString()) // 2
    rectangle2.test = 4
    println(rectangle2.test.toString()) // 5

}

// Primary Constructor
class Person(val firstName: String, val lastName: String, var age: Int) {
    var children: MutableList<Person> = mutableListOf() // ArrayList

    init {
        println("Person is created $firstName")
    }

    // Secondary constructor
    constructor(firstName: String, lastName: String, age: Int, child: Person) :
            this(firstName, lastName, age) {
        children.add(child)
    }

    // Constructor without arguments
    constructor() :
            this("", "", 0)
}

// data - automatic equals, hashcode...
data class Rectangle(var height: Double, var length: Double) {
    var perimeter = (height + length) * 2

    var test = 1
        get() = field + 1 // this.none
        set(value) {
            if (value < 0) println("Negative value")
            field = value
        }

    fun area() = height * length

}