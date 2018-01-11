package algorithms.medium._012_int_to_roman

/**
 * 12 - https://leetcode.com/problems/integer-to-roman/description/
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
