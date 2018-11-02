package leetcode.medium._931_min_falling_path_sum

import extensions.arrays.buildIntMatrix
import org.junit.Test

import org.junit.Assert.*

class MinFallingPathSumTest {

    private val solution = Solution()

    @Test
    fun minFallingPathSum() {
        // 1->4->7
        assertEquals(
            12,
            solution.minFallingPathSum(
                buildIntMatrix(
                    listOf(1, 2, 3),
                    listOf(4, 5, 6),
                    listOf(7, 8, 9)
                )
            )
        )

        // 1->8->4
        assertEquals(
            13,
            solution.minFallingPathSum(
                buildIntMatrix(
                    listOf(3, 1, 2),
                    listOf(7, 9, 8),
                    listOf(6, 5, 4)
                )
            )
        )
    }
}