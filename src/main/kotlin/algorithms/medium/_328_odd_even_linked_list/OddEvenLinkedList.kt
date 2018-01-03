package algorithms.medium._328_odd_even_linked_list

import datastructures.list.ListNode
import datastructures.list.contentToString

/**
 * 328 - https://leetcode.com/problems/odd-even-linked-list/description/
 */
class Solution {
    /**
     * Time: O(N)
     * Space: O(1)
     */
    fun oddEvenList(head: ListNode?): ListNode? {
        head ?: return null

        var node: ListNode = head
        var evensSentinel = ListNode(Int.MIN_VALUE)
        var evensTail: ListNode = evensSentinel

        while (node.next != null) {
            val evenNode = node.next!!

            node.next = evenNode.next
            evensTail.next = evenNode
            evensTail = evensTail.next!!
            evenNode.next = null

            node = node.next ?: node
        }

        node.next = evensSentinel.next

        return head
    }

}