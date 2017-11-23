package algorithms.easy._189_rotate_array

import extensions.reverseElementsInRange

/**
 * 189 - https://leetcode.com/problems/rotate-array/description/
 *
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Note: Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 *
 * @author nrojiani
 * @date 11/13/17
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun rotate(nums: IntArray, k: Int) {
        if (nums.isEmpty())
            return

        val rotated = nums.rotated(k)

        /* Since the return type is Unit, and Kotlin parameters are vals: copy */
        nums.forEachIndexed { i, _ ->
            nums[i] = rotated[i]
        }
    }

    private fun IntArray.rotated(k: Int): IntArray = (takeLast(k % size) + dropLast(k % size)).toIntArray()
}

class OptimalSolution {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun rotate(nums: IntArray, k: Int) {
        if (nums.isEmpty()) return

        val n = nums.size
        val rotations = k % n
        if (rotations == 0) return

        nums.reverse()
        nums.reverseElementsInRange(0 until rotations)
        nums.reverseElementsInRange(rotations until n)
    }
}