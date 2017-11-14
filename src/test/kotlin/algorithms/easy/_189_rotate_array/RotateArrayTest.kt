package algorithms.easy._189_rotate_array

import org.junit.Assert.assertArrayEquals
import org.junit.Test

/**
 * @author nrojiani
 * @date 11/13/17
 */
class RotateArrayTest {

    private val solution = Solution()
    private val optimal = OptimalSolution()

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

        val nums5 = IntArray(7, { i -> i + 1 })
        solution.rotate(nums5, 0)
        assertArrayEquals(IntArray(7, { i -> i + 1 }), nums5)

        val nums6 = IntArray(7, { i -> i + 1 })
        solution.rotate(nums6, 3)
        assertArrayEquals(intArrayOf(5, 6, 7, 1, 2, 3, 4), nums6)

        val nums7 = IntArray(7, { i -> i + 1 })
        solution.rotate(nums7, 10)
        assertArrayEquals(intArrayOf(5, 6, 7, 1, 2, 3, 4), nums7)
    }

    @Test
    fun rotateOptimal() {
        val nums1 = intArrayOf()
        optimal.rotate(nums1, 0)
        assertArrayEquals(intArrayOf(), nums1)

        val nums2 = intArrayOf()
        optimal.rotate(nums2, 3)
        assertArrayEquals(intArrayOf(), nums2)

        val nums3 = intArrayOf(1)
        optimal.rotate(nums3, 3)
        assertArrayEquals(intArrayOf(1), nums3)

        val nums4 = intArrayOf(1)
        optimal.rotate(nums4, 3)
        assertArrayEquals(intArrayOf(1), nums4)

        val nums5 = IntArray(7, { i -> i + 1 })
        optimal.rotate(nums5, 0)
        assertArrayEquals(IntArray(7, { i -> i + 1 }), nums5)

        val nums6 = IntArray(7, { i -> i + 1 })
        optimal.rotate(nums6, 3)
        assertArrayEquals(intArrayOf(5, 6, 7, 1, 2, 3, 4), nums6)

        val nums7 = IntArray(7, { i -> i + 1 })
        optimal.rotate(nums7, 10)
        assertArrayEquals(intArrayOf(5, 6, 7, 1, 2, 3, 4), nums7)
    }

}