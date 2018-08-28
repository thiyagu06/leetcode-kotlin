package algorithms.medium._328_odd_even_linked_list

import datastructures.list.linkedListOf
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class OddEvenLinkedListTest {

    private val solution = Solution()

    @Test
    fun oddEvenList() {
        assertNull(solution.oddEvenList(null))
        assertEquals(linkedListOf(1), solution.oddEvenList(linkedListOf(1)))
        assertEquals(linkedListOf(1, 2), solution.oddEvenList(linkedListOf(1, 2)))
        assertEquals(linkedListOf(1, 3, 2), solution.oddEvenList(linkedListOf(1, 2, 3)))
        assertEquals(linkedListOf(1, 3, 2, 4), solution.oddEvenList(linkedListOf(1, 2, 3, 4)))
        assertEquals(linkedListOf(1, 3, 5, 2, 4), solution.oddEvenList(linkedListOf(1, 2, 3, 4, 5)))
        assertEquals(linkedListOf(1, 3, 5, 7, 2, 4, 6), solution.oddEvenList(linkedListOf(1, 2, 3, 4, 5, 6, 7)))
    }
}