package algorithms.easy._217_contains_duplicate

/**
 * 217 - https://leetcode.com/problems/contains-duplicate/description/
 *
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 *
 * @author nrojiani
 * @date 11/13/17
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun containsDuplicate(nums: IntArray): Boolean {
        val distinct = mutableSetOf<Int>()
        for (x in nums) {
            if (distinct.contains(x)) {
                return true
            }
            distinct.add(x)
        }
        return false
    }

}

class SolutionTwo {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun containsDuplicate(nums: IntArray): Boolean = nums.withIndex()
            .groupBy({ it.value }, { it.index })
            .filter { (_, occurrences) -> occurrences.size >= 2 }
            .isNotEmpty()
}

