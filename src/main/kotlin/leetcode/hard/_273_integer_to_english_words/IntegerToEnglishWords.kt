package leetcode.hard._273_integer_to_english_words

import extensions.math.isMultipleOf
import java.lang.IllegalArgumentException

/**
 * 273 - https://leetcode.com/problems/integer-to-english-words
 */
class Solution {

    companion object {
        private const val ONE_MILLION = 1000000
        private const val ONE_BILLION = 1000000000
    }

    /**
     * Time: O(?)
     * Space: O(?)
     */
    fun numberToWords(num: Int): String = when (num) {
            0 -> "Zero"
            in 1..9 -> singleDigit(num)
            in 10..19 -> teenWords(num)
            in 20..99 -> {
                val prefix = tensPlacePrefix(num / 10)
                if (num % 10 == 0) prefix
                else "$prefix ${singleDigit(num % 10)}"
            }
            in 100 until 1000 -> numberToWords(num, 100)
            in 1000 until ONE_MILLION -> numberToWords(num, 1000)
            in ONE_MILLION until ONE_BILLION -> numberToWords(num, ONE_MILLION)
            in ONE_BILLION..Int.MAX_VALUE -> numberToWords(num, ONE_BILLION)
            else -> throw IllegalArgumentException("num must be a non-negative Int: [0, Int.MAX_VALUE].")
        }

    /** Gets the largest unit (hundred, thousand, etc.) and recurses on the rest */
    private fun numberToWords(n: Int, divisor: Int): String {
        val denomination = divisorWord(divisor)
        val numLargest = numberToWords(n / divisor)

        return if (n.isMultipleOf(divisor)) {
            "$numLargest $denomination"
        } else {
            "$numLargest $denomination ${numberToWords(n % divisor)}"
        }
    }

    private fun singleDigit(n: Int): String = when (n) {
        1 -> "One"
        2 -> "Two"
        3 -> "Three"
        4 -> "Four"
        5 -> "Five"
        6 -> "Six"
        7 -> "Seven"
        8 -> "Eight"
        9 -> "Nine"
        else -> throw IllegalArgumentException("singleDigit called with n = $n")
    }

    private fun teenWords(n: Int): String = when (n) {
        10 -> "Ten"
        11 -> "Eleven"
        12 -> "Twelve"
        13 -> "Thirteen"
        15 -> "Fifteen"
        18 -> "Eighteen"
        else -> singleDigit(n % 10) + "teen"
    }

    private fun tensPlacePrefix(n: Int): String = when (n) {
        2 -> "Twenty"
        3 -> "Thirty"
        4 -> "Forty"
        5 -> "Fifty"
        6 -> "Sixty"
        7 -> "Seventy"
        8 -> "Eighty"
        9 -> "Ninety"
        else -> throw IllegalArgumentException("tensPlacePrefix should be in range 2..9 (n: $n)")
    }

    private fun divisorWord(divisor: Int) = when (divisor) {
        100 -> "Hundred"
        1000 -> "Thousand"
        ONE_MILLION -> "Million"
        ONE_BILLION -> "Billion"
        else -> throw IllegalArgumentException("unexpected divisor: $divisor. Should be 100, 1K, 1M, or 1B")
    }
}