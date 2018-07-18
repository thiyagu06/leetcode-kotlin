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

    private fun IntArray.rotated(k: Int): List<Int> = (takeLast(k % size) + dropLast(k % size))
}

class OptimalSolution1 {
    /**
     * Time: O(n)
     * Space: O(1)
     *
     * Using Reversals
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

class OptimalSolution2 {
    /**
     * Time: O(n)
     * Space: O(1)
     *
     * Using cyclical replacements
     */
    fun rotate(nums: IntArray, k: Int) {
        if (nums.isEmpty()) return

        val n = nums.size
        val shift = k % n
        var replacements = 0
        var startIndex = 0

        while (replacements < n) {
            var currentIndex = startIndex
            var prev = nums[startIndex]

            do {
                val nextIndex = (currentIndex + shift) % n
                val temp = nums[nextIndex]

                nums[nextIndex] = prev
                prev = temp
                currentIndex = nextIndex

                replacements++

            } while (currentIndex != startIndex)

            startIndex++ // Go to next index if looped back to previous position
        }
    }
}