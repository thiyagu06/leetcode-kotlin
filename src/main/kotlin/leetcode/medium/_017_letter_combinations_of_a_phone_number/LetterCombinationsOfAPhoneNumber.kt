package leetcode.medium._017_letter_combinations_of_a_phone_number

import extensions.chars.numericValue

/**
 * 17 - https://leetcode.com/problems/letter-combinations-of-a-phone-number
 */
class Solution {
    /**
     * Backtracking
     *
     * Time: O(?)
     * Space: O(?)
     */
    fun letterCombinations(digits: String): List<String> {
        val combinations = ArrayList<String>()
        combine(digits, "", combinations)
        return combinations
    }

    private fun combine(digits: String, current: String, combinations: MutableList<String>) {
        if (digits.isEmpty()) {
            if (current.isNotEmpty()) {
                combinations += current
            }
            return
        }

        val firstDigit = digits[0]
        for (letter in letters[firstDigit.numericValue]) {
            combine(digits.drop(1), current + letter, combinations)
        }
    }

    private val letters = Array(10) { i ->
        when (i) {
            2 -> "abc"
            3 -> "def"
            4 -> "ghi"
            5 -> "jkl"
            6 -> "mno"
            7 -> "pqrs"
            8 -> "tuv"
            9 -> "wxyz"
            else -> ""
        }
    }
}

class SolutionTwo {
    /**
     * Same as [Solution], but reduced space usage by using "digits" with an index.
     *
     * Time: O(?)
     * Space: O(?)
     */
    fun letterCombinations(digits: String): List<String> {
        val combinations = ArrayList<String>()
        combine(digits, 0, "", combinations)
        return combinations
    }

    private fun combine(digits: String, startIndex: Int, current: String, combinations: MutableList<String>) {
        if (digits.isEmpty() || startIndex > digits.lastIndex) {
            if (current.isNotEmpty()) combinations += current
            return
        }

        val ithDigitLetters = letters[digits[startIndex].numericValue]
        for (letter in ithDigitLetters) {
            combine(digits, startIndex + 1, current + letter, combinations)
        }
    }

    private val letters = Array(10) { i ->
        when (i) {
            2 -> "abc"
            3 -> "def"
            4 -> "ghi"
            5 -> "jkl"
            6 -> "mno"
            7 -> "pqrs"
            8 -> "tuv"
            9 -> "wxyz"
            else -> ""
        }
    }
}
