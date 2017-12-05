package algorithms.easy._326_power_of_three

/**
 * 326 - https://leetcode.com/problems/power-of-three/description/
 */
class Solution {
    /**
     * Time: O(log_3(n))
     * Space: O(1)
     */
    fun isPowerOfThree(n: Int): Boolean {
        var power: Double
        (0 until n).forEach { exp ->
            power = Math.pow(3.0, exp.toDouble())

            when {
                power > Int.MAX_VALUE -> return false   // overflow
                power.toInt() > n -> return false
                power.toInt() == n -> return true
            }

        }

        return false
    }
}

class SolutionAlt {
    /**
     * Time: O(log_3(n))
     * Space: O(1)
     */
    fun isPowerOfThree(n: Int): Boolean {
        var power = 1.0
        var exp = 0.0
        while (power < n) {
            power = Math.pow(3.0, exp)

            if (power > Int.MAX_VALUE) {    /* Overflow */
                return false
            }

            exp++
        }

        return power.toInt() == n
    }
}

/**
 * Follow-up: Could you do it without using any loop / recursion?
 */
class FollowUpSolution {
    /**
     * Time: O(?)
     * Space: O(?)
     */
    fun isPowerOfThree(n: Int): Boolean {
        TODO()
    }
}