package algorithms.easy._083_remove_duplicates_sorted_llist

import datastructures.list.ListNode
import datastructures.list.linkedListOf
import org.junit.Assert.assertEquals
import org.junit.Test

class RemoveDuplicatesSortedListTest {
    private val solution = Solution()

    @Test
    fun deleteDuplicates() {
        assertEquals(linkedListOf(1, 2), solution.deleteDuplicates(linkedListOf(1, 1, 2)))
        assertEquals(linkedListOf(1, 2, 3), solution.deleteDuplicates(ListNode.from(listOf(1, 1, 2, 3, 3))))
        assertEquals(linkedListOf(1), solution.deleteDuplicates(linkedListOf(1, 1, 1)))
    }

}
