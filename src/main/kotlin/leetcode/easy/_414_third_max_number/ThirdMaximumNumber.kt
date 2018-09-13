package leetcode.easy._414_third_max_number

/**
 * 414 - https://leetcode.com/problems/third-maximum-number/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun thirdMax(nums: IntArray): Int {
        var maxes: Triple<Int?, Int?, Int?> = Triple(null, null, null)

        nums.forEach { n ->
            maxes = place(n, maxes)
        }

        return maxes.third ?: maxes.first!!
    }

    private fun place(x: Int, maxes: Triple<Int?, Int?, Int?>): Triple<Int?, Int?, Int?> {
        val (first, second, third) = maxes

        return when {
            // must be distinct
            x == first || x == second || x == third -> maxes

            first == null  || x > first   -> Triple(x, first, second)
            second == null || x > second  -> Triple(first, x, second)
            third == null  || x > third   -> Triple(first, second, x)
            else -> maxes
        }
    }
}
