package extensions.arrays


import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test

class IntMatrixTest {
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

    private val list3x4: List<List<Int>> = listOf(listOf(0, 1, 2, 3), listOf(4, 5, 6, 7), listOf(8, 9, 10, 11))
    private val list1x3: List<List<Int>> = listOf(listOf(1, 2, 3))

    /* Matrix */
    @Test
    fun matrixProperties() {
        assertEquals(3, matrix3x4.rows)
        assertEquals(4, matrix3x4.columns)
        assertEquals(2, matrix3x4.lastRow)
        assertEquals(3, matrix3x4.lastColumn)
        assertEquals((0 until 3), matrix3x4.rowRange)
        assertEquals((0 until 4), matrix3x4.columnRange)
        assertEquals(1, matrix1x3.rows)
        assertEquals(3, matrix1x3.columns)
        assertEquals(0, matrix1x3.lastRow)
        assertEquals(2, matrix1x3.lastColumn)
        assertEquals((0 until 1), matrix1x3.rowRange)
        assertEquals((0 until 3), matrix1x3.columnRange)
        assertEquals((0..-1), emptyArray<IntArray>().rowRange)
        assertEquals((0..-1), emptyArray<IntArray>().columnRange)
    }

    @Test
    fun intMatrixWithSize() {
        assertArrayEquals(
            arrayOf(intArrayOf(0, 0), intArrayOf(0, 0), intArrayOf(0, 0)),
            intMatrixWithSize(3, 2)
        )

        assertArrayEquals(
            arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0), intArrayOf(0, 0, 0)),
            intMatrixWithSize(3, 3)
        )

        assertArrayEquals(
            arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0)),
            intMatrixWithSize(2, 3)
        )
    }

    @Test
    fun buildIntMatrix() {
        assertArrayEquals(
            matrix1x3,
            buildIntMatrix(listOf(1, 2, 3))
        )

        assertArrayEquals(
            matrix3x4,
            buildIntMatrix(listOf(0, 1, 2, 3), listOf(4, 5, 6, 7), listOf(8, 9, 10, 11))
        )
    }

    @Test(expected = IllegalArgumentException::class)
    fun buildIntMatrixDifferingRowLengths() {
        extensions.arrays.buildIntMatrix(listOf(1), listOf(2, 3))
    }

    @Test(expected = IllegalArgumentException::class)
    fun buildIntMatrixNoElements() {
        extensions.arrays.buildIntMatrix()
    }

    @Test(expected = IllegalArgumentException::class)
    fun buildIntMatrixNoElements2() {
        extensions.arrays.buildIntMatrix(emptyList())
    }

    @Test
    fun toList() {
        assertEquals(list3x4, matrix3x4.toList())
        assertEquals(list1x3, matrix1x3.toList())
    }

    @Test
    fun debugString() {
        assertEquals("[0, 1, 2, 3]\n[4, 5, 6, 7]\n[8, 9, 10, 11]", matrix3x4.debugString())
    }

    @Test
    fun toMatrix() {
        assertArrayEquals(list1x3.toMatrix(), matrix1x3)
        assertArrayEquals(list3x4.toMatrix(), matrix3x4)
    }

    @Test
    fun transpose() {
        assertEquals(listOf(listOf(1), listOf(2), listOf(3)), matrix1x3.transpose().toList())
        assertEquals(
            listOf(listOf(0, 4, 8), listOf(1, 5, 9), listOf(2, 6, 10), listOf(3, 7, 11)),
            matrix3x4.transpose().toList()
        )

        assertArrayEquals(
            arrayOf(intArrayOf(1, 4), intArrayOf(2, 5), intArrayOf(3, 6)),
            arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)).transpose()
        )

        assertArrayEquals(
            arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)),
            arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)).transpose().transpose()
        )
    }
}