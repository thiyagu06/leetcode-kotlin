package leetcode.medium._611_valid_triangle_number

import org.junit.Test

import org.junit.Assert.*

class ValidTriangleNumberTest {

    private val solution = Solution()

    @Test
    fun triangleNumber() {
        assertEquals(0, solution.triangleNumber(intArrayOf(2, 3)))
        assertEquals(1, solution.triangleNumber(intArrayOf(2, 3, 4)))
        assertEquals(3, solution.triangleNumber(intArrayOf(2, 2, 3, 4)))
        assertEquals(3, solution.triangleNumber(intArrayOf(2, 4, 2, 3)))
        assertEquals(0, solution.triangleNumber(intArrayOf(2, 2, 4)))
        assertEquals(0, solution.triangleNumber(intArrayOf(2, 3, 5)))
    }
}