package algorithms.easy._206_reverse_linked_list

import datastructures.list.linkedListOf
import org.junit.Test

import org.junit.Assert.*

class ReverseLinkedListTest {
    private val iterativeSolution = Solution()
    private val recursiveSolution = RecursiveSolution()

    @Test
    fun reverseList() {
        assertNull(iterativeSolution.reverseList(null))
        assertEquals(linkedListOf(1), iterativeSolution.reverseList(linkedListOf(1)))
        assertEquals(linkedListOf(2, 1), iterativeSolution.reverseList(linkedListOf(1, 2)))
        assertEquals(linkedListOf(3, 2, 1), iterativeSolution.reverseList(linkedListOf(1, 2, 3)))
        assertEquals(linkedListOf(3, 3, 2, 2, 1), iterativeSolution.reverseList(linkedListOf(1, 2, 2, 3, 3)))
    }

    @Test
    fun reverseListRecursive() {
        assertNull(recursiveSolution.reverseList(null))
        assertEquals(linkedListOf(1), recursiveSolution.reverseList(linkedListOf(1)))
        assertEquals(linkedListOf(2, 1), recursiveSolution.reverseList(linkedListOf(1, 2)))
        assertEquals(linkedListOf(3, 2, 1), recursiveSolution.reverseList(linkedListOf(1, 2, 3)))
        assertEquals(linkedListOf(3, 3, 2, 2, 1), recursiveSolution.reverseList(linkedListOf(1, 2, 2, 3, 3)))
    }
}
