package algorithms.easy._083_remove_duplicates_sorted_llist

import datastructures.ListNode
import datastructures.contentToString
import datastructures.linkedListOf
import datastructures.toList
import org.junit.Test

import org.junit.Assert.*

/**
 * @author nrojiani
 * @date 11/11/17
 */
class RemoveDeplicatesSortedListTest {
    private val solution = Solution()

    @Test
    fun deleteDuplicates() {
        val list111 = linkedListOf(1, 1, 1)
        val list112 = linkedListOf(1, 1, 2)
        val list11233 = ListNode.from(listOf(1, 1, 2, 3, 3))

        assertEquals(listOf(1, 2), solution.deleteDuplicates(list112)?.toList())
        assertEquals(listOf(1, 2, 3), solution.deleteDuplicates(list11233)?.toList())
        assertEquals(listOf(1), solution.deleteDuplicates(list111)?.toList())
    }

}