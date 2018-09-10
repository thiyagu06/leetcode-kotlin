package leetcode.easy._001_two_sum

import extensions.arrays.valueToIndicesMap

/**
 * 1 - https://leetcode.com/problems/two-sum/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     *
     * Uses a map of Value => List of Indices
     */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numToIndicesMap = nums.valueToIndicesMap()

        nums.forEachIndexed { index, n ->
            val complement = target - n
            val complementIndices = numToIndicesMap[complement]
            complementIndices ?: return@forEachIndexed

            if (complement != n && complementIndices.isNotEmpty()) {
                return intArrayOf(index, complementIndices.first())
            } else if (complement == n && complementIndices.size >= 2) {
                // must be distinct number
                return intArrayOf(index, complementIndices[1])
            }
        }

        throw IllegalArgumentException("no 2 values sum to the target ($target)")
    }
}


class AltSolution {
    /**
     * Time: O(n)
     * Space: O(n)
     *
     * Uses a map of Value => last index of Value
     */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = nums.withIndex().associateBy({ it.value }, { it.index })

        nums.forEachIndexed { index, n ->
            val complement = target - n

            if (map.containsKey(complement) && map[complement] != index) {
                return intArrayOf(index, map[complement]!!)
            }
        }

        throw IllegalArgumentException("no 2 values sum to the target ($target)")
    }
}