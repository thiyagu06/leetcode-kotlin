package algorithms.easy._035_search_insert_position

/**
 * 35 - https://leetcode.com/problems/search-insert-position/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun searchInsert(nums: IntArray, target: Int): Int {
        nums.forEachIndexed { i, n ->
            if (target <= n) {
                return i
            }
        }
        return nums.size
    }
}
