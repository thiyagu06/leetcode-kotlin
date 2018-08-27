package leetcode.easy._027_remove_element

/**
 * 27 - https://leetcode.com/problems/remove-element/description/
 */
class Solution {

    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var i = 0
        for (j in (0..nums.lastIndex)) {
            if (nums[j] != `val`) {
                nums[i] = nums[j]
                i++
            }
        }

        return i
    }

}
