package leetcode.easy._747_largest_num_greater_than_twice

/**
 * 747 - https://leetcode.com/problems/largest-number-greater-than-twice-of-others/description/
 */
class Solution {
    /**
     * Using sorting
     *
     * Time: O(n log n)
     * Space: O(n) - since need to return index, not value, can't just sort in-place.
     */
    fun dominantIndex(nums: IntArray): Int {
        if (nums.size == 1) {
            return 0
        }

        val sorted = nums.withIndex().sortedBy { (i, n) -> n }
        val greatest = sorted.last()
        val secondGreatest = sorted[sorted.lastIndex - 1]

        return if (greatest.value >= (secondGreatest.value * 2)) greatest.index else -1
    }
}

class Solution2 {
    /**
     * One-pass, constant space
     *
     * Time: O(n)
     * Space: O(1)
     */
    fun dominantIndex(nums: IntArray): Int {
        if (nums.size == 1) return 0

        var topTwo = (IndexedValue(-1, Int.MIN_VALUE) to IndexedValue(-1, Int.MIN_VALUE))
        nums.forEachIndexed { i, n ->
            topTwo = when {
                n >= topTwo.first.value -> Pair(IndexedValue(i, n), topTwo.first)
                n >= topTwo.second.value -> Pair(topTwo.first, IndexedValue(i, n))
                else -> return@forEachIndexed
            }
        }

        return if (topTwo.first.value >= (topTwo.second.value * 2)) topTwo.first.index else -1
    }
}