package algorithms.easy._202_happy_number

import extensions.digits

/**
 * 202 - https://leetcode.com/problems/happy-number/description/
 */
class Solution {
    /**
     * Time: O(?)
     * Space: O(?)
     */
    fun isHappy(n: Int): Boolean {
        var number = n
        val prevDigits = hashSetOf<Int>()

        while (number != 1) {
            if (prevDigits.contains(number)) {
                return false
            }
            prevDigits.add(number)

            number = number.sumOfSquaresOfDigits()
        }

        return true
    }

    private fun Int.sumOfSquaresOfDigits(): Int = this.digits().sumBy { it * it }
}


