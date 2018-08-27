package leetcode.easy._628_maximum_product_of_three_numbers

import extensions.tuples.product

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

        return maxOf(
                nums[nums.lastIndex] * nums[nums.lastIndex - 1] * nums[nums.lastIndex - 2],
                nums.first() * nums[1] * nums.last()
        )
    }
}

class Solution2 {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun maximumProduct(nums: IntArray): Int {
        var mins: Pair<Int, Int> = (Int.MAX_VALUE to Int.MAX_VALUE)
        var maxes: Triple<Int, Int, Int> = Triple(Int.MIN_VALUE, Int.MIN_VALUE, Int.MIN_VALUE)

        nums.forEach { n ->
            mins = when {
                n <= mins.first  -> Pair(n, mins.first)
                n <= mins.second -> Pair(mins.first, n)
                else -> mins
            }

            maxes = when {
                n >= maxes.first  -> Triple(n, maxes.first, maxes.second)
                n >= maxes.second -> Triple(maxes.first, n, maxes.second)
                n >= maxes.third  -> Triple(maxes.first, maxes.second, n)
                else -> maxes
            }
        }

        return maxOf(maxes.product(), mins.product() * maxes.first)
    }
}

