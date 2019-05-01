package leetcode.medium._016_three_sum_closest

import kotlin.math.abs

/**
 * 16 - https://leetcode.com/problems/3sum-closest
 */
class Solution {
    /**
     * Accepted, but not optimal
     *
     * Time: O(n^3)
     * Space: O(n)
     *
     * Runtime: 528 ms
     */
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        val completedPairs = hashSetOf<Pair<Int, Int>>()
        var closestSum = nums[0] + nums[1] + nums[2]    // can assume each input has a solution

        for (i in 0..(nums.lastIndex - 2)) {
            for (j in (i + 1) until nums.lastIndex) {
                if ((nums[i] to nums[j]) in completedPairs) {
                    continue
                }

                for (k in (j + 1)..nums.lastIndex) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue
                    }

                    val tripletSum = nums[i] + nums[j] + nums[k]
                    val distance = abs(tripletSum - target)
                    if (distance < abs(closestSum - target)) {
                        closestSum = tripletSum
                    }
                }
            }
        }

        return closestSum
    }
}

class SolutionTwo {
    /**
     * Time: O(n^2)
     * Space: O(1)
     *
     * Runtime: 236 ms
     */
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var closestSum = nums[0] + nums[1] + nums[2]    // can assume each input has a solution

        for (i in 0..(nums.lastIndex - 2)) {
            var j = i + 1           // left pointer starts after i
            var k = nums.lastIndex  // right pointer starts at end
            while (j < k) {
                val sum = nums[i] + nums[j] + nums[k]

                when {
                    sum == target -> return sum
                    sum < target -> j++
                    sum > target -> k--
                }

                if (abs(sum - target) < abs(closestSum - target))
                    closestSum = sum
            }
        }

        return closestSum
    }
}