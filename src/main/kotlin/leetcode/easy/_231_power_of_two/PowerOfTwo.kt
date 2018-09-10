package leetcode.easy._231_power_of_two

import extensions.math.INT_BITS

class Solution {
    /**
     * Time: O(1)
     * Space: O(1)
     */
    fun isPowerOfTwo(n: Int): Boolean {
        if (n <= 0)         // 0 is false positive
            return false

        (0 until INT_BITS).forEach { k ->
            if (((1 shl k) and n) == n) {
                return true
            }
        }
        return false
    }
}