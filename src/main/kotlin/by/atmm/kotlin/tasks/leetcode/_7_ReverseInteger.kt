package by.atmm.kotlin.tasks.leetcode


fun main() {
    val sol = SolutionA()
    println(sol.reverse(123));
    println(sol.reverse(-123));
    println(sol.reverse(120));
    println(sol.reverse(0));
}

class SolutionA {
    fun reverse(x: Int): Int {
        var num = x
        var result = 0L

        while (num != 0) {
            result = result * 10 + num % 10
            num /= 10
        }

        return when {
            result > Int.MAX_VALUE || result < Int.MIN_VALUE -> 0
            else -> result.toInt()
        }
    }
}

