package algorithms.easy._204_count_primes

/**
 * 204 - https://leetcode.com/problems/count-primes/description/
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * @author nrojiani
 * @date 11/12/17
 */
class Solution {

    fun countPrimes(n: Int): Int {
        var nums = BooleanArray(n)  // 0 until n
        (0 until n).forEach { i ->
            nums[i] = i.isPrime()
        }

        return nums.count { it }
    }

    private fun Int.isPrime(): Boolean =
            when {
                this < 2 -> false
                this > 2 && isEven() -> false
                else -> (2..Math.sqrt(toDouble()).toInt()).all { this % it != 0 }
            }

    private fun Int.isEven() = this % 2 == 0
}