package extensions

import org.junit.Test

import org.junit.Assert.*

class ListExtTest {

    @Test
    fun frequencyMap() {
        assertEquals(
                mapOf("foo" to 2, "bar" to 1, "baz" to 1),
                listOf("foo", "bar", "foo", "baz").frequencyMap())

        assertEquals(
                mapOf(1 to 2, 7 to 1),
                listOf(1, 7, 1).frequencyMap())
    }

    @Test
    fun valueToIndicesMap() {
        assertEquals(
                mapOf("foo" to listOf(0, 2), "bar" to listOf(1), "baz" to listOf(3)),
                listOf("foo", "bar", "foo", "baz").valueToIndicesMap())

        assertEquals(
                mapOf(1 to listOf(0, 2), 7 to listOf(1)),
                listOf(1, 7, 1).valueToIndicesMap())
    }

    @Test
    fun toPair() {
        assertEquals(Pair(1, 2), listOf(1, 2).toPair())
    }

    @Test(expected = IllegalArgumentException::class)
    fun `toPair throws if size less than 2`() {
        listOf(1).toPair()

    }

    @Test(expected = IllegalArgumentException::class)
    fun `toPair throws if size greater than 2`() {
        listOf(1, 2, 3).toPair()
    }

    @Test
    fun toTriple() {
        assertEquals(Triple(1, 2, 3), listOf(1, 2, 3).toTriple())
    }

    @Test(expected = IllegalArgumentException::class)
    fun `toTriple throws if size less than 3`() {
        listOf(1, 2).toTriple()

    }

    @Test(expected = IllegalArgumentException::class)
    fun `toTriple throws if size greater than 3`() {
        listOf(1, 2, 3, 4).toTriple()
    }
}