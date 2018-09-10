package leetcode.easy._035_search_insert_position

import extensions.ranges.isNotEmpty

/**
 * 35 - https://leetcode.com/problems/search-insert-position/description/
 */
class SimpleSolution {
    /**
     * Using linear search
     *
     * Time: O(n)
     * Space: O(1)
     */
    fun searchInsert(nums: IntArray, target: Int): Int {
        nums.forEachIndexed { index, num ->
            if (num >= target)
                return index
        }
        return nums.lastIndex + 1
    }
}

class OptimalSolution {
    /**
     * Using Binary Search
     * Time: O(log n)
     * Space: O(1)
     */
    fun searchInsert(nums: IntArray, target: Int): Int {
        var range = 0..nums.lastIndex

        while (range.isNotEmpty()) {
            val mid = (range.start + range.endInclusive) / 2

            range = when {
                target < nums[mid] -> (range.start..(mid - 1))
                target > nums[mid] -> ((mid + 1)..nums.lastIndex)
                else -> return mid
            }
        }

        return range.start
    }
}
