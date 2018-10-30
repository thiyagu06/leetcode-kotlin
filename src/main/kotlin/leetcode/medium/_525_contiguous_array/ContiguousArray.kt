package leetcode.medium._525_contiguous_array

import kotlin.math.max

/**
 * 525 - https://leetcode.com/problems/contiguous-array
 */
class Solution {
    /**
     * Brute-force: Time Limit Exceeded
     * Time: O(n^2)
     * Space: O(1)
     */
    fun findMaxLength(nums: IntArray): Int {
        var maxLength = 0
        var i = 0
        while (i < nums.size - maxLength) {
            var (zeroes, ones) = 0 to 0
            for (j in i..nums.lastIndex) {
                if (nums[j] == 0) zeroes++ else ones++
                if (zeroes == ones) {
                    maxLength = max(maxLength, zeroes + ones)
                }
            }
            i++
        }

        return maxLength
    }
}

class SolutionTwo {
    /**
     * Similar to [Approach 2](https://leetcode.com/problems/contiguous-array/solution/)
     * Time: O(n)
     * Space: O(n)
     */
    fun findMaxLength(nums: IntArray): Int {
        var maxLength = 0
        var balance = 0
        // Stores the furthest apart (start, end) indices for a given balance
        val intervals: MutableMap<Int, Pair<Int, Int>> = hashMapOf()
        intervals[0] = (0 to 0)

        for (j in 1..nums.size) {
            // We added intervals[0] = 0 before iterating through the array,
            // so intervals[1] corresponds to nums[0]
            if (nums[j - 1] == 0) balance-- else balance++

            if (balance !in intervals) {

                intervals[balance] = Pair(j, j)
            } else {
                intervals[balance] = Pair(intervals[balance]!!.first, j)
                maxLength = max(maxLength, j - intervals[balance]!!.first)
            }
        }

        return maxLength
    }
}

class SolutionThree {
    /**
     * [Approach 3](https://leetcode.com/problems/contiguous-array/solution/)
     * Time: O(n)
     * Space: O(n)
     */
    fun findMaxLength(nums: IntArray): Int {
        var maxLength = 0
        var balance = 0
        // Stores the longest subarray length for a given balance
        val map: MutableMap<Int, Int> = hashMapOf()
        map[0] = -1

        nums.indices.forEach { i ->
            if (nums[i] == 0) balance-- else balance++

            // Note: only the first occurrence index is added to map
            if (map.containsKey(balance)) {
                maxLength = max(maxLength, i - map[balance]!!)
            } else {
                map[balance] = i
            }
        }

        return maxLength
    }
}