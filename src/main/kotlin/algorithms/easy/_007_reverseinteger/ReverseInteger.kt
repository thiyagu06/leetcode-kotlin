package algorithms.easy._007_reverseinteger

import extensions.numericValue

/**
 * 7 - https://leetcode.com/problems/reverse-integer/description/
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 *
 * @author nrojiani
 * @date 11/7/17
 */
class Solution {
    fun reverse(x: Int): Int {
        val isNegative = x < 0
        val digitsReversed: List<Int> = x.toLong().toString()
                .dropWhile { it == '-' }        // remove -, if present
                .reversed()
                .map { it.numericValue() }
                .dropWhile { it == 0 }          // remove leading zeroes
        val asString = digitsReversed.joinToString("")
        var result = try {
            asString.toInt()
        } catch (e: NumberFormatException) {
            0
        }
        return if (isNegative) (result * -1) else result
    }
}
