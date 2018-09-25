package leetcode.easy._217_contains_duplicate

import extensions.arrays.groupingBy

/**
 * 217 - https://leetcode.com/problems/contains-duplicate/description/
 */
class Solution {
    /**
     * Declarative
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun containsDuplicate(nums: IntArray): Boolean = nums.groupingBy { it }
        .eachCount()
        .any { (_, count) -> count > 1 }
}

class SolutionTwo {
    /**
     * Imperative
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun containsDuplicate(nums: IntArray): Boolean {
        val distinct = hashSetOf<Int>()
        for (n in nums) {
            if (distinct.contains(n)) {
                return true
            }
            distinct.add(n)
        }
        return false
    }
}

class SolutionThree {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun containsDuplicate(nums: IntArray): Boolean = nums.distinct().size != nums.size
}
