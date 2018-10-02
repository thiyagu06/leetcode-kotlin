package leetcode.medium._560_subarray_sum_equals_k

/**
 * 560 - https://leetcode.com/problems/subarray-sum-equals-k
 */
class Solution {
    /**
     * https://leetcode.com/problems/subarray-sum-equals-k/discuss/102106/java-solution-presum-hashmap
     * Time: O(n)
     * Space: O(n)
     */
    fun subarraySum(nums: IntArray, k: Int): Int {
        if (nums.isEmpty()) return 0

        var sum = 0
        var count = 0   // # of subarrays that sum to k
        val prefixSumFreqs: MutableMap<Int, Int> = hashMapOf()   // Subarray Sum => # of Subarrays with that sum
        prefixSumFreqs[0] = 1

        for (i in nums.indices) {
            sum += nums[i]
            /* if map[sum - k] is defined, it means we can form sum == k using the elements after
               the element corresponding to that prefix sum until the current element.
               e.g., SUM[i, j] = SUM[0, j] - SUM[0, i - 1] */
            if (prefixSumFreqs.containsKey(sum - k)) {
                count += prefixSumFreqs[sum - k]!!
            }

            /* Special case: nums[i] == k, so the sum of subarray {nums[i]} == k */
            prefixSumFreqs[sum] = prefixSumFreqs.getOrDefault(sum, 0) + 1
        }

        return count
    }
}