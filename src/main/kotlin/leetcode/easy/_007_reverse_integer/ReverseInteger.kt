package leetcode.easy._007_reverse_integer

import extensions.chars.numericValue

/**
 * 7 - https://leetcode.com/problems/reverse-integer/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun reverse(x: Int): Int {
        val isNegative = x < 0
        val digitsReversed: List<Int> = x.toLong().toString()
                .dropWhile { it == '-' }        // remove -, if present
                .reversed()
                .map { it.numericValue() }
                .dropWhile { it == 0 }          // remove leading zeroes
        val asString = digitsReversed.joinToString("")
        val result = try {
            asString.toInt()
        } catch (e: NumberFormatException) {
            0
        }
        return if (isNegative) (result * -1) else result
    }
}
