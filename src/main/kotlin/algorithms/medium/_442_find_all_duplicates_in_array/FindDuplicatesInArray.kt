package algorithms.medium._442_find_all_duplicates_in_array

import extensions.frequencyMap

/**
 * 442 - https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
 */
class Solution {
    /**
     * Sort the array, then add duplicates
     *
     * Time: O(n log n)
     * Space: O(n)
     */
    fun findDuplicates(nums: IntArray): List<Int> {
        val sorted = nums.sorted()
        var duplicates = arrayListOf<Int>()
        (1..sorted.lastIndex).forEach { i ->
            if (sorted[i] == sorted[i - 1]) {
                duplicates.add(sorted[i])
            }
        }

        return duplicates
    }
}

class Solution2 {
    /**
     * Better: Hash the nums, then add duplicates
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun findDuplicates(nums: IntArray): List<Int> {
        val frequencies = nums.frequencyMap()
        return (1..nums.size).fold(mutableListOf()) { acc, n ->
            if ((frequencies[n] ?: 0) >= 2) {
                acc.add(n)
            }
            acc
        }
    }
}

class FollowUpSolution {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun findDuplicates(nums: IntArray): List<Int> =
            nums.fold(mutableListOf()) { acc, n ->
                val mappedIndex = Math.abs(n) - 1
                if (nums[mappedIndex] < 0) {
                    acc.add(mappedIndex + 1)
                }
                nums[mappedIndex] = nums[mappedIndex] * -1

                acc
            }
}