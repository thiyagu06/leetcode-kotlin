package algorithms.medium._002_add_two_numbers

import datastructures.list.ListNode
import datastructures.list.toList
import java.math.BigDecimal
import java.math.BigInteger

/**
 * 2 - https://leetcode.com/problems/add-two-numbers/description/
 *
 * This fails on very large BigInteger values, where the result is off by 2-3 digits.
 * Not sure why.
 */
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        l1 ?: return l2
        l2 ?: return l1

        val sum = valueOf(l1) + valueOf(l2)
        return sum.toLinkedListOfDigitsReversed()
    }

    fun valueOf(reversedDigitList: ListNode): BigInteger =
            reversedDigitList.toList().foldIndexed(BigInteger.ZERO) { exp, total, digit ->
                val placeValue = Math.pow(10.0, exp.toDouble()).toBigDecimal()
                val digitValue = digit.toBigInteger().toBigDecimal()
                val adjustedDigitValue: BigDecimal = placeValue * digitValue
                total + adjustedDigitValue.toBigInteger()
            }

    private fun BigInteger.toLinkedListOfDigitsReversed(): ListNode? {
        if (this == BigInteger.ZERO)
            return ListNode(0)

        val sentinel = ListNode(0)
        var node: ListNode? = sentinel
        var n = this
        while (n > BigInteger.ZERO && node != null) {
            val leastSignificantDigit: BigInteger = n % 10.toBigInteger()
            node.next = ListNode(leastSignificantDigit.toInt())
            n /= (10.toBigInteger())
            node = node.next
        }

        return sentinel.next
    }
}



