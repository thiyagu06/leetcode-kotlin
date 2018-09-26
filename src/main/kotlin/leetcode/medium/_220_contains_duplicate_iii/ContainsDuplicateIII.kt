package leetcode.medium._220_contains_duplicate_iii

import kotlin.math.abs

/**
 * 220 - https://leetcode.com/problems/contains-duplicate-iii
 */
class Solution {
    /**
     * Time: O(n^2)
     * Space: O(n)
     */
    fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
        // We need to maintain original index, since we will sort the array
        val indexedNums = nums.mapIndexed { i, n -> IndexedValue(i, n) }.sortedBy { (_, n) -> n }

        // Get pairs of (i, nums[i]), (j, nums[j]) where |nums[i] - nums[j]| <= t
        val nearbyPairs: MutableList<Pair<IndexedValue<Int>, IndexedValue<Int>>> = arrayListOf()
        (0 until indexedNums.size).forEach { i ->
            var j = i + 1
            while (j < indexedNums.size && absDiff(indexedNums[i].value, indexedNums[j].value) <= t.toLong()) {
                nearbyPairs += Pair(indexedNums[i], indexedNums[j])
                j++
            }
        }

        return nearbyPairs.any { pair ->
            val (i, _) = pair.first
            val (j, _) = pair.second
            abs(i - j) <= k
        }
    }

    // Accounts for Int overflow.
    private fun absDiff(x: Int, y: Int): Long = abs(x.toLong() - y.toLong())
}