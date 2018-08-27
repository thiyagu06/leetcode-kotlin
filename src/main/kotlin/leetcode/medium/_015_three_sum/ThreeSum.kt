package leetcode.medium._015_three_sum

import extensions.arrays.frequencyMap
import extensions.arrays.valueToIndicesMap
import extensions.lists.frequencyMap
import extensions.lists.toTriple

/**
 * 15 - https://leetcode.com/problems/3sum/description/
 */
class Solution {

    /**
     * Time: O(n^2) ?
     * Space: O(n) ?
     */
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result: MutableList<List<Int>> = arrayListOf()
        val sortedTriples: MutableList<Triple<Int, Int, Int>> = arrayListOf()

        val valueToIndicesMap = nums.valueToIndicesMap()
        val frequencies = nums.frequencyMap()

        outer@ for (i in 0..nums.lastIndex - 2) {
            for (j in i + 1 until nums.lastIndex) {
                if (nums[i] > 0) {
                    break@outer
                }

                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue@outer
                }

                val complement = (nums[i] + nums[j]) * -1
                if (valueToIndicesMap.containsKey(complement)) {
                    val possibleSolution = listOf(nums[i], nums[j], complement)

                    // make sure it isn't using values more than the frequency of the value in nums
                    val noOveruses = possibleSolution.frequencyMap().all { (n, freq) -> freq <= frequencies[n] ?: 0 }

                    val sortedTriple = possibleSolution.sorted().toTriple()
                    val isUniqueSolution = !sortedTriples.contains(sortedTriple)

                    if (noOveruses && isUniqueSolution) {
                        sortedTriples.add(sortedTriple)
                        result.add(possibleSolution)
                    }
                }
            }
        }

        return result
    }
}