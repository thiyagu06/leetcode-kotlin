package extensions.chars

/**
 * Char extensions
 */

/**
 * Returns the [Char]'s ASCII (American Standard Code for Information Interchange) value.
 * This is equivalent to calling `Char.toInt()`
 */
val Char.asciiValue: Int get() = toInt()

/**
 * Maps each [Char] to an index for use in a (case-insensitive) alphabet dictionary (`int[26]`, or `boolean[26]`).
 * `'a'.alphaIndex` == 0
 * `'z'.alphaIndex` == 25
 * `'B'.alphaIndex` == 1
 */
val Char.alphaIndex: Int get() = toLowerCase() - 'a'


/**
 * Returns the decimal value if this is a digit.
 * Note: '0'.toInt() returns 48; '0'.numericValue returns 0.
 * Equivalent of Java's Character.getNumericValue(char c) if the [Char] is
 * a digit, otherwise throws an [IllegalArgumentException].
 * @throws IllegalArgumentException if the receiver is not a digit ('0'..'9').
 */
fun Char.numericValue(): Int {
    require(isDigit()) { "Cannot get decimal value of non-digit Char." }
    return toString().toInt()
}

/**
 * Checks whether the Char is a vowel.
 * Note: 'y' isn't not considered a vowel here.
 */
fun Char.isVowel(): Boolean = toLowerCase() in "aeiou"
