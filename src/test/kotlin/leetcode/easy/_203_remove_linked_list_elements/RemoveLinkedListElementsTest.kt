package leetcode.easy._203_remove_linked_list_elements

import datastructures.list.linkedListOf
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class RemoveLinkedListElementsTest {
    private val solution = Solution()

    @Test
    fun removeElements() {
        assertEquals(linkedListOf(1), solution.removeElements(linkedListOf(1), 7))
        assertEquals(linkedListOf(1, 2, 3), solution.removeElements(linkedListOf(1, 2, 3), 7))
        assertEquals(linkedListOf(1, 2, 3), solution.removeElements(linkedListOf(1, 2, 7, 3), 7))
        assertEquals(linkedListOf(1, 2, 3, 4, 5),
                solution.removeElements(linkedListOf(1, 2, 6, 3, 4, 5), 6))

        assertEquals(linkedListOf(1, 2, 3, 4, 5),
                solution.removeElements(linkedListOf(1, 2, 6, 6, 6, 6, 3, 4, 5), 6))

        assertEquals(linkedListOf(1, 2, 3, 4, 5),
                solution.removeElements(linkedListOf(1, 2, 6, 3, 4, 5), 6))

        assertEquals(
            linkedListOf(20, 14, 36, 11, 41),
            solution.removeElements(linkedListOf(20, 14, 36, 11, 72, 41), 72)
        )
    }

    @Test
    fun removeElementsEdgeCases() {
        // null list
        assertNull(solution.removeElements(null, 7))

        // remove first
        assertEquals(linkedListOf(2, 7, 3), solution.removeElements(linkedListOf(1, 2, 7, 3), 1))

        // remove first 2
        assertEquals(linkedListOf(2, 7, 3), solution.removeElements(linkedListOf(1, 1, 2, 7, 3), 1))

        // remove last
        assertEquals(linkedListOf(1, 2, 3, 4, 5),
                solution.removeElements(linkedListOf(1, 2, 6, 3, 4, 5, 6), 6))

        // remove the only element
        assertNull(solution.removeElements(linkedListOf(1), 1))
        // remove the only 2
        assertNull(solution.removeElements(linkedListOf(1, 1), 1))
    }

}
