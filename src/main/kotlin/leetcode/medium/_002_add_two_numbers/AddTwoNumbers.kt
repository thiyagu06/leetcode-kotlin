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
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        l1 ?: return l2
        l2 ?: return l1

        val sentinel = ListNode(Int.MIN_VALUE)
        var sumTail: ListNode? = sentinel
        var a: ListNode? = l1
        var b: ListNode? = l2
        var carry = 0

        while (a != null || b != null) {
            val sum = carry + (a?.`val` ?: 0) + (b?.`val` ?: 0)
            carry = sum / 10
            sumTail?.next = ListNode(sum % 10)

            a = a?.next
            b = b?.next
            sumTail = sumTail?.next
        }

        if (carry == 1) {
            sumTail?.next = ListNode(1)
        }

        return sentinel.next
    }
}

class SolutionTwo {
    /**
     * Same approach, but exchange reduced ?'s for longer
     * Time: O(n) - technically O(max(m, n))
     * Space: O(n) - technically O(max(m, n)) - the length of the new list is at most `max(m, n) + 1`
     */
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        l1 ?: return l2
        l2 ?: return l1

        val sentinel = ListNode(Int.MAX_VALUE)
        var sumTail = sentinel
        var a: ListNode? = l1
        var b: ListNode? = l2
        var carry = 0

        while (a != null && b != null) {
            val rawSum = a.`val` + b.`val` + carry
            carry = rawSum / 10
            sumTail.next = ListNode(rawSum % 10)

            a = a.next
            b = b.next
            sumTail = sumTail.next!!
        }

        // a longer than b
        while (a != null) {
            val rawSum = a.`val` + carry
            carry = rawSum / 10
            sumTail.next = ListNode(rawSum % 10)
            a = a.next
            sumTail = sumTail.next!!
        }

        // b longer than a
        while (b != null) {
            val rawSum = b.`val` + carry
            carry = rawSum / 10
            sumTail.next = ListNode(rawSum % 10)
            b = b.next
            sumTail = sumTail.next!!
        }

        if (carry == 1) sumTail.next = ListNode(1)

        return sentinel.next
    }
}