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
        head ?: return null

        var prevNode: ListNode? = null
        var currNode: ListNode? = head
        var nextNode: ListNode? = head.next

        while (currNode != null) {
            currNode.next = prevNode

            prevNode = currNode
            currNode = nextNode
            nextNode = nextNode?.next
        }

        return prevNode
    }
}

class RecursiveSolution {
    /**
     * Time: O(n)
     * Space: O(n)
     */

    fun reverseList(head: ListNode?): ListNode? = when {
        head == null -> null
        head.next == null -> head
        else -> {
            val nextNode = head.next
            val tailReversed = reverseList(nextNode)
            nextNode?.next = head
            head.next = null
            tailReversed
        }
    }
}
