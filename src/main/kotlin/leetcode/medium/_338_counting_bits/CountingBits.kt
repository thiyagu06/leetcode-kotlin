package leetcode.medium._338_counting_bits

import extensions.binary.numberOfOneBits
import extensions.binary.toBinaryString

/**
 * 338 - https://leetcode.com/problems/counting-bits/
 */
class Solution {
    /**
     * Count 1 bits directly using `&` bitwise operator & mask
     * Time: O(?)
     * Space: O(?)
     */
    fun countBits(num: Int): IntArray {
        val result = IntArray(num + 1)
        (0..num).forEach { i ->
            result[i] = i.numberOfOneBits()
        }
        return result
    }
}

class SolutionTwo {
    /**
     * Convert to Binary String representation, then count 1s
     * Time: O(?)
     * Space: O(?)
     */
    fun countBits(num: Int): IntArray {
        val result = IntArray(num + 1)
        (0..num).forEach { i ->
            result[i] = i.toBinaryString().count { it == '1' }
        }
        return result
    }
}

class SolutionThree {
    /**
     * Convert to Binary String representation, then count 1s
     * Time: O(?)
     * Space: O(?)
     */
    fun countBits(num: Int): IntArray {
        val result = IntArray(num + 1)
        (0..num).forEach { i ->
            val binaryRepresentation = Integer.toBinaryString(i)
            result[i] = binaryRepresentation.count { it == '1' }
        }
        return result
    }
}


class FollowUpSolution {
    /**
     * It is very easy to come up with a solution with run time O(n*sizeof(integer)).
     * But can you do it in linear time O(n) /possibly in a single pass?
     * Space complexity should be O(n).
     * Can you do it like a boss? Do it without using any builtin function
     *
     * Time: O(?)
     * Space: O(?)
     */
    fun countBits(num: Int): IntArray {
        TODO()
    }
}