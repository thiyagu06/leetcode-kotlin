package extensions

/**
 * [Pair] extensions
 */
internal fun Pair<Boolean, Boolean>.toBooleanArray(): BooleanArray = booleanArrayOf(first, second)
internal fun Pair<Byte, Byte>.toByteArray(): ByteArray = byteArrayOf(first, second)
internal fun Pair<Char, Char>.toCharArray(): CharArray = charArrayOf(first, second)
internal fun Pair<Double, Double>.toDoubleArray(): DoubleArray = doubleArrayOf(first, second)
internal fun Pair<Int, Int>.toIntArray(): IntArray = intArrayOf(first, second)
internal fun Pair<Long, Long>.toLongArray(): LongArray = longArrayOf(first, second)
internal fun Pair<Short, Short>.toShortArray(): ShortArray = shortArrayOf(first, second)
