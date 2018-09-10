package leetcode.easy._021_merge_two_sorted_lists

import datastructures.list.linkedListOf
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class MergeTwoSortedListsTest {

    private val solution = Solution()

    @Test
    fun mergeTwoLists() {
        assertNull(solution.mergeTwoLists(null, null))
        assertEquals(linkedListOf(1, 2, 3), solution.mergeTwoLists(linkedListOf(1, 2, 3), null))
        assertEquals(linkedListOf(1, 2, 3), solution.mergeTwoLists(null, linkedListOf(1, 2, 3)))
        assertEquals(linkedListOf(1, 1, 2, 3, 4, 4), solution.mergeTwoLists(linkedListOf(1, 2, 4), linkedListOf(1, 3, 4)))
        assertEquals(linkedListOf(1, 1, 2, 3, 4, 4, 5), solution.mergeTwoLists(linkedListOf(1, 2, 4), linkedListOf(1, 3, 4, 5)))
    }
}