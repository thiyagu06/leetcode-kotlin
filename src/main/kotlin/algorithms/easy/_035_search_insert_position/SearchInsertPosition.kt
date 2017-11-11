package algorithms.easy._035_search_insert_position

/**
 * 35 - https://leetcode.com/problems/search-insert-position/description/
 *
 * @author nrojiani
 * @date 11/10/17
 */
class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        nums.forEachIndexed { i, n ->
            if (target <= n) {
                return i
            }
        }
        return nums.size
    }
}