package leetcode.easy._258_add_digits

import extensions.math.digits

/**
 * 258 - https://leetcode.com/problems/add-digits/
 *
 */
class Solution {
    fun addDigits(num: Int): Int {
        if (num < 0)
            return 0

        var currentNumber = num
        var digits: List<Int>
        var sum: Int
        do {
            digits = currentNumber.digits()
            sum = digits.sum()
            currentNumber = sum
        } while (digits.size > 1)

        return currentNumber
    }
}