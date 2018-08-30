package algorithms.easy._876_middle_of_linked_list

import datastructures.list.ListNode

class Solution {
    fun middleNode(head: ListNode?): ListNode? {
        head ?: return null
        
        var tortoise: ListNode? = head
        var hare: ListNode? = head
        
        while (hare?.next != null) {
            tortoise = tortoise?.next
            hare = hare?.next?.next
        }
        
        return tortoise
    }
}