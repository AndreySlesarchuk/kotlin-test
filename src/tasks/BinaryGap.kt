package tasks

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-05-08
 */

fun main() {
    // A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones
    // at both ends in the binary representation of N.
    // input: 529 -> 1000010001 -> result: 4
    // input: 20 -> 10100 -> result: 1
    // input: 15 -> 1111 -> result: 0

    println(Solution(529))
}

fun Solution(n: Int): Int {
    if (n == 0) return 0
    val binaryString = Integer.toBinaryString(n)
    var zeroSequences: List<String> = binaryString.split("1")
    if (binaryString.get(binaryString.length - 1) == '0')
        zeroSequences = zeroSequences.dropLast(1)
    val result: Int = zeroSequences.groupBy { it.length }.maxOf { it.key }
    return result
}