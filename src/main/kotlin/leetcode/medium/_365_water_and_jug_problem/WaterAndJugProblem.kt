package leetcode.medium._365_water_and_jug_problem

import extensions.math.gcd

/**
 * 365 - https://leetcode.com/problems/water-and-jug-problem
 */
class Solution {
    fun canMeasureWater(x: Int, y: Int, z: Int): Boolean = when {
        z == 0 -> true
        z == x -> true                              // Fill x
        z == y -> true                              // Fill y
        z == (x + y) -> true                        // Fill x, fill y
        z > (x + y) -> false
        else -> z % gcd(x, y) == 0
    }
}