package algorithms.medium._718_max_length_repeated_subarray

import extensions.arrays.sublists

/**
 * 718 - https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
 */
class Solution {

    /**
     * TODO: Time limit exceeded
     * use adjusted LCS algorithm --> https://leetcode.com/problems/maximum-length-of-repeated-subarray/solution/
     */
    fun findLength(A: IntArray, B: IntArray): Int =
        (A.distinctSubarrays() intersect B.distinctSubarrays())
            .maxBy { it.size }?.size ?: 0

    private fun IntArray.distinctSubarrays(): Set<List<Int>> = sublists().distinct().toSet()
}
