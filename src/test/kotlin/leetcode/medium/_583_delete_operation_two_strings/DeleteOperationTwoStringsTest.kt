package leetcode.medium._583_delete_operation_two_strings

import org.junit.Test

import kotlin.test.assertEquals

class DeleteOperationTwoStringsTest {

    private val solution = Solution()

    @Test
    fun minDistance() {
        assertEquals(2, solution.minDistance("eat", "sea"))
        assertEquals(4, solution.minDistance("ABCD", "CDAB"))
        assertEquals(4, solution.minDistance("ABABCDA", "BBCDAXY"))
        assertEquals(6, solution.minDistance("ABC", "XYZ"))
    }
}