package leetcode.easy._415_add_strings

import extensions.chars.numericValue
import extensions.tuples.shorterAndLonger

/**
 * 415 - https://leetcode.com/problems/add-strings/description/
 */
class Solution {
    fun addStrings(num1: String, num2: String): String {
        var result = ""
        val rNum1 = num1.reversed()
        val rNum2 = num2.reversed()

        var prevCarry = 0

        // Iterate through length of shorter
        rNum1.zip(rNum2).forEach { (a, b) ->
            val (nextCarry, currentDigit) = sumDigitsWithCarry(a.numericValue(), b.numericValue(), prevCarry)
            result += currentDigit
            prevCarry = nextCarry
        }

        val (shorter, longer) = (rNum1 to rNum2).shorterAndLonger()

        // Iterate remaining chars in longer string
        (shorter.length..longer.lastIndex).forEach { index ->
            val (nextCarry, currentDigit) = sumDigitsWithCarry(a = longer[index].numericValue(), b = 0, carriedValue = prevCarry)
            result += currentDigit
            prevCarry = nextCarry
         }

        if (prevCarry > 0) {
            result += prevCarry
        }

        return result.reversed()
    }

    /**
     * 9 + 4 = (1, 3)
     * 5 + 2 = (0, 7)
     * @return Pair containing the carry value and the value for the preceding digit
     */
    private fun sumDigitsWithCarry(a: Int, b: Int, carriedValue: Int): Pair<Int, Int> {
        val rawSum = a + b + carriedValue
        val carry = if (rawSum >= 10) 1 else 0
        return Pair(carry, rawSum % 10)
    }
}

