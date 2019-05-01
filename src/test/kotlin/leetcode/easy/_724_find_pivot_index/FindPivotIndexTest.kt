package leetcode.easy._724_find_pivot_index

import org.junit.Test

import kotlin.test.assertEquals

class FindPivotIndexTest {

    private val solution = Solution()

    @Test
    fun pivotIndex() {
        assertEquals(3, solution.pivotIndex(intArrayOf(1, 7, 3, 6, 5, 6)))
        assertEquals(-1, solution.pivotIndex(intArrayOf(1, 2, 3)))
    }

    @Test
    fun pivotIndexBruteForce() {
        assertEquals(3, solution.pivotIndexBruteForce(intArrayOf(1, 7, 3, 6, 5, 6)))
        assertEquals(-1, solution.pivotIndexBruteForce(intArrayOf(1, 2, 3)))
    }
}