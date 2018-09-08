package extensions.math

/**
 * Binary/Hexadecimal Extensions
 */

const val INT_BITS = 32

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

/**
 * Converts a non-negative binary string to an integer.
 * @exception  NumberFormatException If the binary string represents a negative number or can't be parsed
 */
fun String.parseNonNegativeBinaryString(): Int = Integer.parseInt(this, 2)

fun Int.isOdd(): Boolean = (this and 1) == 1
fun Int.isEven(): Boolean = (this and 1) == 0

enum class BinaryValue { ZERO, ONE }

/**
 * @return the Int produced by setting the last bit to 0 or 1
 */
fun Int.withLastBitSetTo(value: BinaryValue): Int = when (value) {
    BinaryValue.ZERO -> (this or 1) - 1
    BinaryValue.ONE -> this or 1
}

/**
 * TODO keep & remove withLastBitSetTo or delete
 * @return the Int produced by setting the last bit (to 1)
 */
fun Int.withLastBitSet(): Int = this or 1

/**
 * TODO keep & remove withLastBitSetTo or delete
 * @return the Int produced by unsetting the last bit (i.e., making it 0)
 */
fun Int.withLastBitUnset(): Int = (this or 1) - 1


val Int.isPowerOfTwo: Boolean get() = this > 0 && (this and (this - 1)) == 0

/**
 * @param k the kth least significant digit, where k = 0 is the least significant bit.
 */
fun Int.hasKthBitSet(k: Int): Boolean {
    require(k in 0..31) { "k must be in range 0..31" }
    return (this and (1 shl k)) != 0
}

/**
 * @param k the kth least significant digit, where k = 0 is the least significant bit.
 */
fun Int.valueOfKthBit(k: Int): Int = if (hasKthBitSet(k)) 1 else 0


/**
 * See [Integer.bitCount].
 * @return the number of set (`1`) bits in the [Int].
 */
fun Int.numberOfOneBits(): Int = Integer.bitCount(this)

/**
 * @return the number of unset (`0`) bits in the [Int].
 */
fun Int.numberOfZeroBits(): Int = INT_BITS - Integer.bitCount(this)

/**
 * Shows how to do it manually, instead of using [Integer.bitCount].
 * @return the number of set (`1`) bits in the [Int].
 */
fun Int.numberOfOneBitsAlt(): Int =
    (0 until 32).fold(0) { acc, k ->
        if (this and (0b1 shl k) != 0)
            acc + 1
        else acc
    }

/**
 * Shows how to do it manually, instead of using [Integer.bitCount].
 * @return the number of unset (`0`) bits in the [Int].
 */
fun Int.numberOfZeroBitsAlt(): Int =
    (0 until 32).fold(0) { acc, k ->
        if (this and (0b1 shl k) == 0)
            acc + 1
        else acc
    }

/**
 * See [Integer.reverse]
 */
fun Int.reverseBits(): Int = Integer.reverse(this)

/**
 * See [Integer.reverseBytes]
 */
fun Int.reverseBytes(): Int = Integer.reverseBytes(this)


// TODO
// withKthBit(Set/Unset)
// toggleKthBit()