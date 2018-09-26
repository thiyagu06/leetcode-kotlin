package leetcode.medium._002_add_two_numbers

import datastructures.list.ListNode

/**
 * 2 - https://leetcode.com/problems/add-two-numbers/
 */
class Solution {
    /**
     * Time: O(n) - technically O(max(m, n))
     * Space: O(n) - technically O(max(m, n)) - the length of the new list is at most `max(m, n) + 1`
     */
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? =
        when {
            l1 == null -> l2
            l2 == null -> l1
            else -> {
                val sentinel = ListNode(Int.MIN_VALUE)
                var sumList: ListNode? = sentinel
                var node1: ListNode? = l1
                var node2: ListNode? = l2
                var carry = 0

                while (node1 != null || node2 != null) {
                    val sum = carry + (node1?.`val` ?: 0) + (node2?.`val` ?: 0)
                    carry = sum / 10
                    sumList?.next = ListNode(sum % 10)

                    node1 = node1?.next
                    node2 = node2?.next
                    sumList = sumList?.next
                }

                if (carry == 1) {
                    sumList?.next = ListNode(1)
                }

                sentinel.next
            }
        }
}