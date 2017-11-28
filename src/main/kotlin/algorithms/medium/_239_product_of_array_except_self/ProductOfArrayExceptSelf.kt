package algorithms.medium._239_product_of_array_except_self

/**
 * 238 - https://leetcode.com/problems/product-of-array-except-self/description/
 *
 * @author nrojiani
 * @date 11/19/17
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun productExceptSelf(nums: IntArray): IntArray {
        if (nums.isEmpty())
            return intArrayOf()

        val (productsLtoR, productsRtoL) = cumulativeProductArrays(nums)

        val output = IntArray(nums.size)
        nums.forEachIndexed { i, _ ->
            output[i] = when (i) {
                0 -> productsRtoL[1]
                nums.lastIndex -> productsLtoR[i - 1]
                else -> productsLtoR[i - 1] * productsRtoL[i + 1]
            }
        }
        return output
    }

    private fun cumulativeProductArrays(nums: IntArray): Pair<IntArray, IntArray> {
        val productsLtoR = nums.fold(intArrayOf()) { acc, num ->
            acc + ((acc.lastOrNull() ?: 1) * num)
        }

        val productsRtoL = nums.foldRight(intArrayOf()) { num, acc ->
            acc + ((acc.lastOrNull() ?: 1) * num)
        }
        productsRtoL.reverse()

        return Pair(productsLtoR, productsRtoL)
    }
}

/**
 * Follow up:
 * Could you solve it with constant space complexity?
 * (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */
class FollowUpSolution {
    fun productExceptSelf(nums: IntArray): IntArray = TODO()

}