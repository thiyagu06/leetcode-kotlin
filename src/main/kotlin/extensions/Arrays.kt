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

internal fun <T> Array<T>.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

internal fun IntArray.swapElementsAt(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}