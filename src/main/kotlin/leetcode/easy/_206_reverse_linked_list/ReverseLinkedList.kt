package leetcode.easy._206_reverse_linked_list

import datastructures.list.ListNode

/**
 * 206 - https://leetcode.com/problems/reverse-linked-list/
 */
class IterativeSolution {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun reverseList(head: ListNode?): ListNode? {
        head ?: return head

        var prev: ListNode? = null
        var curr: ListNode? = head
        var next: ListNode? = head.next

        while (curr != null) {
            curr.next = prev    // reverse link

            // Move each pointer up
            prev = curr
            curr = next
            next = next?.next
        }

        return prev
    }
}

class RecursiveSolution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun reverseList(head: ListNode?): ListNode? {
        head ?: return null
        head.next ?: return head

        val reversedHead = reverseList(head.next)

        head.next?.next = head
        head.next = null

        return reversedHead
    }
}
