package extensions

import java.math.BigInteger

/**
 * Mathematical functions & utilities not in java.lang.Math
 */

/* Discrete Math/Combinatorics */
/**
 * Calculate the number of k-combinations: C(n, k) (aka nCk, nCr, 'n choose k').
 */
fun choose(n: Int, k: Int): BigInteger {
    require (n >= 0 && k >= 0) { "C(n, k) for C($n, $k): n and k must be > 0" }
    require (n >= k) { "C(n, k) for C($n, $k): n must be >= k" }

    if (n == k || k == 0) {
        return BigInteger.ONE
    } else if (k == 1) {
        return BigInteger.valueOf(n.toLong())
    }

    val numerator = n.factorial()
    val denominator = (k.factorial()).multiply( (n - k).factorial() )
    return numerator.divide(denominator)
}


// TODO - list to set
fun <T> powerSet(elements: List<T>): List<List<T>> {
    return if (elements.isEmpty()) {
        emptyList()
    } else {
        elements.foldIndexed(listOf(emptyList())) { index, acc, _ ->
            acc + powerSet(elements.drop(index + 1))
                    .map { listOf(elements[index]) + it }
        }
    }
}

/**
 * combinations("abcde".toList(), 3)
 * [[a, b, c], [a, b, d], [a, b, e], [a, c, d], [a, c, e], [a, d, e], [b, c, d], [b, c, e], [b, d, e], [c, d, e]]
 */
fun <T> combinations(elements: List<T>, k: Int = elements.size): List<List<T>> =
        if (elements.isEmpty())
            listOf(emptyList())
        else
            elements.foldIndexed(listOf(emptyList<T>())) { index, acc, _ ->
                acc + combinations(elements.drop(index + 1), k - 1)
                        .map { listOf(elements[index]) + it }
            }.filter {
                it.size == k
            }
