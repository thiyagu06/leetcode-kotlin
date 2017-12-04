package extensions

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ArraysExtTest {
    private val nullRefArray: Array<String?>? = null
    private val arrayWithNulls = arrayOf("foo", null, "bar")
    private val arrayAllNulls: Array<String?> = arrayOf(null, null, null)
    private val arrayNoNulls: Array<String?> = arrayOf("foo", "bar", "baz")

    private val intArray = intArrayOf(1, 2, 3)
    private val emptyIntArray = intArrayOf()
    private val charArray = charArrayOf('1', '2', '3')
    private val emptyCharArray = charArrayOf()

    @Test
    fun isBlank() {
        // Array
        assertTrue(nullRefArray.isBlank())
        assertTrue(arrayOf<Int>().isBlank())
        assertFalse(arrayOf("foo").isBlank())

        // IntArray
        val nullIntArray: IntArray? = null
        assertTrue(nullIntArray.isBlank())
    }

    @Test
    fun anyNull() {
        assertTrue(arrayWithNulls.anyNull())
        assertTrue(arrayAllNulls.anyNull())
        assertFalse(arrayNoNulls.anyNull())
    }

    @Test
    fun allNull() {
        assertFalse(arrayWithNulls.allNull())
        assertTrue(arrayAllNulls.allNull())
        assertFalse(arrayNoNulls.allNull())
    }

    @Test
    fun isArrayType() {
        assertFalse("foo".isArrayType())
        assertFalse(7.isArrayType())

        assertTrue(arrayAllNulls.isArrayType())
        assertTrue(arrayWithNulls.isArrayType())
        assertTrue(arrayNoNulls.isArrayType())

        assertTrue(emptyIntArray.isArrayType())
        assertTrue(intArray.isArrayType())
        assertTrue(charArrayOf().isArrayType())
        assertTrue(emptyCharArray.isArrayType())
    }

    @Test
    fun groupingBy() {
        assertEquals(
                mapOf(1 to 2, 7 to 1),
                intArrayOf(1, 7, 1).groupingBy { it }.eachCount())
    }

    @Test
    fun frequencyMap() {
        assertEquals(
                mapOf("foo" to 2, "bar" to 1, "baz" to 1),
                arrayOf("foo", "bar", "foo", "baz").frequencyMap())

        assertEquals(
                mapOf("foo" to 2, "bar" to 1, "baz" to 1),
                listOf("foo", "bar", "foo", "baz").frequencyMap())

        assertEquals(
                mapOf(1 to 2, 7 to 1),
                intArrayOf(1, 7, 1).frequencyMap())
    }

    @Test
    fun valueToIndicesMap() {
        assertEquals(
                mapOf("foo" to listOf(0, 2), "bar" to listOf(1), "baz" to listOf(3)),
                arrayOf("foo", "bar", "foo", "baz").valueToIndicesMap())

        assertEquals(
                mapOf("foo" to listOf(0, 2), "bar" to listOf(1), "baz" to listOf(3)),
                listOf("foo", "bar", "foo", "baz").valueToIndicesMap())

        assertEquals(
                mapOf(1 to listOf(0, 2), 7 to listOf(1)),
                intArrayOf(1, 7, 1).valueToIndicesMap())
    }

    @Test
    fun swap() {
        var strArr = arrayOf("foo", "bar", "foo", "baz")
        strArr.swap(0, 2)
        assertArrayEquals(arrayOf("foo", "bar", "foo", "baz"), strArr)
        strArr.swap(1, 3)
        assertArrayEquals(arrayOf("foo", "baz", "foo", "bar"), strArr)

        var intArr = intArrayOf(1, 7, 1, 3, 6, 4)
        intArr.swap(1, 5)
        val expected = intArrayOf(1, 4, 1, 3, 6, 7)
        assertArrayEquals(expected, intArr)
    }

    @Test
    fun reverseElementsInRange() {
        var strArr = arrayOf("foo", "bar", "foo", "baz")
        strArr.reverseElementsInRange(1..3)
        assertArrayEquals(arrayOf("foo", "baz", "foo", "bar"), strArr)

        intArray.reverseElementsInRange(0..2)
        assertArrayEquals(intArrayOf(3, 2, 1), intArray)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `reverseElementsInRange with invalid range`() {
        var strArr = arrayOf("foo", "bar", "foo", "baz")
        strArr.reverseElementsInRange(2..4)
    }
}