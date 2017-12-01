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

internal val Int.isEven: Boolean
    get() = this % 2 == 0

internal val Int.isOdd: Boolean
    get() = this % 2 == 1

/**
 * Applies Java's [Character.forDigit].
 */
internal fun Int.charForDigit(radix: Int = 10): Char = Character.forDigit(this, radix)

// note: 03 will be returned as 3
internal fun Int.valueOfNRightmostDigits(digits: Int): Int {
    require(digits >= 1) { "invalid argument 'digits': $digits. Must be >= 1" }
    val modOperand = Math.pow(10.0, digits.toDouble()).toInt()
    return this % modOperand
}

internal fun Int.valueOfNLeftmostDigits(digits: Int): Int {
    val totalDigits = numberOfDigits()
    require(digits in 1..totalDigits) { "invalid argument 'digits': $digits. Must be in range 0..total number of digits" }
    val divOperand = Math.pow(10.0, (totalDigits - digits).toDouble()).toInt()
    return this / divOperand
}

internal fun Int.valueOfLeftmostDigit(): Int = valueOfNLeftmostDigits(1)
internal fun Int.valueOfRightmostDigit(): Int = valueOfNRightmostDigits(1)

internal fun Int.numberOfDigits(): Int {
    var remainder = Math.abs(this)
    var digits = 0

    while (remainder > 0) {
        remainder /= 10
        digits++
    }

    return digits
}

/**
 * Time: O(n) - where n is the number of digits in the integer.
 * Space: O(n)
 */
internal fun Int.digits(): List<Char> {
    var remainder = Math.abs(this)
    val digits = mutableListOf<Char>()

    while (remainder > 0) {
        val rightmostDigit = remainder % 10
        digits.add(0, rightmostDigit.charForDigit())
        remainder /= 10
    }

    return digits
}


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