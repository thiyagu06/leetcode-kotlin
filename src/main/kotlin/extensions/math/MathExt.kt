package extensions.math

import extensions.arrays.headAndTail
import java.math.BigInteger
import kotlin.math.sqrt

/**
 * Mathematical functions
 * Permutation/Combinations taken from: https://github.com/MarcinMoskala/KotlinDiscreteMathToolkit
 */


fun Int.isPrime(): Boolean {
    if (this <= 1)
        return false

    val sqrt = sqrt(toDouble()).toInt()
    return (2..sqrt).all { this % it != 0 }
}

/** https://brilliant.org/wiki/sum-of-n-n2-or-n3 */
fun sumOfFirstNPositiveIntegers(n: Int) = ((n * (n + 1)) / 2)

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

/* Discrete Math/Combinatorics */
/**
 * Calculate the number of k-combinations: C(n, k) (aka nCk, nCr, 'n choose k').
 */
fun choose(n: Int, k: Int): BigInteger {
    require(n >= 0 && k >= 0) { "C(n, k) for C($n, $k): n and k must be > 0" }
    require(n >= k) { "C(n, k) for C($n, $k): n must be >= k" }

    if (n == k || k == 0) {
        return BigInteger.ONE
    } else if (k == 1) {
        return BigInteger.valueOf(n.toLong())
    }

    val numerator = n.factorial()
    val denominator = (k.factorial()).multiply((n - k).factorial())
    return numerator.divide(denominator)
}

/**
 * Generates all combinations of size [k].
 */
fun <T> Set<T>.combinations(k: Int): Set<Set<T>> = when {
    k < 0 -> throw Error("k cannot be smaller then 0, but was $k")
    k == 0 -> setOf(setOf())
    k >= size -> setOf(toSet())
    else -> powerSet()
        .filter { it.size == k }
        .toSet()
}

/** http://tinyurl.com/yd526qh2 */
fun <T> Collection<T>.powerSet(): Set<Set<T>> = powerSet(this, setOf(setOf()))

private tailrec fun <T> powerSet(left: Collection<T>, acc: Set<Set<T>>): Set<Set<T>> =
    if (left.isEmpty()) acc
    else powerSet(left.drop(1), acc + acc.map { it + left.first() })


/**
 * Generates all permutations (including non-distinct, by default)
 */
fun <T> List<T>.permutations(distinct: Boolean = false): Set<List<T>> =
    if (distinct) permutations().distinct().toSet() else permutations()


private fun <T> List<T>.permutations(): Set<List<T>> = when (size) {
    0 -> setOf()
    1 -> setOf(listOf(first()))
    else ->
        drop(1).permutations()
            .flatMap { sublist ->
                (0..sublist.size).map { i ->
                    sublist.plusAtIndex(index = i, element = first())
                }
            }.toSet()
}

/** http://tinyurl.com/y9kzqfmp */
private fun <T> List<T>.plusAtIndex(index: Int, element: T): List<T> {
    require (index in 0..size) { "Invalid index: $index (size: $size)" }
    return when (index) {
        0 -> listOf(element) + this
        size -> this + element
        else -> dropLast(size - index) + element + drop(index)
    }
}


// Returns List<List<Int>> due to signature of LeetCode Problems 46-47
fun IntArray.permutations(): List<List<Int>> = when (size) {
    0 -> listOf()
    1 -> listOf(listOf(this[0]))
    else -> {
        val (head, tail) = headAndTail()
        tail.permutations().flatMap { sublist ->
            (0..sublist.size).map { i ->
                sublist.plusAtIndex(index = i, element = head!!)
            }
        }
    }
}

/* kotlin.math: available with Kotlin 1.2+, but LeetCode uses 1.1
import java.lang.Math as nativeMath

public inline fun abs(x: Double): Double = nativeMath.abs(x)
public inline fun abs(x: Float): Float = nativeMath.abs(x)
public inline fun abs(n: Int): Int = nativeMath.abs(n)
public inline fun abs(n: Long): Long = nativeMath.abs(n)

public inline val Double.absoluteValue: Double get() = nativeMath.abs(this)
public inline val Float.absoluteValue: Float get() = nativeMath.abs(this)
public inline val Int.absoluteValue: Int get() = nativeMath.abs(this)
public inline val Long.absoluteValue: Long get() = nativeMath.abs(this)

public inline fun Double.pow(x: Double): Double = nativeMath.pow(this, x)
public inline fun Double.pow(n: Int): Double = nativeMath.pow(this, n.toDouble())

public inline fun sqrt(x: Double): Double = nativeMath.sqrt(x)
public inline fun sqrt(x: Float): Float = nativeMath.sqrt(x.toDouble()).toFloat()


// BigInteger/BigDecimal
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