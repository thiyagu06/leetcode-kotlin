package algorithms.easy._019_remove_nth_node_from_end

import datastructures.list.linkedListOf
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

/**
 * @author nrojiani
 * @date 11/21/17
 */
class RemoveNthNodeFromEndTest {

    private val solution = Solution()

    @Test
    fun removeNthFromEnd() {
        assertEquals(linkedListOf(1, 3), solution.removeNthFromEnd(linkedListOf(1, 2, 3), 2))
        assertEquals(linkedListOf(1, 2, 3, 5), solution.removeNthFromEnd(linkedListOf(1, 2, 3, 4, 5), 2))
        assertEquals(linkedListOf(1), solution.removeNthFromEnd(linkedListOf(1, 2), 1))
        assertEquals(linkedListOf(2), solution.removeNthFromEnd(linkedListOf(1, 2), 2))
        assertNull(solution.removeNthFromEnd(linkedListOf(1), 1))
        assertEquals(linkedListOf(2, 3), solution.removeNthFromEnd(linkedListOf(1, 2, 3), 3))
    }

}