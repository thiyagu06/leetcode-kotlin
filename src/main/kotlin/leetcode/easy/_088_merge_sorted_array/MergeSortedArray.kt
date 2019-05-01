package leetcode.easy._088_merge_sorted_array

/**
 * 88 - https://leetcode.com/problems/merge-sorted-array/
 */
class Solution {
    /**
     * Approach 1: Create aux. array, merge into that, then copy to nums1.
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var indexL = 0
        var indexR = 0
        var indexM = 0      // merged
        val merged = IntArray(m + n)

        while (indexL < m && indexR < n) {
            when {
                nums1[indexL] < nums2[indexR] -> merged[indexM++] = nums1[indexL++]
                nums1[indexL] > nums2[indexR] -> merged[indexM++] = nums2[indexR++]
                else -> {
                    merged[indexM++] = nums1[indexL++]
                    merged[indexM++] = nums2[indexR++]
                }
            }
        }

        while (indexL < m) merged[indexM++] = nums1[indexL++]
        while (indexR < n) merged[indexM++] = nums2[indexR++]

        // Copy to nums1
        for (i in merged.indices) {
            nums1[i] = merged[i]
        }
    }
}

class SolutionTwo {
    /**
     * Approach 2: copy nums1 in aux ('left'), then merge into nums1 (uses less space)
     * Time: O(n)
     * Space: O(n)
     */
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        val left = nums1.copyOf()

        var leftIndex = 0
        var rightIndex = 0
        var mergedIndex = 0

        while (leftIndex < m && rightIndex < n) {
            when {
                left[leftIndex] < nums2[rightIndex] -> nums1[mergedIndex++] = left[leftIndex++]
                left[leftIndex] > nums2[rightIndex] -> nums1[mergedIndex++] = nums2[rightIndex++]
                else -> {
                    nums1[mergedIndex++] = left[leftIndex++]
                    nums1[mergedIndex++] = nums2[rightIndex++]
                }
            }
        }

        while (leftIndex < m) nums1[mergedIndex++] = left[leftIndex++]
        while (rightIndex < n) nums1[mergedIndex++] = nums2[rightIndex++]
    }
}

class SolutionThree {
    /**
     * Without aux. array
     * Time: O(n)
     * Space: O(1)
     */
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var i = m - 1
        var j = n - 1
        var k = m + n - 1

        while (k >= 0) {
            nums1[k] = when {
                i < 0 ->  nums2[j--]
                j < 0 ->  nums1[i--]
                nums1[i] < nums2[j] -> nums2[j--]
                else -> nums1[i--]
            }
            k--
        }
    }
}
