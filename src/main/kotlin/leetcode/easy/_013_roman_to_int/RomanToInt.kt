package leetcode.easy._013_roman_to_int

/**
 * 13 - https://leetcode.com/problems/roman-to-integer/
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

class SolutionTwo {
    private val symbolValues: Map<String, Int> = mapOf(
        "I"  to 1,
        "IV" to 4,
        "V"  to 5,
        "IX" to 9,
        "X"  to 10,
        "XL" to 40,
        "L"  to 50,
        "XC" to 90,
        "C"  to 100,
        "CD" to 400,
        "D"  to 500,
        "CM" to 900,
        "M"  to 1000
    )

    private val subtractiveValues: Set<Char> = setOf('I', 'X', 'C')

    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun romanToInt(s: String): Int {
        var sum = 0

        var i = 0
        while (i <= s.lastIndex) {
            // Check next numeral too if s[i] is I, X, or C
            if (i < s.lastIndex && s[i] in subtractiveValues &&
                (s.substring(i..(i + 1)) in symbolValues)
            ) {
                sum += symbolValues.getValue(s.substring(i..(i + 1)))
                i += 2
            } else {
                sum += symbolValues[s[i].toString()] ?: throw IllegalArgumentException("Unrecognized numeral")
                i++
            }
        }

        return sum
    }
}