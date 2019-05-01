package leetcode.medium._054_spiral_matrix

import org.junit.Test

import kotlin.test.assertEquals

class SpiralMatrixTest {

    private val solution = Solution()

    @Test
    fun spiralOrder() {
        assertEquals(
            listOf(1, 2, 3, 6, 9, 8, 7, 4, 5),
            solution.spiralOrder(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                    intArrayOf(7, 8, 9)
                )
            )
        )

        assertEquals(
            listOf(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7),
            solution.spiralOrder(
                arrayOf(
                    intArrayOf(1, 2, 3, 4),
                    intArrayOf(5, 6, 7, 8),
                    intArrayOf(9, 10, 11, 12)
                )
            )
        )

        assertEquals(
            listOf(1, 2, 3, 4, 8, 12, 16, 20, 19, 18, 17, 13, 9, 5, 6, 7, 11, 15, 14, 10),
            solution.spiralOrder(
                arrayOf(
                    intArrayOf(1, 2, 3, 4),
                    intArrayOf(5, 6, 7, 8),
                    intArrayOf(9, 10, 11, 12),
                    intArrayOf(13, 14, 15, 16),
                    intArrayOf(17, 18, 19, 20)
                )
            )
        )
    }
}