package leetcode.easy._219_contains_duplicate_ii

import kotlin.math.abs

/**
 * 219 - https://leetcode.com/problems/contains-duplicate-ii/description/
 */
class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        /* Create multimap where the keys are nums[x], and values are a list of the
           indices with that value. Then filter to only duplicates */
        val valueIndices = nums.withIndex()
                .groupBy({ it.value }, { it.index })
                .filter { (_, occurrences) -> occurrences.size >= 2 }

        for (occurrences in valueIndices.values) {
            if (occurrences.size < 2)
                continue

            for (index in (0 until occurrences.lastIndex)) {
                if (abs(occurrences[index] - occurrences[index + 1]) <= k) {
                    return true
                }
            }
        }

        return false
    }
}