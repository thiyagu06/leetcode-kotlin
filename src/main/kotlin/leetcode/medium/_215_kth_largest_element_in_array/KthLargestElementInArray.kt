package leetcode.medium._215_kth_largest_element_in_array

import java.util.PriorityQueue

class Solution {
    /**
     * Time: O(n log n) - sorting
     * Space: O(log n) - stack space used to sort
     */
    fun findKthLargest(nums: IntArray, k: Int): Int {
        nums.sort()
        return nums[nums.size - k]
    }
}

class SolutionTwo {
    /**
     * Time: O(n) - Heap insert/dequeue is O(log n), so the linear passes dominate here.
     * Space: O(n)
     */
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val maxHeap = PriorityQueue<Int>(reverseOrder())
        nums.forEach { n ->
            maxHeap.add(n)
        }

        (1 until k).forEach { _ ->
            maxHeap.poll()
        }

        return maxHeap.peek()
    }
}

class SolutionThree {
    /**
     * Time: O(n + k*log(n)) = O(n)
     * Space: O(k) - worst case k = n, and O(n), but for small k it uses considerably
     *               less space than SolutionTwo
     */
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val minHeap = PriorityQueue<Int>()
        nums.forEach { n ->
            minHeap.add(n)

            /* Maintain the k largest elements, so that after the loop,
               there will be k elements remaining. Peek will take the smallest
               of these (the kth largest) */
            if (minHeap.size > k)
                minHeap.poll()
        }
        return minHeap.peek()
    }
}