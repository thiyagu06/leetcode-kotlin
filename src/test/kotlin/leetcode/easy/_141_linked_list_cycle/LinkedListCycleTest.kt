package leetcode.easy._141_linked_list_cycle

import datastructures.list.ListNode
import datastructures.list.linkedListOf
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LinkedListCycleTest {

    private val solution = Solution()
    private val noCycle = linkedListOf(1, 2, 3, 4, 5)
    private val cyclicList by lazy {
        val head = ListNode(1)
        val middle = linkedListOf(2, 3)
        head.next = middle
        middle.next?.next = head
        head
    }

    @Test
    fun hasCycle() {
        assertFalse(solution.hasCycle(noCycle))
        assertTrue(solution.hasCycle(cyclicList))
    }

    @Test
    fun hasCycle2() {
        assertFalse(solution.hasCycle2(noCycle))
        assertTrue(solution.hasCycle2(cyclicList))
    }
}