package leetcode.medium._082_remove_duplicates_sorted_list_II

import datastructures.list.linkedListOf
import org.junit.Test

import org.junit.Assert.*

class RemoveDuplicatesSortedListIITest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

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

    @Test
    fun deleteDuplicates2() {
        assertNull(solution2.deleteDuplicates(null))
        assertNull(solution2.deleteDuplicates(linkedListOf(1, 1)))
        assertNull(solution2.deleteDuplicates(linkedListOf(11, 11, 11, 11, 75, 75)))

        assertEquals(
            linkedListOf(1),
            solution2.deleteDuplicates(linkedListOf(1))
        )

        assertEquals(
            linkedListOf(1, 2),
            solution2.deleteDuplicates(linkedListOf(1, 2))
        )

        assertEquals(
            linkedListOf(1, 2, 5),
            solution2.deleteDuplicates(linkedListOf(1, 2, 3, 3, 4, 4, 5))
        )

        assertEquals(
            linkedListOf(2, 3),
            solution2.deleteDuplicates(linkedListOf(1, 1, 1, 2, 3))
        )

        assertEquals(
            linkedListOf(2),
            solution2.deleteDuplicates(linkedListOf(1, 1, 1, 2, 3, 3))
        )
    }
}