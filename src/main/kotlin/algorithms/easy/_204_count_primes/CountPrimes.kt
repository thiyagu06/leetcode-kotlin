package algorithms.easy._204_count_primes

import extensions.math.isEven
import kotlin.math.sqrt

/**
 * 204 - https://leetcode.com/problems/count-primes/description/
 */
class Solution {
    /**
     * Time: O(?)
     * Space: O(?)
     */
    fun countPrimes(n: Int): Int {
        val nums = BooleanArray(n)  // 0 until n
        (0 until n).forEach { i ->
            nums[i] = i.isPrime()
        }

        return nums.count { it }
    }

    private fun Int.isPrime(): Boolean =
            when {
                this < 2 -> false
                this > 2 && isEven -> false
                else -> (2..sqrt(toDouble()).toInt()).all { this % it != 0 }
            }
}

/* TODO: faster solution: Use sieve of Erathosthenes */
