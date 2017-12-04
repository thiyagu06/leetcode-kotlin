package extensions

/**
 * [Pair] extensions
 */
fun Pair<Boolean, Boolean>.toBooleanArray(): BooleanArray = booleanArrayOf(first, second)
fun Pair<Byte, Byte>.toByteArray(): ByteArray = byteArrayOf(first, second)
fun Pair<Char, Char>.toCharArray(): CharArray = charArrayOf(first, second)
fun Pair<Double, Double>.toDoubleArray(): DoubleArray = doubleArrayOf(first, second)
fun Pair<Int, Int>.toIntArray(): IntArray = intArrayOf(first, second)
fun Pair<Long, Long>.toLongArray(): LongArray = longArrayOf(first, second)
fun Pair<Short, Short>.toShortArray(): ShortArray = shortArrayOf(first, second)
