package algorithms.easy._083_remove_duplicates_sorted_llist

import datastructures.list.ListNode

/**
 * 83 - https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 */
class Solution {
    /**
     * Using a single pointer & modifying the links to skip duplicates
     *
     * Time: O(n)
     * Space: O(1)
     */
    fun deleteDuplicates(head: ListNode?): ListNode? {
        head ?: return null

        var node: ListNode? = head
        while (node?.next != null) {
            // skip the next node if it has the same value.
            if (node.`val` == node.next?.`val`) {
                node.next = node.next?.next
            } else {
                node = node.next
            }
        }
        return head
    }
}


class TwoPointerSolution {
    /**
     * Using a second pointer to search for non-duplicate values.
     *
     * Time: O(n)
     * Space: O(1)
     */
    fun deleteDuplicates(head: ListNode?): ListNode? {
        head ?: return null

        var node: ListNode? = head
        var leader: ListNode? = head

        while (node != null) {

            // Find next non-duplicate
            while (leader != null && leader.`val` == node.`val`) {
                leader = leader.next
            }

            node.next = leader
            node = node.next
            leader = node?.next
        }

        return head
    }
}

class AltSolution {
    /**
     * Using a hash set
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun deleteDuplicates(head: ListNode?): ListNode? {
        head ?: return null

        val distinct = hashSetOf<Int>()
        var node: ListNode? = head
        val sentinel = ListNode(Int.MIN_VALUE)
        var result: ListNode? = sentinel

        while (node != null) {
            if (!distinct.contains(node.`val`)) {
                distinct.add(node.`val`)
                result?.next = node
                result = result?.next
            }
            node = node.next

        }

        result?.next = null

        return sentinel.next
    }
}

