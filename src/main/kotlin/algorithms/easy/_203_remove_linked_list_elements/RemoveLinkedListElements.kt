package algorithms.easy._203_remove_linked_list_elements

import datastructures.list.ListNode

/**
 * 203 - https://leetcode.com/problems/remove-linked-list-elements/description/
 */
class Solution {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        head ?: return null

        // Create sentinel to simplify case where the 1st node must be removed.
        val sentinel = ListNode(Int.MIN_VALUE)
        sentinel.next = head

        var node: ListNode? = sentinel
        while (node != null && node.next != null) {

            if (node.next?.`val` == `val`) {

                val newNext = node.next?.let {
                    it.firstOrNull { it.`val` != `val` }
                }
                node.next = newNext

            }

            node = node.next
        }

        return sentinel.next
    }

    private fun ListNode.firstOrNull(predicate: (ListNode) -> Boolean): ListNode? {
        var node: ListNode? = this
        while (node != null) {
            if (predicate(node)) {
                return node
            }
            node = node.next
        }
        return null
    }
}
