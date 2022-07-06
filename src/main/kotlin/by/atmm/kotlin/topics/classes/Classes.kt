package topics

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-05-03
 */

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