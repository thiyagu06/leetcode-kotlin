package extensions.iterable

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class IterableExtTest {

    @Test
    fun head() {
        assertEquals(1, listOf(1, 2, 3, 4).head)
        assertEquals(1, listOf(1).head)
        assertNull(emptyList<Int>().head)
    }

    @Test
    fun tail() {
        assertEquals(listOf(2, 3, 4), listOf(1, 2, 3, 4).tail)
        assertEquals(emptyList<Int>(), listOf(1).tail)
        assertEquals(emptyList<Int>(), emptyList<Int>().tail)
    }

    @Test
    fun headAndTail() {
        assertEquals((1 to listOf(2, 3, 4)), listOf(1, 2, 3, 4).headAndTail)
        assertEquals((1 to emptyList<Int>()), listOf(1).headAndTail)
        assertEquals((null to emptyList<Int>()), emptyList<Int>().headAndTail)
    }

}