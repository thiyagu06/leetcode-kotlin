package leetcode.easy._203_remove_linked_list_elements

import datastructures.list.ListNode

/**
 * 203 - https://leetcode.com/problems/remove-linked-list-elements/
 */
class Solution {
    /**
     * Without using a sentinel, code must take care of more edge cases.
     * Time: O(n)
     * Space: O(1)
     */
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        var node: ListNode? = head

        /* if head should be removed, find first node with different value. */
        while (node != null && node.`val` == `val`) {
            node = node.next
        }

        val newHead = node
        while (node?.next != null) {
            if (node.next?.`val` == `val`) {
                node.next = node.next?.next
            } else {
                node = node.next
            }
        }

        return newHead
    }
}

class SolutionTwo {
    /**
     * Using a sentinel, code is simpler
     * Time: O(n)
     * Space: O(1)
     */
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        head ?: return null

        val sentinel = ListNode(Int.MIN_VALUE)
        sentinel.next = head
        var node: ListNode? = sentinel

        while (node?.next != null) {
            if (node.next?.`val` == `val`) {
                node.next = node.next?.next
            } else {
                node = node.next
            }
        }

        return sentinel.next
    }
}

class SolutionThree {
    /**
     * Recursive
     * Time: O(n)
     * Space: O(n)
     */
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        head ?: return null

        val tail = removeElements(head.next, `val`)

        return if (head.`val` == `val`) {
            tail
        } else {
            head.next = tail
            head
        }
    }
}