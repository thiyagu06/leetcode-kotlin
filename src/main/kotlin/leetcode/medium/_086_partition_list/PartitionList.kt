package leetcode.medium._086_partition_list

import datastructures.list.ListNode

/**
 * 86 - https://leetcode.com/problems/partition-list/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun partition(head: ListNode?, x: Int): ListNode? {
        head ?: return null

        val leftSentinel = ListNode(Int.MIN_VALUE)
        val rightSentinel = ListNode(Int.MIN_VALUE)
        var leftEnd: ListNode = leftSentinel
        var rightEnd: ListNode = rightSentinel

        var node: ListNode? = head
        var nextNode: ListNode?

        while (node != null) {
            nextNode = node.next    // stored since node.next link will be removed

            if (node.`val` < x) {
                node.next = null    // is now the last node in left partition.
                leftEnd.next = node
                leftEnd = node
            } else {
                node.next = null
                rightEnd.next = node
                rightEnd = node
            }

            node = nextNode
        }

        /* Join the two partitions */
        leftEnd.next = rightSentinel.next

        return leftSentinel.next
    }
}
