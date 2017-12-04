package extensions

/**
 * [Triple] extensions
 */
fun Triple<Boolean, Boolean, Boolean>.toBooleanArray(): BooleanArray = booleanArrayOf(first, second, third)
fun Triple<Byte, Byte, Byte>.toByteArray(): ByteArray = byteArrayOf(first, second, third)
fun Triple<Char, Char, Char>.toCharArray(): CharArray = charArrayOf(first, second, third)
fun Triple<Double, Double, Double>.toDoubleArray(): DoubleArray = doubleArrayOf(first, second, third)
fun Triple<Int, Int, Int>.toIntArray(): IntArray = intArrayOf(first, second, third)
fun Triple<Long, Long, Long>.toLongArray(): LongArray = longArrayOf(first, second, third)
fun Triple<Short, Short, Short>.toShortArray(): ShortArray = shortArrayOf(first, second, third)