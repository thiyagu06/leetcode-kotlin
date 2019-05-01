package leetcode.medium._011_container_with_most_water

import extensions.comparables.minOf

/**
 * 11 - https://leetcode.com/problems/container-with-most-water/
 */
class Solution {
    /**
     * Brute-force solution
     * Time: O(n^2)
     * Space: O(1)
     */
    fun maxArea(height: IntArray): Int {
        var maxArea = 0
        for (i in 0 until height.lastIndex) {
            for (j in (i + 1)..height.lastIndex) {
                val currentArea = (j - i) * (minOf(height[i], height[j]))
                maxArea = maxOf(maxArea, currentArea)
            }
        }

        return maxArea
    }
}

class SolutionTwo {
    /**
     * Optimal solution
     * Time: O(n)
     * Space: O(1)
     */
    fun maxArea(height: IntArray): Int {
        var maxArea = 0
        var left = 0
        var right = height.lastIndex

        while (left < right) {
            maxArea = maxOf(maxArea, (right - left) * minOf(height[left], height[right]))

            /* move pointer to shorter line toward other pointer */
            if (height[left] <= height[right]) {
                left++
            } else {
                right--
            }
        }

        return maxArea
    }
}