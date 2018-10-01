package extensions.math

/*
 * Long type extensions.
 */

fun minOf(vararg numbers: Long): Long {
    require(numbers.isNotEmpty()) { "Cannot take min of 0 numbers" }
    return numbers.min()!!
}

/**
 * Coerce the [Long] to be within range [Int.MIN_VALUE]..[Int.MAX_VALUE], and convert the
 * coerced value to an [Int].
 */
fun Long.coerceToIntRange(): Int = coerceIn(Int.MIN_VALUE.toLong()..Int.MAX_VALUE.toLong()).toInt()
