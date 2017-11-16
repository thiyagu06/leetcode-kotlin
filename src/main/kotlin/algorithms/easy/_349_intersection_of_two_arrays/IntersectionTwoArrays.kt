package algorithms.easy._349_intersection_of_two_arrays

/**
 * 349 - https://leetcode.com/problems/intersection-of-two-arrays/description/
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 *
 * @author nrojiani
 * @date 11/15/17
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray =
        nums1.toSet().intersect(nums2.toSet()).toIntArray()
}

