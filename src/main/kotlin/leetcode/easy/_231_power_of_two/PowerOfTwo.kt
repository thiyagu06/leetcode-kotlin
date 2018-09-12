package leetcode.easy._231_power_of_two

import extensions.math.INT_BITS
import extensions.math.`&`

class Solution {
    /**
     * Time: O(1)
     * Space: O(1)
     */
    fun isPowerOfTwo(n: Int): Boolean =
        n > 0 && (0 until INT_BITS).any { k ->
            (1 shl k) `&` n == n
        }
}


class SolutionTwo {
    /**
     * Time: O(1)
     * Space: O(1)
     */
    fun isPowerOfTwo(n: Int): Boolean = (n != 0) && (n `&` (n - 1) == 0)
}
