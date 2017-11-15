package algorithms.easy._070_climbing_stairs

/**
 * 70 - https://leetcode.com/problems/climbing-stairs/description/
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 *
 * @author nrojiani
 * @date 11/12/17
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun climbStairsMemoized(n: Int): Int {
        val waysToClimb = mutableMapOf(
                0 to 0,
                1 to 1,
                2 to 2
        )

        (3..n).forEach { x ->
            waysToClimb[x] = waysToClimb[x - 1]!! + waysToClimb[x - 2]!!
        }

        return waysToClimb[n]!!
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun climbStairs(n: Int): Int {
        if (n in (0..2))
            return n
        var waysToClimbTwoLess = 1
        var waysToClimbOneLess = 2
        var waysToClimbX = 3

        (3..n).forEach {
            waysToClimbX = waysToClimbOneLess + waysToClimbTwoLess
            waysToClimbTwoLess = waysToClimbOneLess
            waysToClimbOneLess = waysToClimbX
        }

        return waysToClimbX
    }
}