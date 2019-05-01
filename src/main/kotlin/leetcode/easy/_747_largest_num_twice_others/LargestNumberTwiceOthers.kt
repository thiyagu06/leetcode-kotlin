package leetcode.easy._747_largest_num_twice_others

import extensions.arrays.NOT_FOUND

/**
 * 747 - https://leetcode.com/problems/largest-number-greater-than-twice-of-others/
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

        val sorted = nums.withIndex().sortedByDescending { (index, value) -> value }
        val greatest = sorted[0]
        val secondGreatest = sorted[1]

        return if (greatest.value >= (secondGreatest.value * 2)) greatest.index else -1
    }
}

class SolutionTwo {
    /**
     * One-pass, constant space
     *
     * Time: O(n)
     * Space: O(1)
     */
    fun dominantIndex(nums: IntArray): Int {
        if (nums.size == 1) return 0

        var maxIndex = -1
        var max = Int.MIN_VALUE
        var secondMax = Int.MIN_VALUE

        nums.forEachIndexed { i, n ->
            when {
                n > max -> {
                    secondMax = max
                    max = n
                    maxIndex = i
                }
                else -> if (n > secondMax) secondMax = n
            }
        }

        return if (max >= 2 * secondMax) maxIndex else NOT_FOUND
    }
}

class SolutionThree {
    /**
     * Same as SolutionTwo, but uses `Pair<IndexedValue<Int>>`
     *
     * Time: O(n)
     * Space: O(1)
     */
    fun dominantIndex(nums: IntArray): Int {
        if (nums.size == 1) return 0

        var topTwo = (IndexedValue(-1, Int.MIN_VALUE) to IndexedValue(-1, Int.MIN_VALUE))
        nums.forEachIndexed { i, n ->
            topTwo = when {
                n > topTwo.first.value -> IndexedValue(i, n) to topTwo.first
                n > topTwo.second.value -> Pair(topTwo.first, IndexedValue(i, n))
                else -> return@forEachIndexed
            }
        }

        return if (topTwo.first.value >= 2 * topTwo.second.value) topTwo.first.index else -1
    }
}
