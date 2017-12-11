package extensions


/**
 * Extensions for:
 * Array<T>
 * BooleanArray
 * ByteArray
 * CharArray
 * DoubleArray
 * FloatArray
 * IntArray
 * LongArray
 * ShortArray
 */

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
 * https://github.com/ilya-g/kotlinx.collections.experimental/blob/5a7d58147d6e25d80699fa9abb22130d0a5e0f7b/kotlinx-collections-experimental/src/main/kotlin/kotlinx.collections.experimental/grouping/grouping.kt
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
        .groupBy(keySelector = { (i, n) -> n }, valueTransform = { (i, n) -> i })

/**
 * Return a map where the entries are (element -> List of indices containing element)
 */
fun <T> Array<T>.valueToIndicesMap(): Map<T, List<Int>> = withIndex()
        .groupBy(keySelector = { (i, n) -> n }, valueTransform = { (i, n) -> i })


/************** swap **************/

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

/************** reverseElementsInRange **************/

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


/* Matrices - Array<IntArray> */

typealias Matrix = Array<IntArray>

internal val Matrix.rows: Int
    get() = size

internal val Matrix.columns: Int
    get() = if (isEmpty()) 0 else this[0].size

internal val Matrix.lastRow: Int
    get() = lastIndex

internal val Matrix.lastColumn: Int
    get() = if (isEmpty()) -1 else this[0].lastIndex

internal fun Matrix.debugString() = StringBuilder().apply {
    this@debugString.forEach {
        this.append(it.contentToString() + "\n")
    }
}.toString()

internal fun Matrix.toList(): List<List<Int>> = fold(emptyList()) { acc, intArr ->
    acc.plusElement(intArr.toList())
}

internal fun Matrix.transpose(): Matrix {
    val transposed: Matrix = Array(columns, { IntArray(rows) })
    (0..lastRow).forEach { i ->
        (0..lastColumn).forEach { j ->
            transposed[j][i] = this[i][j]
        }
    }
    return transposed
}
