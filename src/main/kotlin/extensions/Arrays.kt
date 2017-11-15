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
internal fun isArrayType(obj: Any): Boolean {
    if (obj is Array<*>)
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

    return obj::class in primitiveArrayTypes
}

/************** swap **************/

/**
 * **Mutating** - Swap the elements at indices [i] and [j].
 */
internal fun <T> Array<T>.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

/**
 * **Mutating** - Swap the elements at indices [i] and [j].
 */
internal fun IntArray.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

/**
 * **Mutating** - Swap the elements at indices [i] and [j].
 */
internal fun CharArray.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

/************** reverseElementsInRange **************/

/**
 * **Mutating** - Reverse the elements in the given index range.
 */
internal fun <T> Array<T>.reverseElementsInRange(indexRange: IntRange) {
    var i = indexRange.start
    var j = indexRange.endInclusive
    while (i < j) {
        swap(i++, j--)
    }
}

/**
 * **Mutating** - Reverse the elements in the given index range.
 */
internal fun IntArray.reverseElementsInRange(indexRange: IntRange) {
    var i = indexRange.start
    var j = indexRange.endInclusive
    while (i < j) {
        swap(i++, j--)
    }
}

/**
 * **Mutating** - Reverse the elements in the given index range.
 */
internal fun CharArray.reverseElementsInRange(indexRange: IntRange) {
    var i = indexRange.start
    var j = indexRange.endInclusive
    while (i < j) {
        swap(i++, j--)
    }
}

