package leetcode.easy._876_middle_of_linked_list

import datastructures.list.linkedListOf
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class MiddleOfLinkedListTest {

    private val solution = Solution()

    @Test
    fun middleNode() {
        assertNull(solution.middleNode(null))
        assertEquals(linkedListOf(1), solution.middleNode(linkedListOf(1)))
        assertEquals(linkedListOf(2), solution.middleNode(linkedListOf(1, 2)))
        assertEquals(linkedListOf(2, 3), solution.middleNode(linkedListOf(1, 2, 3)))
        assertEquals(linkedListOf(3, 4, 5), solution.middleNode(linkedListOf(1, 2, 3, 4, 5)))
        assertEquals(linkedListOf(4, 5, 6), solution.middleNode(linkedListOf(1, 2, 3, 4, 5, 6)))
    }
}