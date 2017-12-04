package extensions

/**
 * List extensions
 */

/**
 * Return a map where the entries are (element -> # of occurrences)
 */
fun <T> List<T>.frequencyMap(): Map<T, Int> = groupingBy { it }.eachCount()


/**
 * Return a map where the entries are (element -> List of indices containing element)
 */
fun <T> List<T>.valueToIndicesMap(): Map<T, List<Int>> = withIndex()
        .groupBy(keySelector = { (i, n) -> n }, valueTransform = { (i, n) -> i })