package by.atmm.kotlin.topics.classes.student

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-09-01
 *
 * Student(name=Mike, lastName=Andreev, id=20081110)
 * Student(name=Mike, lastName=Andreev, id=20081110)
 * -540150880
 * -540150880
 * true  == compare by object
 * false === compare by link
 *
 */

fun main() {
    val student1 = Student("Mike", "Andreev", "20081110")
    val student2 = Student("Mike", "Andreev", "20081110")
    println(student1)
    println(student2)
    println(student1.hashCode())
    println(student2.hashCode())
    println(student1 == student2)
    println(student1 === student2)

    val (nameD, lastNameD, idD) = student1
    println("Destructor1 for student1 -> $nameD $lastNameD $idD")
    val (name, _, id) = student1
    println("Destructor2 for student1 -> $name $id")

}