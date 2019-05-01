package leetcode.easy._088_merge_sorted_array

import org.junit.Test

import org.junit.Assert.*

class MergeSortedArrayTest {
    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()

    @Test
    fun merge() {
        val a = intArrayOf(0)
        val b = intArrayOf(1)
        solution.merge(nums1 = a, m = 0, nums2 = b, n = 1)
        assertArrayEquals(intArrayOf(1), a)

        val c = intArrayOf(1)
        val d = intArrayOf()
        solution.merge(nums1 = c, m = 1, nums2 = d, n = 0)
        assertArrayEquals(intArrayOf(1), c)

        val e = intArrayOf(1, 3, 5, 7, 0, 0, 0, 0)
        val f = intArrayOf(2, 4, 6, 8)
        solution.merge(nums1 = e, m = 4, nums2 = f, n = 4)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8), e)

        val g = intArrayOf(1, 3, 5, 0, 0, 0, 0)
        val h = intArrayOf(2, 4, 6, 8)
        solution.merge(nums1 = g, m = 3, nums2 = h, n = 4)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5, 6, 8), g)

        val i = intArrayOf(1, 3, 5, 7, 0, 0, 0)
        val j = intArrayOf(2, 4, 6)
        solution.merge(nums1 = i, m = 4, nums2 = j, n = 3)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5, 6, 7), i)

        val k = intArrayOf(1, 1, 1, 2, 3, 5, 6, 0, 0, 0, 0, 0, 0, 0)
        val l = intArrayOf(1, 1, 2, 3, 4, 6, 7)
        solution.merge(nums1 = k, m = 7, nums2 = l, n = 7)
        assertArrayEquals(intArrayOf(1, 1, 1, 1, 1, 2, 2, 3, 3, 4, 5, 6, 6, 7), k)
    }

    @Test
    fun merge2() {
        val a = intArrayOf(0)
        val b = intArrayOf(1)
        solution2.merge(nums1 = a, m = 0, nums2 = b, n = 1)
        assertArrayEquals(intArrayOf(1), a)

        val c = intArrayOf(1)
        val d = intArrayOf()
        solution2.merge(nums1 = c, m = 1, nums2 = d, n = 0)
        assertArrayEquals(intArrayOf(1), c)

        val e = intArrayOf(1, 3, 5, 7, 0, 0, 0, 0)
        val f = intArrayOf(2, 4, 6, 8)
        solution2.merge(nums1 = e, m = 4, nums2 = f, n = 4)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8), e)

        val g = intArrayOf(1, 3, 5, 0, 0, 0, 0)
        val h = intArrayOf(2, 4, 6, 8)
        solution2.merge(nums1 = g, m = 3, nums2 = h, n = 4)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5, 6, 8), g)

        val i = intArrayOf(1, 3, 5, 7, 0, 0, 0)
        val j = intArrayOf(2, 4, 6)
        solution2.merge(nums1 = i, m = 4, nums2 = j, n = 3)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5, 6, 7), i)

        val k = intArrayOf(1, 1, 1, 2, 3, 5, 6, 0, 0, 0, 0, 0, 0, 0)
        val l = intArrayOf(1, 1, 2, 3, 4, 6, 7)
        solution2.merge(nums1 = k, m = 7, nums2 = l, n = 7)
        assertArrayEquals(intArrayOf(1, 1, 1, 1, 1, 2, 2, 3, 3, 4, 5, 6, 6, 7), k)
    }


    @Test
    fun merge3() {
        val a = intArrayOf(0)
        val b = intArrayOf(1)
        solution3.merge(nums1 = a, m = 0, nums2 = b, n = 1)
        assertArrayEquals(intArrayOf(1), a)

        val c = intArrayOf(1)
        val d = intArrayOf()
        solution3.merge(nums1 = c, m = 1, nums2 = d, n = 0)
        assertArrayEquals(intArrayOf(1), c)

        val e = intArrayOf(1, 3, 5, 7, 0, 0, 0, 0)
        val f = intArrayOf(2, 4, 6, 8)
        solution3.merge(nums1 = e, m = 4, nums2 = f, n = 4)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8), e)

        val g = intArrayOf(1, 3, 5, 0, 0, 0, 0)
        val h = intArrayOf(2, 4, 6, 8)
        solution3.merge(nums1 = g, m = 3, nums2 = h, n = 4)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5, 6, 8), g)

        val i = intArrayOf(1, 3, 5, 7, 0, 0, 0)
        val j = intArrayOf(2, 4, 6)
        solution3.merge(nums1 = i, m = 4, nums2 = j, n = 3)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5, 6, 7), i)

        val k = intArrayOf(1, 1, 1, 2, 3, 5, 6, 0, 0, 0, 0, 0, 0, 0)
        val l = intArrayOf(1, 1, 2, 3, 4, 6, 7)
        solution3.merge(nums1 = k, m = 7, nums2 = l, n = 7)
        assertArrayEquals(intArrayOf(1, 1, 1, 1, 1, 2, 2, 3, 3, 4, 5, 6, 6, 7), k)
    }

}
