package algorithms.easy._198_house_robber

/**
 * 198 - https://leetcode.com/problems/house-robber/description/
 */
class Solution {

    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun rob(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        val maxValues = IntArray(nums.size + 1)
        val houses = intArrayOf(0) + nums

        maxValues[0] = 0
        maxValues[1] = houses[1]
        for (i in 2..houses.lastIndex) {
            maxValues[i] = maxOf( maxValues[i - 1], houses[i] + maxValues[i - 2] )
        }

        return maxValues.last()
    }
}
