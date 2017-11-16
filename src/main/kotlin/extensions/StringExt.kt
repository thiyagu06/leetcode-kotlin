package extensions

/**
 * [String] extensions.
 *
 * @author nrojiani
 * @date 11/14/17
 */

/**
 * Return a String with the elements in the specified range reversed.
 */
internal fun String.reverseCharsInRange(indexRange: IntRange) =
        replaceRange(indexRange, substring(indexRange).reversed())
