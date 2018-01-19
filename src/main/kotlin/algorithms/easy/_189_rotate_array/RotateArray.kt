package algorithms.easy._189_rotate_array

import extensions.arrays.reverseElementsInRange

/**
 * 189 - https://leetcode.com/problems/rotate-array/description/
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
