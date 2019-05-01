package leetcode.easy._167_two_sum_ii

import extensions.arrays.valueToIndicesMap

class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val indicesMap: Map<Int, List<Int>> = numbers.valueToIndicesMap()

        numbers.forEachIndexed { i, num ->
            val complement = target - num
            if (indicesMap.containsKey(complement)) {
                val complementIndices = indicesMap.getValue(complement)
                val complementIndex = complementIndices.firstOrNull { it > i }
                if (complementIndex != null) {
                    return intArrayOf(i + 1, complementIndex + 1)
                }
            }
        }

        return intArrayOf(-1, -1)
    }
}