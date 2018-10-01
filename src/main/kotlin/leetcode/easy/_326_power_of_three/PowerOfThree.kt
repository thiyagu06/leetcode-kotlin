package leetcode.easy._326_power_of_three

import extensions.math.EPSILON
import kotlin.math.log
import kotlin.math.pow

/**
 * 326 - https://leetcode.com/problems/power-of-three/
 */
class Solution {
    /**
     * Time: O(log(n)): base 3 - O(log_3(n))
     * Space: O(1)
     */
    fun isPowerOfThree(n: Int): Boolean {
        return when {
            n < 1 -> false
            n == 1 -> true
            n % 3 != 0 -> false
            else -> {
                var x = n
                while (x > 1) {
                    if (x % 3 != 0) return false

                    x /= 3
                }
                true
            }
        }
    }
}

class SolutionTwo {
    /**
     * Time: O(log_3(n))
     * Space: O(1)
     */
    fun isPowerOfThree(n: Int): Boolean {
        var power = 1.0
        var exp = 0.0
        while (power < n) {
            power = 3.0.pow(exp)

            if (power > Int.MAX_VALUE) {    /* Overflow */
                return false
            }

            exp++
        }

        return power.toInt() == n
    }
}

class SolutionThree {
    /**
     * Time: O(log_3(n))
     * Space: O(1)
     */
    fun isPowerOfThree(n: Int): Boolean {
        var power: Double
        (0 until n).forEach { exp ->
            power = 3.0.pow(exp)

            when {
                power > Int.MAX_VALUE -> return false   // overflow
                power.toInt() > n -> return false
                power.toInt() == n -> return true
            }

        }

        return false
    }
}


/**
 * Follow-up: Could you do it without using any loop / recursion?
 */
class FollowUpSolution {
    /**
     * Time: O(?) - Depends on complexity of [log] function
     * Space: O(1)
     */
    fun isPowerOfThree(n: Int): Boolean = when {
        n <= 0 -> false
        else -> {
            val log3N = log3(n.toDouble())
            (log3N - log3N.toInt()) < EPSILON
        }
    }

    private fun log3(x: Double): Double = Math.log10(x) / Math.log10(3.0)
}
