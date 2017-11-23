package algorithms.easy._027_remove_element

/**
 * 27 - https://leetcode.com/problems/remove-element/description/
 *
 * Given an array and a value, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place
 * with `O(1)` extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * @author nrojiani
 * @date 11/10/17
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