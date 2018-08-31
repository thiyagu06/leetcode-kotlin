package algorithms.medium._082_remove_duplicates_sorted_list_II

import datastructures.list.linkedListOf
import org.junit.Test

import org.junit.Assert.*

class RemoveDuplicatesSortedListIITest {

    private val solution = Solution()

    @Test
    fun deleteDuplicates() {
        assertNull(solution.deleteDuplicates(null))
        assertNull(solution.deleteDuplicates(linkedListOf(1, 1)))
        assertNull(solution.deleteDuplicates(linkedListOf(11, 11, 11, 11, 75, 75)))

        assertEquals(
            linkedListOf(1),
            solution.deleteDuplicates(linkedListOf(1))
        )

        assertEquals(
            linkedListOf(1, 2),
            solution.deleteDuplicates(linkedListOf(1, 2))
        )

        assertEquals(
            linkedListOf(1, 2, 5),
            solution.deleteDuplicates(linkedListOf(1, 2, 3, 3, 4, 4, 5))
        )

        assertEquals(
            linkedListOf(2, 3),
            solution.deleteDuplicates(linkedListOf(1, 1, 1, 2, 3))
        )

        assertEquals(
            linkedListOf(2),
            solution.deleteDuplicates(linkedListOf(1, 1, 1, 2, 3, 3))
        )
    }
}