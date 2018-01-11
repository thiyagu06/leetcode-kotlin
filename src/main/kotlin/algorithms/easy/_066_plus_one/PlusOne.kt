package algorithms.easy._066_plus_one

/**
 * 66 - https://leetcode.com/problems/plus-one/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun plusOne(digits: IntArray): IntArray {
        for (i in (digits.lastIndex downTo 0)) {
            when (digits[i]) {
                in 0..8 -> {
                    digits[i]++
                    return digits
                }
                else -> {
                    if (i != 0) digits[i] = 0
                    else return intArrayOf(1, 0) + digits.drop(1).toIntArray()
                }
            }
        }

        return digits
    }
}

class RecursiveSolution {

    /**
     * Simpler and more elegant, but uses more space.
     * Time: O(n)
     * Space: O(n) - recursive stack space
     */
    fun plusOne(digits: IntArray): IntArray = when {
        digits.size == 1 && digits[0] == 9 -> intArrayOf(1, 0)  // add next most-significant digit

        digits.last() in 0..8 -> {
            digits[digits.lastIndex]++
            digits
        }

        else -> plusOne(digits.dropLast(1).toIntArray()) + intArrayOf(0)
    }
}
