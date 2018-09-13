package leetcode.easy._628_maximum_product_of_three_numbers

/**
 * 628 - https://leetcode.com/problems/maximum-product-of-three-numbers/description/
 */
class Solution {
    /**
     * Time: O(n log n)
     * Space: O(log n)
     */
    fun maximumProduct(nums: IntArray): Int {
        nums.sort()
        val n = nums.size
        return maxOf(
            nums[0] * nums[1] * nums[n - 1],            // 2 smallest values & largest value
            nums[n - 3] * nums[n - 2] * nums[n - 1]     // 3 largest values
        )
    }
}

class SolutionTwo {
    fun maximumProduct(nums: IntArray): Int {
        var max = Int.MIN_VALUE
        var secondMax = Int.MIN_VALUE
        var thirdMax = Int.MIN_VALUE
        var min = Int.MAX_VALUE
        var secondMin = Int.MAX_VALUE

        nums.forEach { n ->

            when {
                n >= max -> {
                    thirdMax = secondMax
                    secondMax = max
                    max = n
                }
                n >= secondMax -> {
                    thirdMax = secondMax
                    secondMax = n
                }
                n > thirdMax -> thirdMax = n
            }

            // Can't include these in the previous when: cases not mutually exclusive.
            when {
                n <= min -> {
                    secondMin = min
                    min = n
                }
                n < secondMin -> secondMin = n
            }
        }

        return maxOf(max * secondMax * thirdMax, min * secondMin * max)
    }
}
