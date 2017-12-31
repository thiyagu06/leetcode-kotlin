package extensions

/**
 * Number (Int, Double, Float, Byte, Short, etc.) extensions.
 *
 * @author nrojiani
 * @date 11/15/17
 */

/********************
 * Int
 ********************/

val Int.isEven: Boolean get() = this % 2 == 0
val Int.isOdd: Boolean get() = this % 2 == 1

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
fun Int.charForDigit(): Char = Character.forDigit(this, 10)

/**
 * Returns the digits in the [Int] receiver.
 * e.g., `497.digits() --> [4, 9, 7]`
 *
 * Requires that the integer be >= 0
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

    return digits.reversed()
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
    require(digits in 1..totalDigits) { "invalid argument 'digits': $digits. Must be in range 0..total number of digits" }
    val divOperand = Math.pow(10.0, (totalDigits - digits).toDouble()).toInt()
    return this / divOperand
}

fun Int.firstDigit(): Int = valueOfNLeftmostDigits(1)
fun Int.lastDigit(): Int = this % 10

