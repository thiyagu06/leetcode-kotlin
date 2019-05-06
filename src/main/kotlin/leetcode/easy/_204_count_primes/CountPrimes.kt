package leetcode.easy._204_count_primes

import extensions.math.isEven
import extensions.math.isOdd
import kotlin.math.sqrt

/**
 * 204 - https://leetcode.com/problems/count-primes/
 */
class Solution {
    fun countPrimes(n: Int): Int = when {
        n <= 2 -> 0
        else -> {
            val isPrime: (Int) -> Boolean = { x ->
                x >= 2 &&
                        (x == 2 || x.isOdd) &&
                        (2..sqrt(x.toDouble()).toInt()).all { divisor -> x % divisor != 0 }
            }

            (2 until n).count {
                isPrime(it)
            }
        }
    }
}

class SolutionTwo {
    /**
     * Time: O(?)
     * Space: O(?)
     */
    fun countPrimes(n: Int): Int = (2 until n).count { it.isPrime() }

    private fun Int.isPrime(): Boolean = when {
        this < 2 -> false
        this == 2 -> true
        isEven -> false
        else -> (2..sqrt(toDouble()).toInt()).all { this % it != 0 }
    }
}

/* TODO: faster solution: Use sieve of Erathosthenes */
