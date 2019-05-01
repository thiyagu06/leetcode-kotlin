package leetcode.medium._347_top_k_frequent_elements

import extensions.arrays.groupingBy
import java.util.PriorityQueue

/**
 * 347 - https://leetcode.com/problems/top-k-frequent-elements/
 */
data class ElementWithFrequency(val element: Int, private val frequency: Int) : Comparable<ElementWithFrequency> {
    override fun compareTo(other: ElementWithFrequency): Int = other.frequency - this.frequency
}

class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun topKFrequent(nums: IntArray, k: Int): List<Int> {
        val frequencies = nums.groupingBy { it }.eachCount().entries.map { (num, freq) ->
            ElementWithFrequency(num, freq)
        }

        val maxHeap = PriorityQueue<ElementWithFrequency>(frequencies)
        val result = arrayListOf<Int>()
        while (result.size < k) {
            result.add(maxHeap.poll().element)
        }

        return result
    }
}