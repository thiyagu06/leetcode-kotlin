package extensions.arrays

import org.junit.Assert.*
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

    private val matrix3x4: Matrix = Array(3) { i ->
        IntArray(4) { j -> (i * 4) + j }
    }

    private val matrix1x3: Matrix = Array(1) { IntArray(3) { i -> i + 1 } }

    private val list3x4: List<List<Int>> = listOf(listOf(0, 1, 2, 3), listOf(4, 5, 6, 7), listOf(8, 9, 10, 11))
    private val list1x3: List<List<Int>> = listOf(listOf(1, 2, 3))

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
        assertTrue(charArray.isArrayType())
        assertTrue(emptyCharArray.isArrayType())
    }

    @Test
    fun groupingBy() {
        assertEquals(
            mapOf(1 to 2, 7 to 1),
            intArrayOf(1, 7, 1).groupingBy { it }.eachCount()
        )
    }

    @Test
    fun frequencyMap() {
        assertEquals(
            mapOf("foo" to 2, "bar" to 1, "baz" to 1),
            arrayOf("foo", "bar", "foo", "baz").frequencyMap()
        )

        assertEquals(
            mapOf(1 to 2, 7 to 1),
            intArrayOf(1, 7, 1).frequencyMap()
        )
    }

    @Test
    fun valueToIndicesMap() {
        assertEquals(
            mapOf("foo" to listOf(0, 2), "bar" to listOf(1), "baz" to listOf(3)),
            arrayOf("foo", "bar", "foo", "baz").valueToIndicesMap()
        )

        assertEquals(
            mapOf(1 to listOf(0, 2), 7 to listOf(1)),
            intArrayOf(1, 7, 1).valueToIndicesMap()
        )
    }

    @Test
    fun swap() {
        val strArr = arrayOf("foo", "bar", "foo", "baz")
        strArr.swap(0, 2)
        assertArrayEquals(arrayOf("foo", "bar", "foo", "baz"), strArr)
        strArr.swap(1, 3)
        assertArrayEquals(arrayOf("foo", "baz", "foo", "bar"), strArr)

        val intArr = intArrayOf(1, 7, 1, 3, 6, 4)
        intArr.swap(1, 5)
        val expected = intArrayOf(1, 4, 1, 3, 6, 7)
        assertArrayEquals(expected, intArr)
    }

    @Test
    fun reverseElementsInRange() {
        val strArr = arrayOf("foo", "bar", "foo", "baz")
        strArr.reverseElementsInRange(1..3)
        assertArrayEquals(arrayOf("foo", "baz", "foo", "bar"), strArr)

        intArray.reverseElementsInRange(0..2)
        assertArrayEquals(intArrayOf(3, 2, 1), intArray)

        charArray.reverseElementsInRange(0..2)
        assertArrayEquals(charArrayOf('3', '2', '1'), charArray)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `reverseElementsInRange with invalid range`() {
        val strArr = arrayOf("foo", "bar", "foo", "baz")
        strArr.reverseElementsInRange(2..4)
    }

    @Test
    fun headAndTailArrays() {
        assertArrayEquals(intArrayOf(1), intArrayOf(1, 2, 3, 4).headAndTailArrays().first)
        assertArrayEquals(intArrayOf(2, 3, 4), intArrayOf(1, 2, 3, 4).headAndTailArrays().second)
        assertArrayEquals(intArrayOf(1), intArrayOf(1).headAndTailArrays().first)
        assertArrayEquals(intArrayOf(), intArrayOf(1).headAndTailArrays().second)
        assertArrayEquals(intArrayOf(), intArrayOf().headAndTailArrays().first)
        assertArrayEquals(intArrayOf(), intArrayOf().headAndTailArrays().second)
    }

    @Test
    fun headAndTail() {
        assertEquals(1, intArrayOf(1, 2, 3, 4).headAndTail().first)
        assertArrayEquals(intArrayOf(2, 3, 4), intArrayOf(1, 2, 3, 4).headAndTail().second)
        assertEquals(1, intArrayOf(1).headAndTail().first)
        assertArrayEquals(intArrayOf(), intArrayOf(1).headAndTail().second)
        assertNull(intArrayOf().headAndTail().first)
        assertArrayEquals(intArrayOf(), intArrayOf().headAndTail().second)
    }

    @Test
    fun isSorted() {
        assertTrue(arrayOf("abc", "def", "ghi").isSorted())
        assertTrue(intArrayOf(1, 2, 3, 4).isSorted())
        assertFalse(intArrayOf(1, 2, 4, 3).isSorted())
        assertTrue(longArrayOf(1L, 2L, 3L, 4L).isSorted())
        assertFalse(longArrayOf(1L, 2L, 4L, 3L).isSorted())
        assertTrue(floatArrayOf(1F, 2F, 3F, 4F).isSorted())
        assertFalse(floatArrayOf(1F, 2F, 4F, 3F).isSorted())
        assertTrue(doubleArrayOf(1.0, 2.0, 3.0, 4.0).isSorted())
        assertFalse(doubleArrayOf(1.0, 2.0, 4.0, 3.0).isSorted())
        assertTrue(shortArrayOf(1, 2, 3, 4).isSorted())
        assertTrue(charArrayOf('1', '2', '3', '4').isSorted())
        assertFalse(charArrayOf('1', '2', '4', '3').isSorted())
        assertTrue(charArrayOf('1', '2', '3', 'A', 'a').isSorted())
    }

    @Test
    fun isSortedDescending() {
        assertTrue(arrayOf("ghi", "def", "abc").isSortedDescending())
        assertTrue(intArrayOf(4, 3, 2, 1).isSortedDescending())
        assertFalse(intArrayOf(4, 3, 1, 2).isSortedDescending())
        assertTrue(longArrayOf(4L, 3L, 2L, 1L).isSortedDescending())
        assertFalse(longArrayOf(1L, 3L, 4L).isSortedDescending())
        assertTrue(floatArrayOf(4F, 3F, 2F, 1F).isSortedDescending())
        assertFalse(floatArrayOf(1F, 2F, 4F, 3F).isSortedDescending())
        assertTrue(doubleArrayOf(4.0, 3.0, 2.0, 1.0).isSortedDescending())
        assertFalse(doubleArrayOf(1.0, 2.0, 4.0, 3.0).isSortedDescending())
        assertTrue(shortArrayOf(4, 3, 2).isSortedDescending())
        assertTrue(charArrayOf('4', '3', '2').isSortedDescending())
        assertFalse(charArrayOf('1', '2', '4', '3').isSortedDescending())
        assertTrue(charArrayOf('a', 'A', '1').isSortedDescending())
    }

    @Test
    fun subarrays() {
        val expected = listOf(
            intArrayOf(1),
            intArrayOf(1, 2),
            intArrayOf(1, 2, 3),
            intArrayOf(1, 2, 3, 4),
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(2),
            intArrayOf(2, 3),
            intArrayOf(2, 3, 4),
            intArrayOf(2, 3, 4, 5),
            intArrayOf(3),
            intArrayOf(3, 4),
            intArrayOf(3, 4, 5),
            intArrayOf(4),
            intArrayOf(4, 5),
            intArrayOf(5)
        )
        val actual = intArrayOf(1, 2, 3, 4, 5).subarrays()
        assertTrue(expected.size == actual.size)
        (expected zip actual).forEach { (e, a) ->
            assertArrayEquals(e, a)
        }
    }

    @Test
    fun sublists() {
        assertEquals(listOf(listOf(1), listOf(1, 2), listOf(2)), intArrayOf(1, 2).sublists())
        assertEquals(listOf(listOf(1), listOf(1, 2), listOf(2)), intArrayOf(1, 2).sublists())

        assertEquals(
            listOf(
                listOf(1),
                listOf(1, 2),
                listOf(1, 2, 3),
                listOf(1, 2, 3, 4),
                listOf(1, 2, 3, 4, 5),
                listOf(2),
                listOf(2, 3),
                listOf(2, 3, 4),
                listOf(2, 3, 4, 5),
                listOf(3),
                listOf(3, 4),
                listOf(3, 4, 5),
                listOf(4),
                listOf(4, 5),
                listOf(5)
            ), intArrayOf(1, 2, 3, 4, 5).sublists()
        )
    }

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


    @Test
    fun binarySearch() {
        assertEquals(1, arrayOf(1, 3, 4, 7, 9).binarySearch(3))
        assertEquals(1, intArrayOf(1, 3, 4, 7, 9).binarySearch(3))
    }

    @Test
    fun binarySearch_ShouldReturnMinus1ForAValueNotPresentInTheList() {
        assertEquals(NOT_FOUND, arrayOf(1.0, 2.0, 3.0, 4.0).binarySearch(5.0))
        assertEquals(NOT_FOUND, intArrayOf(1, 2, 3, 4).binarySearch(5))
    }

    @Test
    fun binarySearch_ListIsEmpty() {
        assertEquals(NOT_FOUND, emptyArray<Int>().binarySearch(7))
        assertEquals(NOT_FOUND, emptyIntArray.binarySearch(7))
    }

    @Test
    fun binarySearch_ShouldFindTheItemInASingleElementList() {
        assertEquals(0, arrayOf(3).binarySearch(3))
        assertEquals(0, intArrayOf(3).binarySearch(3))
    }

    @Test
    fun binarySearch_ShouldFindTheFirstItemInATwoElementList() {
        assertEquals(0, arrayOf(4, 11).binarySearch(4))
        assertEquals(0, intArrayOf(4, 11).binarySearch(4))
    }

    @Test
    fun binarySearch_ShouldFindTheLastItemInATwoElementList() {
        assertEquals(1, arrayOf(4, 11).binarySearch(11))
        assertEquals(1, intArrayOf(4, 11).binarySearch(11))
    }

    @Test
    fun binarySearch_ShouldFindTheMidItemInAnOddLengthList() {
        assertEquals(2, arrayOf(4, 4, 7, 9, 11).binarySearch(7))
        assertEquals(2, intArrayOf(4, 4, 7, 9, 11).binarySearch(7))
    }

    @Test
    fun binarySearch_ShouldFindThePreMidItemInAnEvenLengthList() {
        assertEquals(1, arrayOf(4, 5, 9, 11).binarySearch(5))
        assertEquals(1, intArrayOf(4, 5, 9, 11).binarySearch(5))
    }

    @Test
    fun binarySearch_ShouldFindThePostMidItemInAnEvenLengthList() {
        assertEquals(2, arrayOf(4, 5, 17, 29).binarySearch(17))
        assertEquals(2, intArrayOf(4, 5, 17, 29).binarySearch(17))
    }

    // Kotlin 1.2 equivalents
    @Test
    fun sublist() {
        assertEquals(listOf(1), intArray.sublist((0..0)))
        assertEquals(listOf(2, 3), intArray.sublist((1..2)))
        assertEquals(listOf("foo"), arrayNoNulls.sublist((0..0)))
        assertEquals(listOf("bar", "baz"), arrayNoNulls.sublist((1..2)))
    }

    @Test
    fun sublistsOfSizeK() {
        assertEquals(listOf(listOf(1), listOf(2), listOf(3)), intArray.sublistsOfSize(1))
        assertEquals(listOf(listOf(1, 2), listOf(2, 3)), intArray.sublistsOfSize(2))
        assertEquals(listOf(listOf(1, 2, 3)), intArray.sublistsOfSize(3))
        assertEquals(listOf(listOf("foo"), listOf("bar"), listOf("baz")), arrayNoNulls.sublistsOfSize(1))
        assertEquals(listOf(listOf("foo", "bar"), listOf("bar", "baz")), arrayNoNulls.sublistsOfSize(2))
        assertEquals(listOf(listOf("foo", "bar", "baz")), arrayNoNulls.sublistsOfSize(3))
    }
}