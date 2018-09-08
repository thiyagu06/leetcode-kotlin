package extensions.math

/**
 * Binary/Hexadecimal Extensions
 */

/**
 * Convert Int to binary string:
 *
 * The result is padded to the specified number of bits, or 32 by default.
 *
 * ```
 * 67.toBinaryString()    =>  00000000000000000000000001000011
 * (-67).toBinaryString() =>  11111111111111111111111110111101
 * ```
 *
 * @param bits The number of bits in the binary string representation (default: 32)
 */
fun Int.toBinaryString(bits: Int = 32): String = when {
    this >= 0 -> java.lang.Integer.toBinaryString(this).padStart(bits, '0')
    else -> java.lang.Integer.toBinaryString(this)
}

fun Int.isOdd(): Boolean = (this and 1) == 1
fun Int.isEven(): Boolean = (this and 1) == 0