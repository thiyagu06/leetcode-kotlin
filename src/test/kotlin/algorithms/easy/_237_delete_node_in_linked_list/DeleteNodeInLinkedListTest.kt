package algorithms.easy._237_delete_node_in_linked_list

import datastructures.list.linkedListOf
import org.junit.Assert.assertEquals
import org.junit.Test

class DeleteNodeInLinkedListTest {
    private val solution = Solution()
    private val list = linkedListOf(4, 5, 1, 9)

    @Test
    fun deleteFirstNode() {
        val nodeToDelete = list
        solution.deleteNode(nodeToDelete)
        assertEquals(linkedListOf(5, 1, 9), list)
    }

    @Test
    fun deleteSecondNode() {
        val nodeToDelete = list.next
        solution.deleteNode(nodeToDelete)
        assertEquals(linkedListOf(4, 1, 9), list)
    }

    @Test
    fun deleteThirdNode() {
        val nodeToDelete = list.next?.next
        solution.deleteNode(nodeToDelete)
        assertEquals(linkedListOf(4, 5, 9), list)
    }
}