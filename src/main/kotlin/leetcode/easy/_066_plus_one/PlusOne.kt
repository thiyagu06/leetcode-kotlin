package leetcode.easy._066_plus_one

/**
 * 66 - https://leetcode.com/problems/plus-one/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n) - worst case all digits are 9's.
     */
    fun plusOne(digits: IntArray): IntArray {
        for (i in (digits.lastIndex downTo 0)) {
            when (digits[i]) {
                in 0..8 -> {
                    digits[i]++
                    return digits
                }
                else -> digits[i] = 0
            }
        }
        return intArrayOf(1) + digits
    }
}

class SolutionTwo {
    /**
     * Recursive solution - simpler and more elegant, but uses more space.
     * Time: O(n)
     * Space: O(n) - recursive stack space
     */
    fun plusOne(digits: IntArray): IntArray = when {
        digits.size == 1 && digits[0] == 9 -> intArrayOf(1, 0)

        digits.last() in 0..8 ->
            digits.dropLast(1).toIntArray() + (digits.last() + 1)

        else -> plusOne(digits.dropLast(1).toIntArray()) + intArrayOf(0)
    }
}

class SolutionThree {
    /**
     * Recursive solution - with reduced space
     * Time: O(n)
     * Space: O(n)
     */
    fun plusOne(digits: IntArray, index: Int = digits.lastIndex): IntArray = when {
        digits[index] in 0..8 -> {
            digits[index]++
            digits
        }
        else -> {
            digits[index] = 0
            if (index != 0) {
                plusOne(digits, index - 1)
            } else {
                intArrayOf(1) + digits
            }
        }
    }
}