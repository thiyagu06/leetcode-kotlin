package algorithms.easy._019_remove_nth_node_from_end

import datastructures.list.ListNode

/**
 * 19 - https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * Given: n will always be valid (n <= list.size)
 *
 * @author nrojiani
 * @date 11/21/17
 */
class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null || n < 1) return null

        /** TODO: case n = size */

        var tortoise: ListNode? = head
        var hare: ListNode? = head
        var spacesToMoveHare = n
        /* Move hare up n nodes - n will be valid */
        while (spacesToMoveHare-- > 0) {
            hare = hare?.next
        }

        if (hare == null) {     // n = list.size
            return head.next
        }

        /* Move H & T up until H reaches the end. T will be before the node to delete */
        while (hare?.next != null) {
            hare = hare?.next
            tortoise = tortoise?.next
        }

        tortoise?.next = tortoise?.next?.next

        return head
    }
}