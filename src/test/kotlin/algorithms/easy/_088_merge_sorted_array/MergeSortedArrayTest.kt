package algorithms.easy._088_merge_sorted_array

import org.junit.Test

import org.junit.Assert.*

/**
 * @author nrojiani
 * @date 11/24/17
 */
class MergeSortedArrayTest {
    private val solution = Solution()

    @Test
    fun merge1() {
        val nums1 = intArrayOf(0)
        val nums2 = intArrayOf(1)
        solution.merge(nums1 = nums1, m = 0, nums2 = nums2, n = 1)
        assertArrayEquals(intArrayOf(1), nums1)
    }

    @Test
    fun merge2() {
        val nums1 = intArrayOf(1)
        val nums2 = intArrayOf()
        solution.merge(nums1 = nums1, m = 1, nums2 = nums2, n = 0)
        assertArrayEquals(intArrayOf(1), nums1)
    }

    @Test
    fun merge3() {
        val nums1 = intArrayOf(1, 3, 5, 7, 0, 0, 0, 0)
        val nums2 = intArrayOf(2, 4, 6, 8)
        solution.merge(nums1 = nums1, m = 4, nums2 = nums2, n = 4)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8), nums1)
    }


    @Test
    fun merge4() {
        val nums1 = intArrayOf(1, 3, 5, 0, 0, 0, 0)
        val nums2 = intArrayOf(2, 4, 6, 8)
        solution.merge(nums1 = nums1, m = 3, nums2 = nums2, n = 4)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5, 6, 8), nums1)
    }

    @Test
    fun merge5() {
        val nums1 = intArrayOf(1, 3, 5, 7, 0, 0, 0)
        val nums2 = intArrayOf(2, 4, 6)
        solution.merge(nums1 = nums1, m = 4, nums2 = nums2, n = 3)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5, 6, 7), nums1)
    }

}