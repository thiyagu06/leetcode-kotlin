package leetcode.medium._082_remove_duplicates_sorted_list_II

import datastructures.list.ListNode
import datastructures.list.forEach

/**
 * 82 - https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
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
            frequencies[it.`val`] = frequencies.getOrDefault(it.`val`, 0) + 1
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