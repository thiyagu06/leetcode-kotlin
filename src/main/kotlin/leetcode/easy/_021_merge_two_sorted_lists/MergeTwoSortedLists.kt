package leetcode.easy._021_merge_two_sorted_lists

import datastructures.list.ListNode

/**
 * 21 - https://leetcode.com/problems/merge-two-sorted-lists/
 */
class Solution {
    /**
     * Time: O(m + n) - where m and n are the lengths of l1 and l2
     * Space: O(1)
     */
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        l1 ?: return l2
        l2 ?: return l1

        val sentinel = ListNode(Int.MIN_VALUE)
        var merged: ListNode? = sentinel
        var left: ListNode? = l1
        var right: ListNode? = l2

        while (left != null && right != null) {
            when {
                left.`val` <= right.`val` -> {
                    val leftNext = left.next
                    left.next = null
                    merged?.next = left
                    left = leftNext
                }
                left.`val` > right.`val` -> {
                    val rightNext = right.next
                    right.next = null
                    merged?.next = right
                    right = rightNext
                }
            }
            merged = merged?.next
        }

        merged?.next = left ?: right

        return sentinel.next
    }
}
