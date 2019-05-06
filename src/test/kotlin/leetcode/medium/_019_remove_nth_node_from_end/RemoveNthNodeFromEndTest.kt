package leetcode.medium._019_remove_nth_node_from_end

import datastructures.list.linkedListOf
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class RemoveNthNodeFromEndTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun removeNthFromEnd() {
        assertEquals(linkedListOf(1, 3), solution.removeNthFromEnd(linkedListOf(1, 2, 3), 2))
        assertEquals(linkedListOf(1, 2, 3, 5), solution.removeNthFromEnd(linkedListOf(1, 2, 3, 4, 5), 2))
        assertEquals(linkedListOf(1), solution.removeNthFromEnd(linkedListOf(1, 2), 1))
        assertEquals(linkedListOf(2), solution.removeNthFromEnd(linkedListOf(1, 2), 2))
        assertNull(solution.removeNthFromEnd(linkedListOf(1), 1))
        assertEquals(linkedListOf(2, 3), solution.removeNthFromEnd(linkedListOf(1, 2, 3), 3))
    }

    @Test
    fun removeNthFromEnd2() {
        assertEquals(linkedListOf(1, 3), solution2.removeNthFromEnd(linkedListOf(1, 2, 3), 2))
        assertEquals(linkedListOf(1, 2, 3, 5), solution2.removeNthFromEnd(linkedListOf(1, 2, 3, 4, 5), 2))
        assertEquals(linkedListOf(1), solution2.removeNthFromEnd(linkedListOf(1, 2), 1))
        assertEquals(linkedListOf(2), solution2.removeNthFromEnd(linkedListOf(1, 2), 2))
        assertNull(solution2.removeNthFromEnd(linkedListOf(1), 1))
        assertEquals(linkedListOf(2, 3), solution2.removeNthFromEnd(linkedListOf(1, 2, 3), 3))
    }
}
