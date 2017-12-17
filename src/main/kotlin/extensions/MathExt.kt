package extensions

import java.math.BigInteger

/**
 * Mathematical functions & utilities not in java.lang.Math
 */

/**
 * Calculates the factorial, `n!`.
 */
fun Int.factorial(): BigInteger {
    require(this >= 0) { "Must be > 0" }
    return when (this) {
        in 0..1 -> BigInteger.ONE
        else -> {
            var result = BigInteger.ONE
            var i = BigInteger.valueOf(this.toLong())
            while (i > BigInteger.ONE) {
                result = i.multiply(result)
                i = i.minus(BigInteger.ONE)
            }
            return result
        }
    }
}

/*
BigInteger/BigDecimal - available with Kotlin 1.2+
public inline operator fun BigInteger.plus(other: BigInteger): BigInteger = this.add(other)
public inline operator fun BigInteger.minus(other: BigInteger): BigInteger = this.subtract(other)
public inline operator fun BigInteger.times(other: BigInteger): BigInteger = this.multiply(other)
public inline operator fun BigInteger.div(other: BigInteger): BigInteger = this.divide(other)
public inline operator fun BigInteger.rem(other: BigInteger): BigInteger = this.remainder(other)
public inline operator fun BigInteger.unaryMinus(): BigInteger = this.negate()
public inline operator fun BigInteger.inc(): BigInteger = this.add(BigInteger.ONE)
public inline operator fun BigInteger.dec(): BigInteger = this.subtract(BigInteger.ONE)
public inline fun BigInteger.inv(): BigInteger = this.not()
public inline infix fun BigInteger.and(other: BigInteger): BigInteger = this.and(other)
public inline infix fun BigInteger.or(other: BigInteger): BigInteger = this.or(other)
public inline infix fun BigInteger.xor(other: BigInteger): BigInteger = this.xor(other)
public inline infix fun BigInteger.shl(n: Int): BigInteger = this.shiftLeft(n)
public inline infix fun BigInteger.shr(n: Int): BigInteger = this.shiftRight(n)
public inline fun Int.toBigInteger(): BigInteger = BigInteger.valueOf(this.toLong())
public inline fun Long.toBigInteger(): BigInteger = BigInteger.valueOf(this)
public inline fun BigInteger.toBigDecimal(): BigDecimal = BigDecimal(this)
public inline fun BigInteger.toBigDecimal(scale: Int = 0, mathContext: MathContext = MathContext.UNLIMITED): BigDecimal =
        BigDecimal(this, scale, mathContext)

public inline operator fun BigDecimal.plus(other: BigDecimal): BigDecimal = this.add(other)
public inline operator fun BigDecimal.minus(other: BigDecimal): BigDecimal = this.subtract(other)
public inline operator fun BigDecimal.times(other: BigDecimal): BigDecimal = this.multiply(other)
public inline operator fun BigDecimal.div(other: BigDecimal): BigDecimal = this.divide(other, RoundingMode.HALF_EVEN)
public inline operator fun BigDecimal.mod(other: BigDecimal): BigDecimal = this.remainder(other)
public inline operator fun BigDecimal.rem(other: BigDecimal): BigDecimal = this.remainder(other)
public inline operator fun BigDecimal.unaryMinus(): BigDecimal = this.negate()
public inline operator fun BigDecimal.inc(): BigDecimal = this.add(BigDecimal.ONE)
public inline operator fun BigDecimal.dec(): BigDecimal = this.subtract(BigDecimal.ONE)
public inline fun Int.toBigDecimal(): BigDecimal = BigDecimal(this)
public inline fun Int.toBigDecimal(mathContext: MathContext): BigDecimal = BigDecimal(this, mathContext)
public inline fun Long.toBigDecimal(): BigDecimal = BigDecimal(this)
public inline fun Long.toBigDecimal(mathContext: MathContext): BigDecimal = BigDecimal(this, mathContext)
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

/**
 * https://brilliant.org/wiki/sum-of-n-n2-or-n3/
 */
fun sumOfFirstNPositiveIntegers(n: Int) = ((n * (n + 1)) / 2)