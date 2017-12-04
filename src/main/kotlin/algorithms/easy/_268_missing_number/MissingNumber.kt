package algorithms.easy._268_missing_number

/**
 * 268 - https://leetcode.com/problems/missing-number/description/
 */
class Solution {

    /**
     * Solution 1 - sort the array, then check
     * Time: O(n log n)
     * Space: O(1)
     */
    fun missingNumber(nums: IntArray): Int {
        nums.sort()
        nums.withIndex().forEach { (i, n) ->
            if (n != i)
                return i
        }

        return nums.size
    }
}

class Solution2 {
    /**
     * Solution 2 - hash the values (use HashSet instead of a map - the values aren't needed)
     * Time: O(n)
     * Space: O(n)
     */
    fun missingNumber(nums: IntArray): Int {
        val values = nums.fold(hashSetOf<Int>()) { acc, num ->
            acc += num
            acc
        }

        (0..nums.size).forEach {
            if (!values.contains(it))
                return it
        }

        return nums.size
    }
}