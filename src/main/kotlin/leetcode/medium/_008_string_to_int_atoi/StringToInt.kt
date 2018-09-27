package leetcode.medium._008_string_to_int_atoi

import extensions.chars.numericValue
import extensions.math.coerceToIntRange
import java.math.BigInteger

/**
 * 8 - https://leetcode.com/problems/string-to-integer-atoi
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n) - copy of [str] made since in Kotlin parameters can't be modified.
     */
    fun myAtoi(str: String): Int {
        var s = str
        var isNegative = false

        // discard whitespace until 1st non-whitespace char found
        s = s.trimStart()
        if (s.isEmpty()) return 0
        // parse + or - if either present
        if (s[0] in setOf('+', '-')) {
            if (s[0] == '-') {
                isNegative = true
            }
            s = s.drop(1)
        }

        // as many numerical digits as possible, and interprets them as a numerical value.
        // anything after digits ignored
        val digitString = readDigits(s)
        if (digitString.isEmpty()) {
            return 0
        }
        return digitStringToInt(digitString, isNegative)
    }

    /**
     * Read digits at start, ignoring any non-digit chars after.
     */
    internal fun readDigits(s: String): String = s.takeWhile { it.isDigit() }

    /**
     * Convert the string of digits to a [BigInteger], and then coerce to
     */
    internal fun digitStringToInt(digits: String, isNegative: Boolean): Int {
        val bigIntegerVal = if (isNegative) digits.toBigInteger().negate() else digits.toBigInteger()
        val bigIntegerCoercedToIntRange =
            bigIntegerVal.coerceIn(Int.MIN_VALUE.toBigInteger()..Int.MAX_VALUE.toBigInteger())
        return bigIntegerCoercedToIntRange.toInt()
    }
}

class SolutionTwo {
    /**
     * Time: O(n)
     * Space: O(n) - copy of [str] made since in Kotlin parameters can't be modified.
     */
    fun myAtoi(str: String): Int {
        var s = str

        // discard whitespace until 1st non-whitespace char found
        s = s.trimStart()
        if (s.isEmpty()) return 0

        val signAndDigits = parseSignAndDigits(s)
        val bigIntVal = parseBigInteger(signAndDigits) ?: return 0

        return bigIntVal.coerceToIntRange()
    }

    internal fun parseSignAndDigits(s: String): String {
        var signAndDigits = ""
        s.forEachIndexed { i, ch ->
            when {
                i == 0 && !ch.isDigit() && ch.isSign() -> if (ch == '-') signAndDigits += ch
                ch.isDigit() -> signAndDigits += ch
                else -> return signAndDigits
            }
        }
        return signAndDigits
    }

    internal fun parseBigInteger(string: String): BigInteger? {
        if (string.isBlank()) return null

        var bigIntegerVal = BigInteger.ZERO
        var isNegative = false
        var digits: String

        // Check for + or - preceding number
        if (string.first() in setOf('+', '-')) {
            if (string.first() == '-') {
                isNegative = true
            }
            digits = string.drop(1)
        } else {
            digits = string
        }

        if (digits.isBlank() || !digits.first().isDigit()) {
            return null
        }

        digits = digits.reversed()
        var placeMultiplier = BigInteger.ONE
        for (digit in digits) {
            if (!digit.isDigit()) {
                break
            }
            val number = digit.numericValue.toBigInteger()
            val digitValue = number * placeMultiplier
            bigIntegerVal += digitValue

            placeMultiplier *= BigInteger.TEN
        }
        return if (isNegative) bigIntegerVal.negate() else bigIntegerVal
    }

    private fun Char.isSign(): Boolean = this in setOf('-', '+')
}