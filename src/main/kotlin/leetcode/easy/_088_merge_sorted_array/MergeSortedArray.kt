package leetcode.easy._088_merge_sorted_array

/**
 * 88 - https://leetcode.com/problems/merge-sorted-array/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        val aux1 = IntArray(m)
        for (i in 0 until m) {
            aux1[i] = nums1[i]
        }

        var idx1 = 0
        var idx2 = 0
        var mIdx = 0

        while (idx1 < m && idx2 < n) {
            if (aux1[idx1] <= nums2[idx2]) {
                nums1[mIdx++] = aux1[idx1++]
            } else {
                nums1[mIdx++] = nums2[idx2++]
            }
        }

        while (idx1 < m) {
            nums1[mIdx++] = aux1[idx1++]
        }

        while (idx2 < n) {
            nums1[mIdx++] = nums2[idx2++]
        }

    }
}
