package algorithms.easy._206_reverse_linked_list

import datastructures.list.ListNode
import datastructures.list.tail

/**
 * 206 - https://leetcode.com/problems/reverse-linked-list/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun reverseList(head: ListNode?): ListNode? {
        head ?: return null

        var currentNode: ListNode? = head
        var previousNode: ListNode? = null
        var nextNode: ListNode?

        while (currentNode != null) {
            nextNode = currentNode.next     // store the original next, since the link will be changed.
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
                val reversedTail = reverseList(head.tail)

                head.next?.next = head
                head.next = null

                reversedTail
            }
        }
}
