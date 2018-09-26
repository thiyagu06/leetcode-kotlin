package leetcode.hard._239_sliding_window_maximum

import java.util.*

/**
 * 239 - https://leetcode.com/problems/sliding-window-maximum/description/
 */
class Solution {
    /**
     * Decent runtime but not linear
     *
     * Time: O(n log(k))
     * Space: O(k)
     */
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        if (nums.isEmpty()) {
            return intArrayOf()
        }

        val maxes = arrayListOf<Int>()
        val maxHeap = PriorityQueue<Int>(k, Collections.reverseOrder())

        (0..nums.size - k).forEach { i ->

            (i until i + k).forEach { j ->
                maxHeap.offer(nums[j])
            }

            maxes.add(maxHeap.poll())
            maxHeap.clear()
        }

        return maxes.toIntArray()
    }
}

class FollowUp {
    /**
     * TODO
     * Linear-time solution. See CodeRust: https://www.educative.io/collection/page/5642554087309312/5679846214598656/210002
     *
     * Time: O(n)
     * Space: O(k)
     */
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        TODO()
    }
}