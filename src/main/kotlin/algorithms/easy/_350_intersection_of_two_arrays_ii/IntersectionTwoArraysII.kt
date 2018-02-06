package algorithms.easy._350_intersection_of_two_arrays_ii

import extensions.arrays.groupingBy
import extensions.java.repeated

/**
 * 350 - https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 */
class Solution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val freqs1 = nums1.groupingBy { it }.eachCount()
        val freqs2 = nums2.groupingBy { it }.eachCount()

        return freqs1.entries.fold(intArrayOf()) { acc, (num, _) ->
            freqs2[num]?.let {
                val copies = minOf(freqs1[num] ?: 0, freqs2[num] ?: 0)
                acc + num.repeated(copies)
            } ?: acc
        }
    }
}

/*
 * Follow up: TODO
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
