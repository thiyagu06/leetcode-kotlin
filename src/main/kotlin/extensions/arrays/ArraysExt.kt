package extensions.arrays

/**
 * Extensions for Array<T> & the primitive array types (BooleanArray, DoubleArray, etc.)
 */

const val NOT_FOUND: Int = -1

val <T> Array<T>.head: T? get() = firstOrNull()
val <T> Array<T>.tail: Array<T> get() = sliceArray(1 until size)
val <T> Array<T>.headAndTail: Pair<T?, Array<T>> get() = (head to tail)

val IntArray.head: Int? get() = firstOrNull()
val IntArray.tail: IntArray get() = sliceArray(1 until size)
val IntArray.headAndTail: Pair<Int?, IntArray> get() = (head to tail)

val BooleanArray.head: Boolean? get() = firstOrNull()
val BooleanArray.tail: BooleanArray get() = sliceArray(1 until size)
val BooleanArray.headAndTail: Pair<Boolean?, BooleanArray> get() = (head to tail)

val CharArray.head: Char? get() = firstOrNull()
val CharArray.tail: CharArray get() = sliceArray(1 until size)
val CharArray.headAndTail: Pair<Char?, CharArray> get() = (head to tail)

val DoubleArray.head: Double? get() = firstOrNull()
val DoubleArray.tail: DoubleArray get() = sliceArray(1 until size)
val DoubleArray.headAndTail: Pair<Double?, DoubleArray> get() = (head to tail)

/* https://github.com/Carleslc/kotlin-extensions/blob/master/src/me/carleslc/kotlin/extensions/arrays/ArrayExtensions.kt */
fun <T> Array<T>?.isBlank(): Boolean = this == null || isEmpty()

fun <T> Array<T?>.anyNull(): Boolean = any { it == null }
fun <T> Array<T?>.allNull(): Boolean = all { it == null }

fun IntArray?.isBlank(): Boolean = this == null || isEmpty()

/**
 * Return true if the object is either an Array<T> or primitive array type.
 */
fun Any.isArrayType(): Boolean {
    if (this is Array<*>)
        return true

    val primitiveArrayTypes = setOf(
        BooleanArray::class,
        ByteArray::class,
        CharArray::class,
        DoubleArray::class,
        FloatArray::class,
        IntArray::class,
        LongArray::class,
        ShortArray::class
    )

    return this::class in primitiveArrayTypes
}

/**
 * Source: http://tinyurl.com/y92rp67r
 */
inline fun <K> IntArray.groupingBy(crossinline keySelector: (Int) -> K): Grouping<Int, K> = object : Grouping<Int, K> {
    override fun sourceIterator(): IntIterator = this@groupingBy.iterator()
    override fun keyOf(element: Int): K = keySelector(element)
}

/**
 * Return a map where the entries are (element -> # of occurrences)
 */
fun IntArray.frequencyMap(): Map<Int, Int> = groupingBy { it }.eachCount()

/**
 * Return a map where the entries are (element -> # of occurrences)
 */
fun <T> Array<T>.frequencyMap(): Map<T, Int> = groupingBy { it }.eachCount()

/**
 * Return a map where the entries are (element -> List of indices containing element)
 */
fun IntArray.valueToIndicesMap(): Map<Int, List<Int>> = withIndex()
    .groupBy(keySelector = { it.value }, valueTransform = { it.index })

/**
 * Return a map where the entries are (element -> List of indices containing element)
 */
fun <T> Array<T>.valueToIndicesMap(): Map<T, List<Int>> = withIndex()
    .groupBy(keySelector = { it.value }, valueTransform = { it.index })

/**
 * **Mutating** - Swap the elements at indices [i] and [j].
 */
fun <T> Array<T>.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

/**
 * **Mutating** - Swap the elements at indices [i] and [j].
 */
fun IntArray.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

/**
 * **Mutating** - Swap the elements at indices [i] and [j].
 */
fun CharArray.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

/**
 * **Mutating** - Reverse the elements in the given index range.
 */
fun <T> Array<T>.reverseElementsInRange(indexRange: IntRange) {
    require(indexRange.start >= 0 && indexRange.endInclusive <= lastIndex) {
        "Invalid indexRange: $indexRange for array with indices: $indices"
    }
    var i = indexRange.start
    var j = indexRange.endInclusive
    while (i < j) {
        swap(i++, j--)
    }
}

/**
 * **Mutating** - Reverse the elements in the given index range.
 */
fun IntArray.reverseElementsInRange(indexRange: IntRange) {
    var i = indexRange.start
    var j = indexRange.endInclusive
    while (i < j) {
        swap(i++, j--)
    }
}

/**
 * **Mutating** - Reverse the elements in the given index range.
 */
fun CharArray.reverseElementsInRange(indexRange: IntRange) {
    var i = indexRange.start
    var j = indexRange.endInclusive
    while (i < j) {
        swap(i++, j--)
    }
}

fun <T : Comparable<T>> Array<T>.isSorted(): Boolean = (0 until lastIndex).all { i -> this[i] <= this[i + 1] }
fun IntArray.isSorted(): Boolean = (0 until lastIndex).all { i -> this[i] <= this[i + 1] }
fun CharArray.isSorted(): Boolean = (0 until lastIndex).all { i -> this[i] <= this[i + 1] }
fun LongArray.isSorted(): Boolean = (0 until lastIndex).all { i -> this[i] <= this[i + 1] }
fun ShortArray.isSorted(): Boolean = (0 until lastIndex).all { i -> this[i] <= this[i + 1] }
fun DoubleArray.isSorted(): Boolean = (0 until lastIndex).all { i -> this[i] <= this[i + 1] }
fun FloatArray.isSorted(): Boolean = (0 until lastIndex).all { i -> this[i] <= this[i + 1] }

fun <T : Comparable<T>> Array<T>.isSortedDescending(): Boolean = (0 until lastIndex).all { i -> this[i] >= this[i + 1] }
fun IntArray.isSortedDescending(): Boolean = (0 until lastIndex).all { i -> this[i] >= this[i + 1] }
fun CharArray.isSortedDescending(): Boolean = (0 until lastIndex).all { i -> this[i] >= this[i + 1] }
fun ShortArray.isSortedDescending(): Boolean = (0 until lastIndex).all { i -> this[i] >= this[i + 1] }
fun DoubleArray.isSortedDescending(): Boolean = (0 until lastIndex).all { i -> this[i] >= this[i + 1] }
fun FloatArray.isSortedDescending(): Boolean = (0 until lastIndex).all { i -> this[i] >= this[i + 1] }
fun LongArray.isSortedDescending(): Boolean = (0 until lastIndex).all { i -> this[i] >= this[i + 1] }


/* Kotlin 1.2 Functionality */
fun IntArray.sublist(indexRange: IntRange): List<Int> {
    require(indexRange.first in indices && indexRange.last in indices) { "Invalid indices" }
    return indexRange.fold(listOf()) { acc, idx ->
        acc + this[idx]
    }
}

fun IntArray.subarrays(): List<IntArray> = foldIndexed(mutableListOf()) { i, acc, _ ->
    (i..lastIndex).forEach { j ->
        acc.apply { acc.add(sliceArray(i..j)) }
    }
    acc
}


fun IntArray.sublists(): List<List<Int>> = foldIndexed(mutableListOf()) { i, acc, _ ->
    (i..lastIndex).forEach { j ->
        val sublist = slice(i..j)
        acc.apply {
            acc += sublist
        }
    }
    acc
}

// Kotlin 1.2 equivalent: asIterable().windowed(size = k, partialWindows = false)
fun IntArray.sublistsOfSize(k: Int): List<List<Int>> {
    require(k in 1..size) { "subarray size k must be in range [1, size]" }
    return (0..size - k).fold(arrayListOf()) { acc, startIndex ->
        acc.apply { acc.add(sublist((startIndex until startIndex + k))) }
    }
}

fun <T> Array<T>.sublist(indexRange: IntRange): List<T> =
    (indexRange.first..indexRange.last).fold(listOf()) { acc, idx ->
        acc + this[idx]
    }

// Kotlin 1.2 equivalent: asIterable().windowed(size = k, partialWindows = false)
fun <T> Array<T>.sublistsOfSize(k: Int): List<List<T>> {
    require(k > 0) { "subarray size k must be > 0" }
    return (0..size - k).fold(arrayListOf()) { acc, startIndex ->
        acc.apply { acc.add(sublist((startIndex until startIndex + k))) }
    }
}
