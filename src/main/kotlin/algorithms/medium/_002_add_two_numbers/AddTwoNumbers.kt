package algorithms.medium._002_add_two_numbers

import datastructures.list.ListNode
import datastructures.list.toList
import java.math.BigInteger

/**
 * 2 - https://leetcode.com/problems/add-two-numbers/description/
 */
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        l1 ?: return l2
        l2 ?: return l1

        return (valueOf(l1) + valueOf(l2)).toLinkedListOfDigitsReversed()
    }

    fun valueOf(reversedDigitList: ListNode): BigInteger =
            BigInteger(reversedDigitList.toList().reversed().joinToString(""))

    private fun BigInteger.toLinkedListOfDigitsReversed(): ListNode? {
        if (this == BigInteger.ZERO)
            return ListNode(0)

        val sentinel = ListNode(0)
        var node: ListNode? = sentinel
        var n = this
        while (n > BigInteger.ZERO && node != null) {
            val lastDigit = n % BigInteger.TEN
            node.next = ListNode(lastDigit.toInt())
            n /= BigInteger.TEN
            node = node.next
        }

        return sentinel.next
    }
}

