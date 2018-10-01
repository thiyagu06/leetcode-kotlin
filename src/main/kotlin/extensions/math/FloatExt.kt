package extensions.math

/*
 * Extensions for Float
 */

fun minOf(vararg numbers: Float): Float {
    require(numbers.isNotEmpty()) { "Cannot take min of 0 numbers" }
    return numbers.min()!!
}
