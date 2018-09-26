package leetcode.easy._303_range_sum_query_immutable

/**
 * 303 - https://leetcode.com/problems/range-sum-query-immutable/
 */
class NumArray(nums: IntArray) {

    private val _nums = nums

    fun sumRange(i: Int, j: Int): Int = (i..j).fold(0) { acc, index -> acc + _nums[index] }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(i,j)
 */

/* The caching approach actually exceeds the Time Limit in Kotlin. The uncached version doesn't...
class NumArray(nums: IntArray) {

    private val cache: MutableMap<IntRange, Int> = mutableMapOf()

    /* Cache all possible i -> j ranges */
    init {
        for (i in (0..nums.lastIndex)) {
            var sum = 0
            for (j in (i .. nums.lastIndex)) {
                sum += nums[j]
                cache[(i..j)] = sum
            }
        }
    }
    fun sumRange(i: Int, j: Int): Int = cache[(i..j)]!!
}
*/