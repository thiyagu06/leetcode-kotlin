package leetcode.easy._219_contains_duplicate_ii

import kotlin.math.abs

/**
 * 219 - https://leetcode.com/problems/contains-duplicate-ii/
 */
class Solution {
    /**
     * Time: O(n^2)
     * Space: O(n)
     */
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val duplicateIndicesLists = nums.withIndex().groupBy(
            keySelector = { it.value }, valueTransform = { it.index }
        ).values

        for (indexList in duplicateIndicesLists) {
            for (i in (1 until indexList.size)) {
                if (abs(indexList[i] - indexList[i - 1]) <= k) {
                    return true
                }
            }
        }

        return false
    }
}

class SolutionTwo {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val valueToIndices = hashMapOf<Int, List<Int>>()

        nums.forEachIndexed { i, n ->
            if (valueToIndices[n] != null && abs(i - valueToIndices[n]!!.last()) <= k) {
                return true
            }

            valueToIndices[n] = arrayListOf(i)
        }

        return false
    }
}