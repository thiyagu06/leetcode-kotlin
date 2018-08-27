package algorithms.easy._349_intersection_of_two_arrays

/**
 * 349 - https://leetcode.com/problems/intersection-of-two-arrays/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray =
        nums1.toSet().intersect(nums2.toSet()).toIntArray()
}
