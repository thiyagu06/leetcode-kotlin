package extensions.arrays


import org.junit.Assert.*
import org.junit.Test

class BooleanMatrixTest {
    /**
     * [
     *   [false, true, false, true],
     *   [false, true, false, true],
     *   [false, true, false, true]
     * ]
     */
    private val matrix3x4: BooleanMatrix = Array(3) { _ ->
        BooleanArray(4) { j -> j % 2 != 0 }
    }

    /**
     * [[false, true, false]]
     */
    private val matrix1x3: BooleanMatrix = Array(1) { booleanArrayOf(false, true, false) }

    private val list3x4: List<List<Boolean>> =
        listOf(listOf(false, true, false, true), listOf(false, true, false, true), listOf(false, true, false, true))
    private val list1x3: List<List<Boolean>> = listOf(listOf(false, true, false))

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
    fun toList() {
        assertEquals(list3x4, matrix3x4.toList())
        assertEquals(list1x3, matrix1x3.toList())
    }

    @Test
    fun debugString() {
        assertEquals(
            "[false, true, false, true]\n[false, true, false, true]\n[false, true, false, true]",
            matrix3x4.debugString()
        )
    }

    @Test
    fun toMatrix() {
        assertArrayEquals(list1x3.toMatrix(), matrix1x3)
        assertArrayEquals(list3x4.toMatrix(), matrix3x4)
    }

}