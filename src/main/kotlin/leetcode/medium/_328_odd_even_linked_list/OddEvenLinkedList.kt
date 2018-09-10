package leetcode.medium._328_odd_even_linked_list

import datastructures.list.ListNode
import extensions.math.isOdd

/**
 * 328 - https://leetcode.com/problems/odd-even-linked-list/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n) ?
     */
    fun oddEvenList(head: ListNode?): ListNode? {
        head ?: return null

        val oddSentinel = ListNode(Int.MIN_VALUE)
        val evenSentinel = ListNode(Int.MIN_VALUE)

        var lastOdd: ListNode? = oddSentinel
        var lastEven: ListNode? = evenSentinel
        var current: ListNode? = head
        var i = 1

        while (current != null) {
            val next = current.next
            if (i.isOdd) {
                lastOdd?.next = current
                lastOdd = lastOdd?.next
                lastOdd?.next = null
            } else {
                lastEven?.next = current
                lastEven = lastEven?.next
                lastEven?.next = null
            }

            current = next
            i++
        }

        lastOdd?.next = evenSentinel.next

        return oddSentinel.next
    }
}

class SolutionTwo {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun oddEvenList(head: ListNode?): ListNode? {
        head ?: return null

        var node: ListNode = head
        val evensSentinel = ListNode(Int.MIN_VALUE)
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