package algorithms.easy._203_remove_linked_list_elements

import datastructures.list.ListNode

/**
 * 203 - https://leetcode.com/problems/remove-linked-list-elements/description/
 */
class Solution {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        head ?: return null

        var sentinel = ListNode(Int.MIN_VALUE)
        var result: ListNode? = sentinel
        var node: ListNode? = head

        while (node != null) {
            if (node.`val` != `val`) {
                result?.next = node
                result = result?.next
            }
            node = node.next
        }

        // Edge case: if the last node of the list has target value, remove pointer at end of result list.
        if (result?.next?.`val` == `val`) {
            result?.next = null
        }

        return sentinel.next
    }
}