package extensions.ranges

import org.junit.Test

import org.junit.Assert.*

class IntRangeExtTest {

    @Test
    fun isNotEmpty() {
        assertTrue((0..10).isNotEmpty())
        assertTrue((0..1).isNotEmpty())
        assertTrue((0 until 1).isNotEmpty())
        assertTrue((0..0).isNotEmpty())
        assertFalse(IntRange.EMPTY.isNotEmpty())
    }
}