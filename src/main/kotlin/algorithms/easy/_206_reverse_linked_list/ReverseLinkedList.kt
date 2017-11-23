package algorithms.easy._206_reverse_linked_list

import datastructures.list.ListNode

/**
 * 206 - https://leetcode.com/problems/reverse-linked-list/description/
 *
 * Time: O(n)
 * Space: O(1)
 *
 * @author nrojiani
 * @date 11/11/17
 */
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null)
            return null

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