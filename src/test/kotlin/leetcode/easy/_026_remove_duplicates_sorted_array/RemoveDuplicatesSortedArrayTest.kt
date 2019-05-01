package leetcode.easy._026_remove_duplicates_sorted_array

import org.junit.Assert.assertArrayEquals
import org.junit.Test

import kotlin.test.assertEquals

class RemoveDuplicatesSortedArrayTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()

    @Test
    fun removeDuplicates() {
        assertEquals(0, solution.removeDuplicates(intArrayOf()))
        assertEquals(1, solution.removeDuplicates(intArrayOf(1)))
        assertEquals(1, solution.removeDuplicates(intArrayOf(1, 1)))
        assertEquals(1, solution.removeDuplicates(intArrayOf(1, 1, 1)))

        val arr112 = intArrayOf(1, 1, 2)
        assertEquals(2, solution.removeDuplicates(arr112))
        assertArrayEquals(intArrayOf(1, 2), arr112.sliceArray(0 until 2))

        val arr1117 = intArrayOf(1, 1, 1, 7)
        assertEquals(2, solution.removeDuplicates(arr1117))
        assertArrayEquals(intArrayOf(1, 7), arr1117.sliceArray(0 until 2))

        val arr11173 = intArrayOf(1, 1, 1, 3, 7)
        assertEquals(3, solution.removeDuplicates(arr11173))
        assertArrayEquals(intArrayOf(1, 3, 7), arr11173.sliceArray(0 until 3))

        val arr0to4 = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
        assertEquals(5, solution.removeDuplicates(arr0to4))
        assertArrayEquals(intArrayOf(0, 1, 2, 3, 4), arr0to4.sliceArray(0 until 5))
    }

    @Test
    fun removeDuplicates2() {
        assertEquals(0, solution2.removeDuplicates(intArrayOf()))
        assertEquals(1, solution2.removeDuplicates(intArrayOf(1)))
        assertEquals(1, solution2.removeDuplicates(intArrayOf(1, 1)))
        assertEquals(1, solution2.removeDuplicates(intArrayOf(1, 1, 1)))

        val arr112 = intArrayOf(1, 1, 2)
        assertEquals(2, solution2.removeDuplicates(arr112))
        assertArrayEquals(intArrayOf(1, 2), arr112.sliceArray(0 until 2))

        val arr1117 = intArrayOf(1, 1, 1, 7)
        assertEquals(2, solution2.removeDuplicates(arr1117))
        assertArrayEquals(intArrayOf(1, 7), arr1117.sliceArray(0 until 2))

        val arr11173 = intArrayOf(1, 1, 1, 3, 7)
        assertEquals(3, solution2.removeDuplicates(arr11173))
        assertArrayEquals(intArrayOf(1, 3, 7), arr11173.sliceArray(0 until 3))

        val arr0to4 = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
        assertEquals(5, solution2.removeDuplicates(arr0to4))
        assertArrayEquals(intArrayOf(0, 1, 2, 3, 4), arr0to4.sliceArray(0 until 5))
    }

    @Test
    fun removeDuplicates3() {
        assertEquals(0, solution3.removeDuplicates(intArrayOf()))
        assertEquals(1, solution3.removeDuplicates(intArrayOf(1)))
        assertEquals(1, solution3.removeDuplicates(intArrayOf(1, 1)))
        assertEquals(1, solution3.removeDuplicates(intArrayOf(1, 1, 1)))

        val arr112 = intArrayOf(1, 1, 2)
        assertEquals(2, solution3.removeDuplicates(arr112))
        assertArrayEquals(intArrayOf(1, 2), arr112.sliceArray(0 until 2))

        val arr1117 = intArrayOf(1, 1, 1, 7)
        assertEquals(2, solution3.removeDuplicates(arr1117))
        assertArrayEquals(intArrayOf(1, 7), arr1117.sliceArray(0 until 2))

        val arr11173 = intArrayOf(1, 1, 1, 3, 7)
        assertEquals(3, solution3.removeDuplicates(arr11173))
        assertArrayEquals(intArrayOf(1, 3, 7), arr11173.sliceArray(0 until 3))

        val arr0to4 = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
        assertEquals(5, solution3.removeDuplicates(arr0to4))
        assertArrayEquals(intArrayOf(0, 1, 2, 3, 4), arr0to4.sliceArray(0 until 5))
    }
}
