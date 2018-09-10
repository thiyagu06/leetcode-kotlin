package leetcode.easy._400_nth_digit

import extensions.chars.numericValue
import kotlin.math.pow

/**
 * 400 - https://leetcode.com/problems/nth-digit/description/
 */
class Solution {
    /**
     * TODO
     * Time: O(?)
     * Space: O(?)
     */
    fun findNthDigit(n: Int): Int {
        var digitsCounted = 1
        var digitsInRange = 1

        while (digitsCounted < n) {
            if (digitsCounted - sizeOfRange(digitsInRange) > 0) {
                digitsCounted += sizeOfRange(digitsInRange)
            } else {
                rangeForDigitSize(digitsInRange).forEach { num ->
                    (0 until digitsInRange).forEach { digitIndex ->
                        if (digitsCounted++ == n)
                            return num.digitAt(digitIndex)
                    }
                }
            }
            digitsInRange++
        }

        return 1
    }

    private fun Int.digitAt(index: Int): Int = toString()[index].numericValue()

    private fun rangeForDigitSize(size: Int): IntRange = (10.0.pow(size - 1).toInt()..(10.0.pow(size) - 1).toInt())

    private fun sizeOfRange(digitsInRange: Int): Int = (9 * 10.0.pow(digitsInRange)).toInt()
}


