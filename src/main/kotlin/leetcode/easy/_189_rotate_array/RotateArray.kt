package leetcode.easy._189_rotate_array

import extensions.arrays.reverseElementsInRange

/**
 * 189 - https://leetcode.com/problems/rotate-array/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun rotate(nums: IntArray, k: Int) {
        if (nums.isEmpty())
            return

        val r = k % nums.size
        val rotated = nums.takeLast(r) + nums.dropLast(r)

        /* Since the return type is Unit, and Kotlin parameters are vals: copy */
        for (i in rotated.indices) {
            nums[i] = rotated[i]
        }
    }
}

class SolutionTwo {
    /**
     * In-place: uses reversals.
     *
     * Time: O(n)
     * Space: O(1)
     */
    fun rotate(nums: IntArray, k: Int) {
        if (nums.isEmpty() || nums.size == 1 || k == 0 || k == nums.size) return

        val n = nums.size
        val r = k % n

        nums.reverse()
        nums.reverseElementsInRange(0 until r)          // reverse first r elements
        nums.reverseElementsInRange(r..nums.lastIndex)  // reverse last (n - r) elements
    }
}

class SolutionThree {
    /**
     * Time: O(n)
     * Space: O(1)
     *
     * Using cyclical replacements
     */
    fun rotate(nums: IntArray, k: Int) {
        if (nums.isEmpty() || nums.size == 1) return

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