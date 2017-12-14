package extensions

import org.junit.Test

import org.junit.Assert.*

class TripleExtTest {

    @Test
    fun toBooleanArray() {
        assertArrayEquals(booleanArrayOf(true, false, true), Triple(true, false, true).toBooleanArray())
    }

    @Test
    fun sum() {
        assertEquals(17, Triple(4, 3, 10).sum())
    }

    @Test
    fun product() {
        assertEquals(120, Triple(4, -3, -10).product())
    }
}