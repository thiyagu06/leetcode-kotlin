package extensions.arrays

import extensions.ranges.mid

/**
 * Extensions for [Array] & the primitive array types ([IntArray], [BooleanArray], etc.)
 */

const val NOT_FOUND: Int = -1

/**
 * Get the middle index (if array length is odd, the *first* of the 2 middle indices is returned).
 */
val <T> Array<T>.midIndex: Int get() = indices.mid
val IntArray.midIndex: Int get() = indices.mid
val LongArray.midIndex: Int get() = indices.mid
val CharArray.midIndex: Int get() = indices.mid
val BooleanArray.midIndex: Int get() = indices.mid
val FloatArray.midIndex: Int get() = indices.mid
val DoubleArray.midIndex: Int get() = indices.mid
val ByteArray.midIndex: Int get() = indices.mid
val ShortArray.midIndex: Int get() = indices.mid

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

/**
 * Source: http://tinyurl.com/y92rp67r
 */
inline fun <K> IntArray.groupingBy(crossinline keySelector: (Int) -> K): Grouping<Int, K> = object : Grouping<Int, K> {
    override fun sourceIterator(): IntIterator = this@groupingBy.iterator()
    override fun keyOf(element: Int): K = keySelector(element)
}

/**
 * Return a map where for each entry, the key is an [Int] in the array, and
 * its value is the number of occurrences of the key in the array.
 */
fun IntArray.frequencyMap(): Map<Int, Int> = groupingBy { it }.eachCount()

/**
 * Return a map where for each entry, the key is an element in the array, and
 * its value is the number of occurrences of the element in the array.
 */
fun <T> Array<T>.frequencyMap(): Map<T, Int> = groupingBy { it }.eachCount()

/**
 * Return a map where for each entry, the key is an [Int] in the array, and
 * its value is a list of the indices at which the key is found in the array.
 */
fun IntArray.valueToIndicesMap(): Map<Int, List<Int>> = withIndex()
    .groupBy(keySelector = { it.value }, valueTransform = { it.index })

/**
 * Return a map where for each entry, the key is an element in the array, and
 * its value is a list of the indices at which the element is found in the array.
 */
fun <T> Array<T>.valueToIndicesMap(): Map<T, List<Int>> = withIndex()
    .groupBy(keySelector = { it.value }, valueTransform = { it.index })

/**
 * Return a map where for each entry the key is the `element: T` and
 * its value is the index at which it was found.
 *
 * **Warning**: This is intended for arrays that do not contain duplicates.
 * If the array contains duplicates, use [valueToIndicesMap] instead.
 * If there are duplicates, the value for the element will be the last
 * index at which the key appears.
 */
fun <T> Array<T>.valueToIndexMap(): Map<T, Int> = withIndex()
    .associateBy(keySelector = { it.value }, valueTransform = { it.index })

/**
 * Return a map where for each entry the key is the `element: T` and
 * its value is the index at which it was found.
 *
 * **Warning**: This is intended for arrays that do not contain duplicates.
 * If the array contains duplicates, use [valueToIndicesMap] instead.
 * If there are duplicates, the value for the element will be the last
 * index at which the key appears.
 */
fun IntArray.valueToIndexMap(): Map<Int, Int> = withIndex()
    .associateBy(keySelector = { it.value }, valueTransform = { it.index })

/**
 * Returns a list of pairs of each two adjacent elements in this collection.
 * The returned list is empty if this collection contains less than two elements.
 *
 * ```
 * val letters = arrayOf('a', 'b', 'c', 'd', 'e', 'f')
 * val pairs = letters.zipWithNext()
 *
 * println(letters) // [a, b, c, d, e, f]
 * println(pairs)   // [(a, b), (b, c), (c, d), (d, e), (e, f)]
 * ```
 */
fun <T> Array<T>.zipWithNext(): List<Pair<T, T>> = zip(drop(1))

/**
 * Returns a list of pairs of each two adjacent elements in this collection.
 * The returned list is empty if this collection contains less than two elements.
 *
 * ```
 * val nums = intArrayOf(0, 1, 2, 3, 4, 5)
 * val pairs = nums.zipWithNext()
 *
 * println(nums.contentToString())  // [0, 1, 2, 3, 4, 5]
 * println(pairs)                   // [(0, 1), (1, 2), (2, 3), (3, 4), (4, 5)]
 * ```
 */
fun IntArray.zipWithNext(): List<Pair<Int, Int>> = zip(drop(1))

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
 * @throws IllegalArgumentException if [indexRange] is invalid
 */
fun <T> Array<T>.reverseElementsInRange(indexRange: IntRange) {
    var i = indexRange.start
    var j = indexRange.endInclusive

    require(indexRange.start in indices && indexRange.endInclusive in indices && i <= j) {
        "Invalid indexRange: $indexRange for array with indices: $indices"
    }

    while (i < j) {
        swap(i++, j--)
    }
}

/**
 * **Mutating** - Reverse the elements in the given index range.
 * @throws IllegalArgumentException if [indexRange] is invalid
 */
fun IntArray.reverseElementsInRange(indexRange: IntRange) {
    var i = indexRange.start
    var j = indexRange.endInclusive

    require(indexRange.start in indices && indexRange.endInclusive in indices && i <= j) {
        "Invalid indexRange: $indexRange for array with indices: $indices"
    }

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

/**
 * Check if all elements in the [Array] are sorted (in increasing order).
 */
fun <T : Comparable<T>> Array<T>.isSorted(): Boolean = zipWithNext().all { (a, b) -> b >= a }

fun IntArray.isSorted(): Boolean = zipWithNext().all { (a, b) -> b >= a }
fun CharArray.isSorted(): Boolean = (0 until lastIndex).all { i -> this[i] <= this[i + 1] }
fun LongArray.isSorted(): Boolean = (0 until lastIndex).all { i -> this[i] <= this[i + 1] }
fun ShortArray.isSorted(): Boolean = (0 until lastIndex).all { i -> this[i] <= this[i + 1] }
fun DoubleArray.isSorted(): Boolean = (0 until lastIndex).all { i -> this[i] <= this[i + 1] }
fun FloatArray.isSorted(): Boolean = (0 until lastIndex).all { i -> this[i] <= this[i + 1] }

/**
 * Check if all elements in the [Array] are sorted in _descending_ order.
 */
fun <T : Comparable<T>> Array<T>.isSortedDescending(): Boolean = (0 until lastIndex).all { i -> this[i] >= this[i + 1] }

fun IntArray.isSortedDescending(): Boolean = (0 until lastIndex).all { i -> this[i] >= this[i + 1] }
fun CharArray.isSortedDescending(): Boolean = (0 until lastIndex).all { i -> this[i] >= this[i + 1] }
fun ShortArray.isSortedDescending(): Boolean = (0 until lastIndex).all { i -> this[i] >= this[i + 1] }
fun DoubleArray.isSortedDescending(): Boolean = (0 until lastIndex).all { i -> this[i] >= this[i + 1] }
fun FloatArray.isSortedDescending(): Boolean = (0 until lastIndex).all { i -> this[i] >= this[i + 1] }
fun LongArray.isSortedDescending(): Boolean = (0 until lastIndex).all { i -> this[i] >= this[i + 1] }

/**
 * Returns all contiguous, non-empty subarrays
 *
 * **Time**: `O(n^2)`
 *
 * **Space**: `O(n)`
 */
fun IntArray.subarrays(): List<IntArray> =
    foldIndexed(mutableListOf()) { i, acc, _ ->
        (i..lastIndex).forEach { j ->
            acc.apply {
                acc.add(sliceArray(i..j))
            }
        }
        acc
    }

/**
 * Returns all contiguous, non-empty sublists
 *
 * **Time**: `O(n^2)`
 *
 * **Space**: `O(n)`
 */
fun IntArray.sublists(): List<List<Int>> =
    foldIndexed(mutableListOf()) { i, acc, _ ->
        (i..lastIndex).forEach { j ->
            val sublist = slice(i..j)
            acc.apply {
                acc += sublist
            }
        }
        acc
    }