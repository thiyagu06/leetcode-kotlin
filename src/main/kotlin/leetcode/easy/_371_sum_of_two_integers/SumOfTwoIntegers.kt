package leetcode.easy._371_sum_of_two_integers

import extensions.math.INT_BITS

/**
 * 371 - https://leetcode.com/problems/sum-of-two-integers/description/
 */
class Solution {
    /**
     * Time: O(1)
     * Space: O(1) - at most O(32) stack space
     */
    fun getSum(a: Int, b: Int): Int = when {
        a == 0 -> b
        b == 0 -> a
        else -> {
            var result = 0
            var carry = 0
            (0 until INT_BITS).forEach { k ->
                val sum = sumKthBits(a, b, carry, k)
                val kthBitVal = sum % 2
                carry = if (sum >= 2) 1 else 0

                // Set the bit (if necessary)
                if (kthBitVal == 1) {
                    result = result or (1 shl k)
                }

            }
            result
        }
    }

    private fun sumKthBits(a: Int, b: Int, carry: Int, k: Int): Int =
        a.valueOfKthBit(k) + b.valueOfKthBit(k) + carry

    /**
     * @param k the kth least significant digit, where k = 0 is the least significant bit.
     */
    private fun Int.valueOfKthBit(k: Int): Int = if ((this and (1 shl k)) != 0) 1 else 0
}

class SolutionTwo {
    /**
     * Time: O(1)
     * Space: O(1) - at most O(32) stack space
     */
    fun getSum(a: Int, b: Int): Int = when {
        a == 0 -> b
        b == 0 -> a
        else -> getSum(a xor b, (a and b) shl 1)
    }
}