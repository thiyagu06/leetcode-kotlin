package leetcode.medium._019_remove_nth_node_from_end

import datastructures.list.ListNode

/**
 * 19 - https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null || n < 1) return null

        var tortoise: ListNode? = head
        var hare: ListNode? = head
        /* Move hare up n nodes - n will be valid */
        repeat(n) {
            hare = hare?.next
        }

        /* Edge case: n == size of list */
        if (hare == null) {
            return head.next
        }

        /* Move H & T up until H reaches the end. T will be before the node to delete */
        while (hare?.next != null) {
            hare = hare?.next
            tortoise = tortoise?.next
        }

        /* Skip nth node from end */
        tortoise?.next = tortoise?.next?.next

        return head
    }
}

class SolutionTwo {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        head ?: return null
        if (n < 1) return head
        var tortoise: ListNode? = head
        var hare: ListNode? = head

        /* Move hare up n + 1 nodes */
        repeat(n + 1) { i ->
            hare = hare?.next
            /* Edge case: n == list.size */
            if (i == n - 1 && hare == null) {
                return head.next
            }
        }

        /* Then move at same speed. Tortoise will end on node preceding nth from end */
        while (hare != null) {
            tortoise = tortoise?.next
            hare = hare?.next
        }

        tortoise?.next = tortoise?.next?.next

        return head
    }
}
