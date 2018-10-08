package leetcode.easy._198_house_robber

import kotlin.math.max

/**
 * 198 - https://leetcode.com/problems/house-robber/
 */
class Solution {

    /**
     * Adjusting indices
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun rob(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        val maxValues = IntArray(nums.size + 1)
        val houses = intArrayOf(0) + nums

        maxValues[0] = 0
        maxValues[1] = houses[1]    // nums[0]
        for (i in 2..houses.lastIndex) {
            maxValues[i] = max(maxValues[i - 1], houses[i] + maxValues[i - 2])
        }

        return maxValues.last()
    }
}

class SolutionTwo {

    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun rob(nums: IntArray): Int = when (nums.size) {
        0 -> 0
        1 -> nums[0]
        2 -> max(nums[0], nums[1])
        else -> {
            val maxes = IntArray(nums.size)     // maxes[i]: optimum for nums[0..i]
            maxes[0] = nums[0]
            maxes[1] = max(nums[0], nums[1])

            for (i in 2..nums.lastIndex) {
                maxes[i] = max(maxes[i - 2] + nums[i], maxes[i - 1])
            }

            maxes.last()
        }
    }
}

class SolutionThree {

    /**
     * Constant space
     *
     * Time: O(n)
     * Space: O(1)
     */
    fun rob(nums: IntArray): Int = when (nums.size) {
        0 -> 0
        1 -> nums[0]
        2 -> max(nums[0], nums[1])
        else -> {
            var maxTwoHousesBack = nums[0]
            var maxPrevHouse = max(nums[0], nums[1])
            var maxCurrHouse = maxPrevHouse

            for (i in 2..nums.lastIndex) {
                maxCurrHouse = max(maxTwoHousesBack + nums[i], maxPrevHouse)
                maxTwoHousesBack = maxPrevHouse
                maxPrevHouse = maxCurrHouse
            }

            maxCurrHouse
        }
    }
}