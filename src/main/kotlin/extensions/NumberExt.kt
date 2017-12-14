package extensions

import java.math.BigInteger

/**
 * Number (Int, Double, Float, Byte, Short, etc. extensions.
 *
 * @author nrojiani
 * @date 11/15/17
 */

/********************
 * Int
 ********************/

val Int.isEven: Boolean
    get() = this % 2 == 0

val Int.isOdd: Boolean
    get() = this % 2 == 1


/**
 * Uses [java.lang.Math]'s abs() function.
 * (From Javadoc) Note that for Int.MIN_VALUE, the most negative representable int value, the result is that same value,
 * which is negative, since it can't be represented as a positive 32-bit integer.
 */
val Int.absValue: Int
    get() = Math.abs(this)

/**
 * Applies Java's [Character.forDigit].
 */
fun Int.charForDigit(radix: Int = 10): Char = Character.forDigit(this, radix)

/**
 * Returns the digits in the [Int] receiver.
 * e.g., `497.digits() --> [4, 9, 7]`
 */
fun Int.digits(): List<Int> {
    require(this >= 0) { "Must be > 0" }
    if (this == 0) return listOf(0)

    var remainder = Math.abs(this)
    val digits = mutableListOf<Int>()

    while (remainder > 0) {
        val rightmostDigit = remainder % 10
        digits.add(rightmostDigit)
        remainder /= 10
    }

    return digits
}

/**
 * Time: O(n) - where n is the number of digitsAsChars in the integer.
 * Space: O(n)
 */
fun Int.digitsAsChars(): List<Char> {
    var remainder = Math.abs(this)
    val digits = mutableListOf<Char>()

    while (remainder > 0) {
        val rightmostDigit = remainder % 10
        digits.add(0, rightmostDigit.charForDigit())
        remainder /= 10
    }

    return digits
}

fun Int.numberOfDigits(): Int = digits().size

// note: 03 will be returned as 3
fun Int.valueOfNRightmostDigits(digits: Int): Int {
    require(digits >= 1) { "invalid argument 'digitsAsChars': $digits. Must be >= 1" }
    val modOperand = Math.pow(10.0, digits.toDouble()).toInt()
    return this % modOperand
}

fun Int.valueOfNLeftmostDigits(digits: Int): Int {
    val totalDigits = numberOfDigits()
    require(digits in 1..totalDigits) { "invalid argument 'digitsAsChars': $digits. Must be in range 0..total number of digitsAsChars" }
    val divOperand = Math.pow(10.0, (totalDigits - digits).toDouble()).toInt()
    return this / divOperand
}

fun Int.firstDigit(): Int = valueOfNRightmostDigits(1)
fun Int.lastDigit(): Int = valueOfNLeftmostDigits(1)

/**
 * Calculates the factorial, `n!`.
 */
fun Int.factorial(): BigInteger {
    require(this >= 0) { "Must be > 0" }
    return when (this) {
        in 0..1 -> BigInteger.ONE
        else -> {
            var result = BigInteger.ONE
            var i = BigInteger.valueOf(this.toLong())
            while (i > BigInteger.ONE) {
                result = i.multiply(result)
                i = i.minus(BigInteger.ONE)
            }
            return result
        }
    }
}