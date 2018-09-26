package leetcode.easy._876_middle_of_linked_list

import datastructures.list.ListNode

/**
 * 876 - https://leetcode.com/problems/middle-of-the-linked-list/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun middleNode(head: ListNode?): ListNode? {
        head ?: return null

        var tortoise: ListNode? = head
        var hare: ListNode? = head

        while (hare?.next != null) {
            tortoise = tortoise?.next
            hare = hare.next?.next
        }

        return tortoise
    }
}
