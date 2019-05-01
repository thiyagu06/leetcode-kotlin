package leetcode.easy._349_intersection_of_two_arrays

/**
 * 349 - https://leetcode.com/problems/intersection-of-two-arrays/
 */
class Solution {
    /**
     * Time: O(m + n) - linear
     * Space: O(m + n)
     */
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray =
        nums1.intersect(nums2.toSet()).toIntArray()
}

class SolutionTwo {
    /**
     * Time: O(m + n) - linear
     * Space: O(m + n)
     */
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val distinct1 = HashSet<Int>()
        val intersection = HashSet<Int>()

        for (n in nums1) {
            if (!distinct1.contains(n))
                distinct1.add(n)
        }

        for (n in nums2) {
            if (distinct1.contains(n))
                intersection += n
        }

        return intersection.toIntArray()
    }
}
