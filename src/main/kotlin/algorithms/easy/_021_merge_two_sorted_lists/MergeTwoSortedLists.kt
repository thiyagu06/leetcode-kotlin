package algorithms.easy._021_merge_two_sorted_lists

import datastructures.list.ListNode

/**
 * 21 - https://leetcode.com/problems/merge-two-sorted-lists/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null && l2 == null)
            return null

        var left: ListNode? = l1
        var right: ListNode? = l2

        val sentinel = ListNode(Int.MIN_VALUE)
        var merged: ListNode = sentinel

        while (left != null && right != null) {
            when {
                left.`val` <= right.`val` -> {
                    merged.next = left
                    left = left.next
                }
                else -> {
                    merged.next = right
                    right = right.next
                }
            }
            merged = merged.next!!
        }

        // add remaining to merged if l1.size != l2.size
        merged.next = if (left != null) left else right

        return sentinel.next
    }

}
