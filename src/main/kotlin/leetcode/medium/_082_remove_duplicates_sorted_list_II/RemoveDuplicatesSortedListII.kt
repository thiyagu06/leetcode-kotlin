package leetcode.medium._082_remove_duplicates_sorted_list_II

import datastructures.list.ListNode

/**
 * 82 - https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
class Solution {
    /**
     * Iterate through the list once and create a map of each value to its number of occurrences.
     * Then create a new list, adding a node only if it is distinct.
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun deleteDuplicates(head: ListNode?): ListNode? {
        head ?: return null

        // Iterate through and get the # of occurrences of each value
        val frequencies = hashMapOf<Int, Int>()
        head.forEach {
            frequencies[it] = frequencies.getOrDefault(it, 0) + 1
        }

        val sentinel = ListNode(Int.MIN_VALUE)
        var result: ListNode? = sentinel

        var node: ListNode? = head

        while (node != null) {
            if (frequencies[node.`val`] == 1) {
                result?.next = node
                result = result?.next

                node = result?.next
            } else {
                node = node.next
            }
        }
        result?.next = null                     // the tail element of the new list could point to duplicates.

        return sentinel.next
    }
}

class SolutionTwo {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun deleteDuplicates(head: ListNode?): ListNode? {
        head ?: return null

        // Iterate through and get the # of occurrences of each value
        val frequencies: MutableMap<Int, Int> = HashMap()
        head.forEach {
            frequencies[it] = frequencies.getOrDefault(it, 0) + 1
        }

        var node: ListNode? = head
        while (node?.next != null) {
            val nextFreq = frequencies.getValue(node.next!!.`val`)
            if (nextFreq > 1) {
                node.next = node.next?.next
            } else {
                node = node.next
            }
        }

        // Edge cases:
        // starts with duplicate: (1)->(1)->(2), or
        // list has no unique values: (1)->(1)->(2)->(2)
        return findFirstNonDuplicate(head, frequencies)
    }

    private fun findFirstNonDuplicate(head: ListNode, freqs: MutableMap<Int, Int>): ListNode? {
        var node: ListNode? = head

        while (node != null) {
            if (freqs.getValue(node.`val`) == 1) {
                return node
            }
            node = node.next
        }

        return null
    }
}