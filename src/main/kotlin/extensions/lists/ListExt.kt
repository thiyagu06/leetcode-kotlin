package extensions.lists

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
    .groupBy(keySelector = { it.value }, valueTransform = { it.index })

/* Tuples */
fun <T> List<T>.toPair(): Pair<T, T> {
    require(size == 2) { "List must have size 2 to convert to Pair" }
    return Pair(this[0], this[1])
}

fun <T> List<T>.toTriple(): Triple<T, T, T> {
    require(size == 3) { "List must have size 3 to convert to Triple" }
    return Triple(this[0], this[1], this[2])
}

fun <T : Comparable<T>> List<T>.isSorted(): Boolean = (0 until lastIndex).all { i -> this[i] <= this[i + 1] }
fun <T : Comparable<T>> List<T>.isSortedDescending(): Boolean = (0 until lastIndex).all { i -> this[i] >= this[i + 1] }


/* 2D Lists: List<List<T>> */
fun <T> List<List<T>>.debugString(): String = buildString {
    this@debugString.forEach { row ->
        append("$row\n")
    }
}

val <T> List<List<T>>.rows: Int get() = size
val <T> List<List<T>>.columns: Int get() = if (isEmpty()) 0 else this[0].size

val <T> List<List<T>>.rowRange: IntRange get() = 0..lastIndex
val <T> List<List<T>>.columnRange: IntRange get() = if (isEmpty()) 0..0 else 0..this[0].lastIndex

val <T> List<List<T>>.lastRow: Int get() = lastIndex
val <T> List<List<T>>.lastColumn: Int get() = if (isEmpty()) -1 else this[0].lastIndex
