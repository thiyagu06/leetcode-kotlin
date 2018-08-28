package extensions.arrays


import org.junit.Assert.*
import org.junit.Test

class MatrixTest {
    private val matrix3x4: Matrix = Array(3) { i ->
        IntArray(4) { j -> (i * 4) + j }
    }

    private val matrix1x3: Matrix = Array(1) { IntArray(3) { i -> i + 1 } }

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
    }

    @Test
    fun toList() {
        assertEquals(list3x4, matrix3x4.toList())
        assertEquals(list1x3, matrix1x3.toList())
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
    }
}