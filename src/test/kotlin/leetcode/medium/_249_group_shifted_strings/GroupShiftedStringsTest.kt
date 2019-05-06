package leetcode.medium._249_group_shifted_strings

import org.junit.Test
import kotlin.test.assertEquals

class GroupShiftedStringsTest {

    private val solution = Solution()

    @Test
    fun groupStrings() {
        val expected1 = listOf(
            listOf("abc", "bcd", "xyz"),
            listOf("az", "ba"),
            listOf("acef"),
            listOf("a", "z")
        )
        val actual1 = solution.groupStrings(
            arrayOf("abc", "bcd", "acef", "xyz", "az", "ba", "a", "z")
        )
        assertEquals(expected1.size, actual1.size)
        assertEquals(expected1.toSet(), actual1.toSet())

        val expected2 = listOf(listOf("cba", "zyx"))
        val actual2 = solution.groupStrings(arrayOf("cba", "zyx"))
        assertEquals(expected2.size, actual2.size)
        assertEquals(expected2.toSet(), actual2.toSet())

        val expected3 = listOf(listOf("cba", "zyx"), listOf("abc"))
        val actual3 = solution.groupStrings(arrayOf("cba", "zyx", "abc"))
        assertEquals(expected3.size, actual3.size)
        assertEquals(expected3.toSet(), actual3.toSet())
    }
}