@file:JvmName("_7_ReverseIntegerKt")

package by.atmm.kotlin.tasks.leetcode

import kotlin.math.abs

/*
Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 */

fun main(args: Array<String>) {
    val sol = Solution()
    println(sol.reverse(123));
    println(sol.reverse(-123));
    println(sol.reverse(120));
    println(sol.reverse(0));
}

class Solution {
    fun reverse(x: Int): Int {
        val isNegative = x < 0
        val reverse = abs(x).toString(10).reversed().toInt()

        return if (isNegative) -reverse else reverse
    }
}

