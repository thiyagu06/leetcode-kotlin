package extensions

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test

class PairExtTest {

    @Test
    fun toIntArray() {
        assertArrayEquals(intArrayOf(1, 2), Pair(1, 2).toIntArray())
    }

    @Test
    fun sum() {
        assertEquals(3, Pair(1, 2).sum())
    }

    @Test
    fun product() {
        assertEquals(-14, Pair(-7, 2).product())
    }

    @Test
    fun absDifference() {
        assertEquals(9, Pair(-7, 2).absDifference())
    }
}