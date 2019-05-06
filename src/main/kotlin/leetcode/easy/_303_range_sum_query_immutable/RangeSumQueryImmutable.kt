package leetcode.easy._303_range_sum_query_immutable

/**
 * 303 - https://leetcode.com/problems/range-sum-query-immutable/
 */
class NumArray(nums: IntArray) {

    private val _nums = nums

    // No caching (accepted)
    fun sumRange(i: Int, j: Int): Int = (i..j).fold(0) { acc, index -> acc + _nums[index] }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(i,j)
 */

/**
 * Add to cache the first time computed.
 * If [i, j] or [i, j) is cached, use cached values,
 * otherwise compute the range.
 *
 * Time: O(?)
 * Space: O(?)
 */
class NumArray2(nums: IntArray) {

    private val cache: MutableMap<IntRange, Int> = mutableMapOf()
    private val _nums: IntArray = nums

    fun sumRange(i: Int, j: Int): Int {
        return if (i..j in cache) {
            cache.getValue(i..j)
        } else if (j >= 1 && (i until j) in cache) {
            cache.getValue(i until j) + _nums[j]
        } else {
            sumIndexRange(i..j)
        }
    }

    private fun sumIndexRange(indexRange: IntRange): Int =
        indexRange.fold(0) { sum, index ->
            sum + _nums[index]
        }
}

/**
 * This exceeds time limit in Kotlin despite being an accepted solution:
 * https://leetcode.com/problems/range-sum-query-immutable/solution/
 */
class NumArray3(nums: IntArray) {

    private val cache: MutableMap<IntRange, Int> = mutableMapOf()

    init {
        for (i in nums.indices) {
            var sum = 0
            for (j in (i..nums.lastIndex)) {
                sum += nums[j]
                cache[i..j] = sum
            }
        }
    }

    fun sumRange(i: Int, j: Int): Int = cache.getValue(i..j)
}
