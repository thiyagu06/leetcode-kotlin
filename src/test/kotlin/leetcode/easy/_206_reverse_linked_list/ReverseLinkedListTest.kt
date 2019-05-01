package leetcode.easy._206_reverse_linked_list

import datastructures.list.linkedListOf
import kotlin.test.assertEquals
import kotlin.test.assertNull
import org.junit.Test

class ReverseLinkedListTest {
    private val iterativeSolution = IterativeSolution()
    private val recursiveSolution = RecursiveSolution()

    @Test
    fun reverseListIterative() {
        assertNull(iterativeSolution.reverseList(null))
        assertEquals(linkedListOf(1), iterativeSolution.reverseList(linkedListOf(1)))
        assertEquals(linkedListOf(1, 1), iterativeSolution.reverseList(linkedListOf(1, 1)))
        assertEquals(linkedListOf(2, 1), iterativeSolution.reverseList(linkedListOf(1, 2)))
        assertEquals(linkedListOf(3, 2, 1), iterativeSolution.reverseList(linkedListOf(1, 2, 3)))
        assertEquals(linkedListOf(3, 3, 2, 2, 1), iterativeSolution.reverseList(linkedListOf(1, 2, 2, 3, 3)))
    }

    @Test
    fun reverseListRecursive() {
        assertNull(recursiveSolution.reverseList(null))
        assertEquals(linkedListOf(1), recursiveSolution.reverseList(linkedListOf(1)))
        assertEquals(linkedListOf(1, 1), recursiveSolution.reverseList(linkedListOf(1, 1)))
        assertEquals(linkedListOf(2, 1), recursiveSolution.reverseList(linkedListOf(1, 2)))
        assertEquals(linkedListOf(3, 2, 1), recursiveSolution.reverseList(linkedListOf(1, 2, 3)))
        assertEquals(linkedListOf(3, 3, 2, 2, 1), recursiveSolution.reverseList(linkedListOf(1, 2, 2, 3, 3)))
    }
}
