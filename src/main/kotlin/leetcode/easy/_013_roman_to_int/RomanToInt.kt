package leetcode.easy._013_roman_to_int

/**
 * 13 - https://leetcode.com/problems/roman-to-integer/description/
 */
class Solution {

    private val romanNumeral = mapOf(
            'I'  to 1,
            'V'  to 5,
            'X'  to 10,
            'L'  to 50,
            'C'  to 100,
            'D'  to 500,
            'M'  to 1000
    )

    private val subtractiveValue = mapOf(
            "IV" to 4,
            "IX" to 9,
            "XL" to 40,
            "XC" to 90,
            "CD" to 400,
            "CM" to 900
    )

    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun romanToInt(s: String): Int {
        var decimalValue = 0
        var numerals = s
        while (numerals.isNotEmpty()) {
            val subtractivePairSum = subtractiveValue[numerals.take(2)]
            val firstNumeralValue = romanNumeral[numerals.first()]
            when {
                subtractivePairSum != null -> {
                    decimalValue += subtractivePairSum
                    numerals = numerals.drop(2)
                }
                firstNumeralValue != null -> {
                    decimalValue += firstNumeralValue
                    numerals = numerals.drop(1)
                }
            }
        }
        return decimalValue
    }
}
