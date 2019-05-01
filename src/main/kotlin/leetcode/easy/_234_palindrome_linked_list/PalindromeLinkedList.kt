package leetcode.easy._234_palindrome_linked_list

import datastructures.list.ListNode
import datastructures.list.middleNode
import java.util.Stack

/**
 * 234 - https://leetcode.com/problems/palindrome-linked-list/
 */
class Solution {
    /**
     * Using a Stack
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun isPalindrome(head: ListNode?): Boolean {
        head ?: return true

        val stack = Stack<ListNode>()
        var node = head
        while (node != null) {
            stack.push(node)
            node = node.next
        }

        node = head
        while (node != null && stack.isNotEmpty()) {
            val top = stack.pop()
            if (top.`val` != node.`val`) {
                return false
            }
            node = node.next
        }

        return true
    }
}

/**
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
class FollowUpSolution {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun isPalindrome(head: ListNode?): Boolean {
        head ?: return true

        val secondHalf = head.middleNode
        val reversedSecondHalf = reverseList(secondHalf)

        var left = head
        var right = reversedSecondHalf

        while (left != null && right != null) {
            if (left.`val` != right.`val`) {
                return false
            }
            left = left.next
            right = right.next
        }

        return true
    }

    /**
     * From #206
     *
     * Time: O(n)
     * Space: O(1)
     */
    private fun reverseList(head: ListNode?): ListNode? {
        head ?: return null

        var previousNode: ListNode? = null
        var currentNode: ListNode? = head
        var nextNode: ListNode?

        while (currentNode != null) {
            nextNode = currentNode.next
            currentNode.next = previousNode

            previousNode = currentNode
            currentNode = nextNode
        }

        return previousNode
    }
}