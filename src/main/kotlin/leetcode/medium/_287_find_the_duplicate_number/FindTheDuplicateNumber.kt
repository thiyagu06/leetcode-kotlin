package leetcode.medium._287_find_the_duplicate_number

/**
 * 287 - https://leetcode.com/problems/find-the-duplicate-number
 *
 * **Restrictions**:
 * - You must not modify the array (assume the array is read only).
 * - You must use only constant, `O(1)` extra space.
 * - Your runtime complexity should be less than `O(n^2)`.
 * - There is only one duplicate number in the array, but it could be repeated more than once.
 */
class Solution {
    /**
     * Time: O(n log n) - accepted, although it violates the "must not modify the array" restriction (or
     * the constant space restriction if not sorted in-place).
     * Space: O(1)
     */
    fun findDuplicate(nums: IntArray): Int {
        nums.sort()
        return nums.withIndex().find { (i, num) ->
            i > 0 && nums[i] == nums[i - 1]
        }!!.value
    }
}

class SolutionTwo {
    /**
     * Time: O(n) - accepted, although it violates the constant space restriction
     * Space: O(1)
     */
    fun findDuplicate(nums: IntArray): Int {
        val seen = hashSetOf<Int>()
        for (num in nums) {
            if (num in seen) {
                return num
            }
            seen += num
        }
        throw IllegalArgumentException("No duplicates in nums: $nums")
    }
}

class SolutionThree {
    /**
     * Floyd Cycle-Detection Algorithm
     * Time: O(n)
     * Space: O(1)
     */
    fun findDuplicate(nums: IntArray): Int {
        TODO()
    }
}