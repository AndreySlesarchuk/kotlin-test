package topics

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-05-03
 */

fun main() {

    val e: String? = "Andrey"
    val f: String? = "Mike"
    val g: String? = ""

    val r = (e?.length ?: 0) + (f?.length ?: 0) + (g?.length ?: 0)
    println(r)

    val a: String = "Hello"
    //a = null // NPE excluded
    println(a)

    var b: String? = "Test"
    b = null

    // safe call
    //  Elvis
    val l = b?.length ?: 111 // value we want
    println("l is $l")

    b = if ((0..10).random() > 5) "asdf" else null
    // !! - throws out NPE if the variable is null
    val t = b!!.length
    println("t is $t")

}