package algorithms.easy._461_hamming_distance

import extensions.math.INT_BITS
import extensions.math.hasKthBitSet
import extensions.math.valueOfKthBit

/**
 * 461 - https://leetcode.com/problems/hamming-distance/description/
 */
class Solution {
    /**
     * Time: O(1). O(n bits) => O(1) since x and y known to be <= 32. O(32) = O(1)
     * Space: O(1)
     */
    fun hammingDistance(x: Int, y: Int): Int =
        (0 until INT_BITS).fold(0) { acc, k ->
            if (differAtKthBit(x, y, k)) acc + 1
            else acc
        }

    // Uses Int.xor() - Int.valueOfKthBit returns an Int.
    private fun differAtKthBit(x: Int, y: Int, k: Int): Boolean =
        (x.valueOfKthBit(k) xor y.valueOfKthBit(k)) == 1
}

class SolutionTwo {
    /**
     * Time: O(1). O(max(x, y)) = O(1) since x and y should be <= 32 (http://tinyurl.com/y9g4lr4q)
     * Space: O(1)
     */
    fun hammingDistance(x: Int, y: Int): Int =
        (0 until INT_BITS).fold(0) { acc, k ->
            if (differAtKthBit(x, y, k)) acc + 1
            else acc
        }

    // Uses Boolean.xor() - Int.hasKthBitSet returns a boolean.
    private fun differAtKthBit(x: Int, y: Int, k: Int): Boolean = x.hasKthBitSet(k) xor y.hasKthBitSet(k)
}