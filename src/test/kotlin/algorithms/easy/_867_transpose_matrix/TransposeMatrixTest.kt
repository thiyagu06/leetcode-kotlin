package algorithms.easy._867_transpose_matrix

import extensions.arrays.IntMatrix
import org.junit.Assert.assertArrayEquals
import org.junit.Test

class TransposeMatrixTest {

    private val solution = Solution()
    private val solution2 = Solution2()

    /**
     * [
     *   [0, 1,  2,  3],
     *   [4, 5,  6,  7],
     *   [8, 9, 10, 11]
     * ]
     */
    private val matrix3x4: IntMatrix = Array(3) { i ->
        IntArray(4) { j -> (i * 4) + j }
    }

    /**
     * [[1, 2, 3]]
     */
    private val matrix1x3: IntMatrix = Array(1) { IntArray(3) { i -> i + 1 } }

    @Test
    fun transpose() {
        assertArrayEquals(
            arrayOf(intArrayOf(1), intArrayOf(2), intArrayOf(3)),
            solution.transpose(matrix1x3)
        )

        assertArrayEquals(Array(1) { IntArray(3) { i -> i + 1 } }, matrix1x3)

        assertArrayEquals(
            arrayOf(intArrayOf(0, 4, 8), intArrayOf(1, 5, 9), intArrayOf(2, 6, 10), intArrayOf(3, 7, 11)),
            solution.transpose(matrix3x4)
        )

        assertArrayEquals(Array(3) { i -> IntArray(4) { j -> (i * 4) + j } }, matrix3x4)

        assertArrayEquals(
            arrayOf(intArrayOf(1, 4), intArrayOf(2, 5), intArrayOf(3, 6)),
            solution.transpose(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)))
        )
    }


    @Test
    fun transpose2() {
        assertArrayEquals(
            arrayOf(intArrayOf(1), intArrayOf(2), intArrayOf(3)),
            solution2.transpose(matrix1x3)
        )

        assertArrayEquals(Array(1) { IntArray(3) { i -> i + 1 } }, matrix1x3)

        assertArrayEquals(
            arrayOf(intArrayOf(0, 4, 8), intArrayOf(1, 5, 9), intArrayOf(2, 6, 10), intArrayOf(3, 7, 11)),
            solution2.transpose(matrix3x4)
        )

        assertArrayEquals(Array(3) { i -> IntArray(4) { j -> (i * 4) + j } }, matrix3x4)

        assertArrayEquals(
            arrayOf(intArrayOf(1, 4), intArrayOf(2, 5), intArrayOf(3, 6)),
            solution2.transpose(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)))
        )
    }

}