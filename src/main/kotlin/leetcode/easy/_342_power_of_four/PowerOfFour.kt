package leetcode.easy._342_power_of_four

import extensions.binary.INT_BITS

/**
 * 342 - https://leetcode.com/problems/power-of-four/description/
 */
class Solution {
    fun isPowerOfFour(num: Int): Boolean =
        num > 0 && (0 until INT_BITS step 2).any { k ->
            (1 shl k) and num == num
        }
}

class SolutionTwo {
    /**
     * Use (x & (x - 1) == 0) trick (used for Power of Two),
     * but add condition that (x & 0x55555555 !== 0) to
     * remove powers of 2 that aren't powers of 4.
     *
     * 0x55555555 =
     * 01010101010101010101010101010101 binary
     *
     * Time: O(1)
     * Space: O(1)
     */
    fun isPowerOfFour(num: Int): Boolean = (num > 0)
            && (num and (num - 1) == 0)
            && (num and 0x55555555 != 0)
}
