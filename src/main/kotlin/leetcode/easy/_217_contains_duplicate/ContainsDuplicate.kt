package leetcode.easy._217_contains_duplicate

import extensions.arrays.groupingBy

/**
 * 217 - https://leetcode.com/problems/contains-duplicate/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun containsDuplicate(nums: IntArray): Boolean =
        nums.groupingBy { it }
            .eachCount()
            .values
            .any { it > 1 }
}

class SolutionTwo {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun containsDuplicate(nums: IntArray): Boolean =
        nums.groupingBy { it }
            .fold(0) { freq, _ -> freq + 1 }
            .values
            .any { it > 1 }
}

class SolutionThree {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun containsDuplicate(nums: IntArray): Boolean = nums.distinct().size != nums.size
}


class ImperativeSolution {
    /**
     * Imperative solution
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun containsDuplicate(nums: IntArray): Boolean {
        val distinctNums = mutableSetOf<Int>()
        nums.forEach { num ->
            if (distinctNums.contains(num)) {
                return true
            }
            distinctNums.add(num)
        }
        return false
    }
}