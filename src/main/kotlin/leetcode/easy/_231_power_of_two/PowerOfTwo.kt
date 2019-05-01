package leetcode.easy._231_power_of_two

import extensions.binary.INT_BITS

/**
 * 231 - https://leetcode.com/problems/power-of-two/
 */
class Solution {
    /**
     * Time: O(1)
     * Space: O(1)
     */
    fun isPowerOfTwo(n: Int): Boolean =
        n > 0 && (0 until INT_BITS).any { k ->
            (1 shl k) and n == n
        }
}

class SolutionTwo {
    /**
     * Time: O(1)
     * Space: O(1)
     */
    fun isPowerOfTwo(n: Int): Boolean = (n != 0) && (n and (n - 1) == 0)
}
