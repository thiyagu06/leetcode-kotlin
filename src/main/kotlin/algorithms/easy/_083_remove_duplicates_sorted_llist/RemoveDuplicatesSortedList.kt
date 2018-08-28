package algorithms.easy._083_remove_duplicates_sorted_llist

import datastructures.list.ListNode

/**
 * 83 - https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 */
class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        head ?: return null

        var node: ListNode? = head
        while (node?.next != null) {
            if (node.`val` == node.next?.`val`) {
                node.next = node.next?.next
            } else {
                node = node.next

            }
        }
        return head
    }
}