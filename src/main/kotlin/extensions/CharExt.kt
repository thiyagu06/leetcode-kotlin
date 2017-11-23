package extensions

/**
 * [Char] extensions
 */

/**
 * Returns the decimal value if this is a digit.
 * Note: '0'.toInt() returns 48; '0'.numericValue returns 0.
 * Equivalent of Java's Character.getNumericValue(char c) if the [Char] is
 * a digit, otherwise throws an [IllegalArgumentException].
 * @throws IllegalArgumentException if the receiver is not a digit ('0'..'9').
 */
internal fun Char.numericValue(): Int {
    require(isDigit()) { "Cannot get decimal value of non-digit Char." }
    return toInt() - '0'.toInt()
}

/**
 * See [Char.numericValue]
 */
internal fun Char.decimalValue(): Int = numericValue()

/**
 * Checks whether the Char is a vowel.
 * Note: The set of vowels **does not include y** here.
 */
internal fun Char.isVowel(): Boolean = toLowerCase() in "aeiou"

/**
 * Checks whether the Char is a consonant (not a vowel). 'y' is considered a consonant, not a vowel.
 */
internal fun Char.isConsonant(): Boolean = toLowerCase() !in "aeiou"