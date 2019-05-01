package leetcode.medium._012_int_to_roman

import java.lang.IllegalArgumentException

/**
 * 12 - https://leetcode.com/problems/integer-to-roman/
 */
class Solution {

    private val arabicToRoman = mapOf(
        1 to "I",
        4 to "IV",
        5 to "V",
        9 to "IX",
        10 to "X",
        40 to "XL",
        50 to "L",
        90 to "XC",
        100 to "C",
        400 to "CD",
        500 to "D",
        900 to "CM",
        1000 to "M"
    )

    /**
     * This version is simpler, but less efficient since filtering the keys is O(n)
     * Time: O(?)
     * Space: O(?)
     */
    fun intToRoman(num: Int): String = convertToRoman(num)

    private fun convertToRoman(n: Int, roman: String = ""): String =
        when (n) {
            0 -> ""
            in arabicToRoman -> roman + arabicToRoman[n]
            else -> {
                val nextLargest = arabicToRoman.keys.last { it < n }
                roman + arabicToRoman[nextLargest] + convertToRoman(n - nextLargest)
            }
        }
}

class SolutionTwo {

    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun intToRoman(num: Int): String = convertIntToRoman(num, "")

    private fun convertIntToRoman(n: Int, numerals: String): String = when (n) {
        0 -> numerals
        else -> {
            val largest = largestValueFor(n)
            val addedNumerals = arabicToRoman[largest] ?: throw IllegalArgumentException("$largest not in map")
            convertIntToRoman(n - largest, numerals + addedNumerals)
        }
    }

    /**
     * Returns a pair of the largest value
     */
    private fun largestValueFor(n: Int): Int = when {
        n >= 1000 -> 1000
        n >= 900 -> 900
        n >= 500 -> 500
        n >= 400 -> 400
        n >= 100 -> 100
        n >= 90 -> 90
        n >= 50 -> 50
        n >= 40 -> 40
        n >= 10 -> 10
        n == 9 -> 9
        n >= 5 -> 5
        n == 4 -> 4
        n >= 1 -> 1
        n == 0 -> 0
        else -> throw IllegalArgumentException("n must be non-negative")
    }

    private val arabicToRoman = mapOf(
        1 to "I",
        4 to "IV",
        5 to "V",
        9 to "IX",
        10 to "X",
        40 to "XL",
        50 to "L",
        90 to "XC",
        100 to "C",
        400 to "CD",
        500 to "D",
        900 to "CM",
        1000 to "M"
    )
}
