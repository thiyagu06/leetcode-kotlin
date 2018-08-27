package leetcode.easy._206_reverse_linked_list

import datastructures.list.ListNode

/**
 * 206 - https://leetcode.com/problems/reverse-linked-list/description/
 */
class IterativeSolution {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun reverseList(head: ListNode?): ListNode? {
        head ?: return null

        var previousNode: ListNode? = null
        var currentNode: ListNode? = head
        var nextNode: ListNode?

        while (currentNode != null) {
            nextNode = currentNode.next
            currentNode.next = previousNode

            previousNode = currentNode
            currentNode = nextNode
        }

        return previousNode
    }
}

class RecursiveSolution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun reverseList(head: ListNode?): ListNode? =
        when {
            head == null -> null
            head.next == null -> head
            else -> {
                val headOfReversedTail = reverseList(head.next)

                head.next?.next = head
                head.next = null

                headOfReversedTail
            }
        }
}
