package extensions

/**
 * String extensions.
 *
 * @author nrojiani
 * @date 11/14/17
 */

/**
 * Return a String with the elements in the specified range reversed.
 * @throws StringIndexOutOfBoundsException if [indexRange] not in `0..lastIndex`
 */
internal fun String.reverseCharsInRange(indexRange: IntRange): String =
        replaceRange(indexRange, substring(indexRange).reversed())

/**
 * Return a string with the Chars at the given indices swapped.
 */
internal fun String.swappingCharsAt(i: Int, j: Int): String =
        if (i == j) this
        else substring(0, i) + this[j] + substring(i + 1, j) + this[i] + substring(j + 1)

internal fun String.isAllCaps(): Boolean = all { it.isUpperCase() }