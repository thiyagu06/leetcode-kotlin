package algorithms.easy._206_reverse_linked_list

import datastructures.list.linkedListOf
import org.junit.Test

import org.junit.Assert.*

/**
 * @author nrojiani
 * @date 11/12/17
 */
class ReverseLinkedListTest {
    private val listReverser = Solution()

    @Test
    fun reverseList() {
        assertEquals(linkedListOf(1), listReverser.reverseList(linkedListOf(1)))
        assertEquals(linkedListOf(2, 1), listReverser.reverseList(linkedListOf(1, 2)))
        assertEquals(linkedListOf(3, 2, 1), listReverser.reverseList(linkedListOf(1, 2, 3)))
        assertEquals(linkedListOf(3, 3, 2, 2, 1), listReverser.reverseList(linkedListOf(1, 2, 2, 3, 3)))
    }

}