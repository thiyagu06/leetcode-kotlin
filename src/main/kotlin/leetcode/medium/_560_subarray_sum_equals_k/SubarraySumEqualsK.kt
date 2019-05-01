package leetcode.medium._560_subarray_sum_equals_k

/**
 * 560 - https://leetcode.com/problems/subarray-sum-equals-k
 */
class Solution {
    /**
     * [Solution](http://tinyurl.com/y7wkth4e)
     * Time: O(n)
     * Space: O(n)
     */
    fun subarraySum(nums: IntArray, k: Int): Int {
        var count = 0
        var sum = 0
        val prefixSums: MutableMap<Int, List<Int>> = HashMap()

        nums.forEachIndexed { i, num ->
            sum += num
            if (sum == k) {
                count++         // nums[0..i] = k
            } else {
                if ((sum - k) in prefixSums) {
                    // for each index j in prefixSums[sum - k], (j + 1)..i is a solution.
                    // because SUM[i, j] = SUM[0, j] - SUM[0, i - 1]
                    count += prefixSums[sum - k]!!.size
                }
            }
            prefixSums[sum] = (prefixSums[sum] ?: emptyList()) + i
        }
        return count
    }
}

class SolutionTwo {
    /**
     * [Solution](http://tinyurl.com/y7wkth4e)
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