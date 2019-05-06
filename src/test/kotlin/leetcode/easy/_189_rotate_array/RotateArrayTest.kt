package leetcode.easy._189_rotate_array

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class RotateArrayTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()

    @Test
    fun rotate() {
        val nums1 = intArrayOf()
        solution.rotate(nums1, 0)
        assertArrayEquals(intArrayOf(), nums1)

        val nums2 = intArrayOf()
        solution.rotate(nums2, 3)
        assertArrayEquals(intArrayOf(), nums2)

        val nums3 = intArrayOf(1)
        solution.rotate(nums3, 3)
        assertArrayEquals(intArrayOf(1), nums3)

        val nums4 = intArrayOf(1)
        solution.rotate(nums4, 3)
        assertArrayEquals(intArrayOf(1), nums4)

        val nums5 = IntArray(7) { i -> i + 1 }
        solution.rotate(nums5, 0)
        assertArrayEquals(IntArray(7) { i -> i + 1 }, nums5)

        val nums6 = IntArray(6) { i -> i + 1 }
        solution.rotate(nums6, 2)
        assertArrayEquals(intArrayOf(5, 6, 1, 2, 3, 4), nums6)

        val nums7 = IntArray(7) { i -> i + 1 }
        solution.rotate(nums7, 3)
        assertArrayEquals(intArrayOf(5, 6, 7, 1, 2, 3, 4), nums7)

        val nums8 = IntArray(7) { i -> i + 1 }
        solution.rotate(nums8, 7)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5, 6, 7), nums8)

        val nums9 = IntArray(7) { i -> i + 1 }
        solution.rotate(nums9, 10)
        assertArrayEquals(intArrayOf(5, 6, 7, 1, 2, 3, 4), nums9)
    }

    @Test
    fun rotateOptimal1() {
        val nums1 = intArrayOf()
        solution2.rotate(nums1, 0)
        assertArrayEquals(intArrayOf(), nums1)

        val nums2 = intArrayOf()
        solution2.rotate(nums2, 3)
        assertArrayEquals(intArrayOf(), nums2)

        val nums3 = intArrayOf(1)
        solution2.rotate(nums3, 3)
        assertArrayEquals(intArrayOf(1), nums3)

        val nums4 = intArrayOf(1)
        solution2.rotate(nums4, 3)
        assertArrayEquals(intArrayOf(1), nums4)

        val nums5 = IntArray(7) { i -> i + 1 }
        solution2.rotate(nums5, 0)
        assertArrayEquals(IntArray(7) { i -> i + 1 }, nums5)

        val nums6 = IntArray(6) { i -> i + 1 }
        solution2.rotate(nums6, 2)
        assertArrayEquals(intArrayOf(5, 6, 1, 2, 3, 4), nums6)

        val nums7 = IntArray(7) { i -> i + 1 }
        solution2.rotate(nums7, 3)
        assertArrayEquals(intArrayOf(5, 6, 7, 1, 2, 3, 4), nums7)

        val nums8 = IntArray(7) { i -> i + 1 }
        solution2.rotate(nums8, 7)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5, 6, 7), nums8)

        val nums9 = IntArray(7) { i -> i + 1 }
        solution2.rotate(nums9, 10)
        assertArrayEquals(intArrayOf(5, 6, 7, 1, 2, 3, 4), nums9)
    }

    @Test
    fun rotateOptimal2() {
        val nums1 = intArrayOf()
        solution3.rotate(nums1, 0)
        assertArrayEquals(intArrayOf(), nums1)

        val nums2 = intArrayOf()
        solution3.rotate(nums2, 3)
        assertArrayEquals(intArrayOf(), nums2)

        val nums3 = intArrayOf(1)
        solution3.rotate(nums3, 3)
        assertArrayEquals(intArrayOf(1), nums3)

        val nums4 = intArrayOf(1)
        solution3.rotate(nums4, 3)
        assertArrayEquals(intArrayOf(1), nums4)

        val nums5 = IntArray(7) { i -> i + 1 }
        solution3.rotate(nums5, 0)
        assertArrayEquals(IntArray(7) { i -> i + 1 }, nums5)

        val nums6 = IntArray(6) { i -> i + 1 }
        solution3.rotate(nums6, 2)
        assertArrayEquals(intArrayOf(5, 6, 1, 2, 3, 4), nums6)

        val nums7 = IntArray(7) { i -> i + 1 }
        solution3.rotate(nums7, 3)
        assertArrayEquals(intArrayOf(5, 6, 7, 1, 2, 3, 4), nums7)

        val nums8 = IntArray(7) { i -> i + 1 }
        solution3.rotate(nums8, 7)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5, 6, 7), nums8)

        val nums9 = IntArray(7) { i -> i + 1 }
        solution3.rotate(nums9, 10)
        assertArrayEquals(intArrayOf(5, 6, 7, 1, 2, 3, 4), nums9)
    }
}
