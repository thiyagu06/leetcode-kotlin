package leetcode.easy._645_set_mismatch

import extensions.arrays.groupingBy
import kotlin.math.abs

/**
 * 645 - https://leetcode.com/problems/set-mismatch/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun findErrorNums(nums: IntArray): IntArray {
        var duplicate: Int = -1
        var missing: Int = -1
        val frequencies = nums.groupingBy { it }.eachCount()
        (1..nums.size).forEach { n ->
            when (frequencies[n] ?: 0) {
                0 -> missing = n
                2 -> duplicate = n
            }
        }

        return intArrayOf(duplicate, missing)
    }
}

class OptimalSolution {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun findErrorNums(nums: IntArray): IntArray {
        val mapValueToIndex: (Int) -> Int = { n -> abs(n) - 1 }
        val unmapIndexToValue: (Int) -> Int = { n -> n + 1 }

        var duplicate: Int = -1
        var missing: Int = -1

        nums.forEach { n ->
            val mappedIndex = mapValueToIndex(n)
            nums[mappedIndex] = nums[mappedIndex] * -1
            if (nums[mappedIndex] > 0) {
                duplicate = abs(n)
            }

        }

        nums.forEachIndexed { i, n ->
            if (n > 0 && unmapIndexToValue(i) != duplicate) {
                missing = unmapIndexToValue(i)
                return intArrayOf(duplicate, missing)
            }
        }

        return intArrayOf(duplicate, missing)
    }
}

