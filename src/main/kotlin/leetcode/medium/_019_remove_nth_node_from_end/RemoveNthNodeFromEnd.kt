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
        if (hare == null) return head.next

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
     * Recursive version
     * Time: O(n)
     * Space: O(n)
     */
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? = removeNth(head, n).first

    private fun removeNth(head: ListNode?, n: Int): Pair<ListNode?, Int> {
        head ?: return (null to 1)

        val (tail, nValue) = removeNth(head.next, n)
        return if (nValue == n) {
            (tail to nValue + 1)
        } else {
            head.next = tail
            (head to nValue + 1)
        }
    }
}
