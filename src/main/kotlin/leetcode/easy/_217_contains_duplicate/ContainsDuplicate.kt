package leetcode.easy._217_contains_duplicate

/**
 * 217 - https://leetcode.com/problems/contains-duplicate/description/
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
