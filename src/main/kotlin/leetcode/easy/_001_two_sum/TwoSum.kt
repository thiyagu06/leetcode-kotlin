package leetcode.easy._001_two_sum

/**
 * 1 - https://leetcode.com/problems/two-sum/
 */
class Solution {
    /**
     * Using HashMap
     * Time: O(n)
     * Space: O(n)
     */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val valueToIndicesMap = nums.withIndex()
            .groupBy(keySelector = { it.value }, valueTransform = { it.index })

        nums.forEachIndexed { i, value ->
            val complement = target - value
            if (complement in valueToIndicesMap) {
                val complementIndices = valueToIndicesMap[complement]!!
                val uniqueComplementIndex = complementIndices.firstOrNull { it != i }
                if (uniqueComplementIndex != null) {
                    return intArrayOf(i, uniqueComplementIndex)
                }
            }
        }

        throw IllegalArgumentException("No pair of numbers in input sum to target")
    }
}

class SolutionTwo {
    /**
     * Time: O(n)
     * Space: O(n)
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