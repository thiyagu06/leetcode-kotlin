package leetcode.easy._581_shorted_unsorted_continuous_subarray

import kotlin.math.max
import kotlin.math.min

/**
 * 581 - https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 */
class Solution {
    /**
     * [Approach 3](https://leetcode.com/problems/shortest-unsorted-continuous-subarray/solution/)
     * Time: O(n log n)
     * Space: O(n)
     */
    fun findUnsortedSubarray(nums: IntArray): Int {
        val sortedNums = nums.sorted()
        var start = sortedNums.size
        var end = 0

        for (i in sortedNums.indices) {
            if (nums[i] != sortedNums[i]) {
                start = min(start, i)
                end = max(end, i)
            }
        }

        return (end - start + 1).coerceAtLeast(0)
    }
}