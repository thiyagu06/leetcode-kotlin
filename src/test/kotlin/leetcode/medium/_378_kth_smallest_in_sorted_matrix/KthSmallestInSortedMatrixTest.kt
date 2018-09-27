package leetcode.medium._378_kth_smallest_in_sorted_matrix

import extensions.arrays.buildIntMatrix
import org.junit.Assert.*
import org.junit.Test

class KthSmallestInSortedMatrixTest {

    private val solution = Solution()

    @Test
    fun kthSmallest() {
        assertEquals(
            13,
            solution.kthSmallest(
                matrix = buildIntMatrix(listOf(1, 5, 9), listOf(10, 11, 13), listOf(12, 13, 15)),
                k = 8
            )
        )

        assertEquals(
            1,
            solution.kthSmallest(
                matrix = buildIntMatrix(listOf(1, 2), listOf(1, 3)),
                k = 2
            )
        )
    }
}