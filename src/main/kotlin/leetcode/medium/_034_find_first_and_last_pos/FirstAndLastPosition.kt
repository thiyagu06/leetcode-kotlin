package leetcode.medium._034_find_first_and_last_pos

/**
 * 34 - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun searchRange(nums: IntArray, target: Int): IntArray = intArrayOf(
        nums.indexOf(target),
        nums.indexOfLast { it == target }
    )
}

class SolutionTwo {
    /**
     * Time: O(log n)
     * Space: O(1)
     */
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val result = intArrayOf(-1, -1)
        if (nums.isEmpty()) return result

        var (start, end) = (0 to nums.lastIndex)

        // Find First
        val firstIdx =
            findFirstOrLast(nums = nums, indexRange = nums.indices, target = target, position = Position.FIRST)
        firstIdx ?: return result   // nums doesn't contain the target
        result[0] = firstIdx
        start = firstIdx
        end = nums.lastIndex

        // Find Last
        result[1] = findFirstOrLast(nums = nums, indexRange = (start..end), target = target, position = Position.LAST)!!
        return result
    }

    private enum class Position { FIRST, LAST }

    private fun findFirstOrLast(
        nums: IntArray,
        indexRange: IntRange,
        target: Int,
        position: Position
    ): Int? {
        var (start, end) = indexRange.start to indexRange.endInclusive
        var result = 0

        while (start <= end) {
            val mid = (start + end) / 2
            when {
                nums[mid] == target -> {
                    result = mid
                    when (position) {
                        Position.FIRST -> end = mid - 1
                        Position.LAST -> start = mid + 1
                    }
                }
                nums[mid] > target -> end = mid - 1
                nums[mid] < target -> start = mid + 1
            }
        }
        return if (nums[result] != target) null else result
    }
}