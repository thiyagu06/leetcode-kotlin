package extensions.iterable

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

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
        assertEquals(emptyList(), listOf(1).tail)
        assertEquals(emptyList(), emptyList<Int>().tail)
    }

    @Test
    fun headAndTail() {
        assertEquals((1 to listOf(2, 3, 4)), listOf(1, 2, 3, 4).headAndTail)
        assertEquals((1 to emptyList()), listOf(1).headAndTail)
        assertEquals((null to emptyList()), emptyList<Int>().headAndTail)
    }

    @Test
    fun frequencyMap() {
        assertEquals(
            mapOf("foo" to 2, "bar" to 1, "baz" to 1),
            listOf("foo", "bar", "foo", "baz").frequencyMap()
        )

        assertEquals(
            mapOf(1 to 2, 7 to 1),
            listOf(1, 7, 1).frequencyMap()
        )
    }
}