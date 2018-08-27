package algorithms.easy._485_max_consecutive_ones

/**
 * 485 - https://leetcode.com/problems/max-consecutive-ones/description/
 */
class Solution {
    /**
     * TODO
     * Time: O(?)
     * Space: O(?)
     */
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var maxStreak = 0
        var remainingNums = nums.toList()

        while (remainingNums.isNotEmpty()) {
            remainingNums = remainingNums.dropWhile { it == 0 }
            val oldSize = remainingNums.size
            remainingNums = remainingNums.dropWhile { it == 1 }
            val streak = oldSize - remainingNums.size

            if (streak >= maxStreak) {
                maxStreak = streak
            }
        }

        return maxStreak
    }
}
