package leetcode.easy._007_reverse_integer

import extensions.math.withDigitsReversed
import kotlin.math.abs

/**
 * 7 - https://leetcode.com/problems/reverse-integer/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun reverse(x: Int): Int = if (x < 0) {
        reverseNonNegative(abs(x)) * -1
    } else {
        reverseNonNegative(abs(x))
    }

    private fun reverseNonNegative(x: Int): Int = x.toString().reversed().toIntOrNull() ?: 0
}

class SolutionTwo {
    /**
     * Time: O(log_10(x)) - there are approx. log_10(x) digits in x
     * Space: O(1)
     */
    fun reverse(x: Int): Int = x.withDigitsReversed() ?: 0
}
