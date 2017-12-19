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
fun String.reverseCharsInRange(indexRange: IntRange): String =
        replaceRange(indexRange, substring(indexRange).reversed())

/**
 * Return a string with the Chars at the given indices swapped.
 */
fun String.swappingCharsAt(i: Int, j: Int): String =
        if (i == j) this
        else substring(0, i) + this[j] + substring(i + 1, j) + this[i] + substring(j + 1)

fun String.isAllCaps(): Boolean = all { it.isUpperCase() }

/**
 * Returns a map of each character to its frequency.
 * If `caseSensitive`, all keys will be lowercase.
 */
fun String.characterFrequencies(caseSensitive: Boolean = true): Map<Char, Int> =
        groupingBy { if (caseSensitive) it.toLowerCase() else it }.eachCount()


/**
 * Return a list of the distinct chars in the string.
 */
fun String.distinctChars(): List<Char> = toCharArray().distinct()