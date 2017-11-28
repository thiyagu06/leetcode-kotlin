package algorithms.easy._234_palindrome_linked_list

import datastructures.list.ListNode
import datastructures.list.middleNode
import datastructures.list.size
import datastructures.stack.ArrayStack
import extensions.isOdd

/**
 * 234 - https://leetcode.com/problems/palindrome-linked-list/description/
 *
 * @author nrojiani
 * @date 11/22/17
 */
class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        head ?: return true

        val stack = ArrayStack<Int>()
        var tortoise= head
        var hare = head

        while (hare != null && hare.next != null) {
            stack.push(tortoise!!.`val`)
            tortoise = tortoise.next
            hare = hare.next?.next
        }

        // tortoise is now at the middle node (the 2nd middle node if list.size is even)
        // if list.size is odd, skip middle node.
        if (hare != null) {
            tortoise = tortoise?.next
        }

        while (tortoise != null) {
            if (stack.pop() != tortoise.`val`) {
                return false
            }

            tortoise = tortoise.next
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

        val listSize = head.size
        val hasOddNumberOfNodes = listSize.isOdd
        val nodesInFirstHalf = listSize / 2

        var right = head.middleNode()   // Must get middle node before reversing first half.
        var left = reverseFirstXNodes(head, nodesInFirstHalf)

        if (hasOddNumberOfNodes)
            right = right?.next

        while (left != null && right != null) {
            if (left.`val` != right.`val`) return false

            left = left.next
            right = right.next
        }

        return left == null && right == null
    }

    /**
     * **Mutating**
     * Reverses the first [x] nodes in the list, returning the new head.
     *
     * ```
     * reverseFirstXNodes(linkedListOf(1, 2, 3, 4, 5), 3)
     * 1->2->3->4->5
     * 1<-2<-3
     * 3->2->1
     * ```
     *
     * See [algorithms.easy._206_reverse_linked_list.Solution.reverseList].
     *
     * @throws IllegalArgumentException if [x] is greater than the size of the list.
     */
    internal fun reverseFirstXNodes(head: ListNode?, x: Int): ListNode? {
        head ?: return null

        var nodesReversed = 0
        var previousNode: ListNode? = null
        var currentNode: ListNode? = head
        var nextNode: ListNode?

        while (nodesReversed < x && currentNode != null) {
            nextNode = currentNode.next    // Store original next, since currentNode's next pointer will change.
            currentNode.next = previousNode

            ++nodesReversed

            previousNode = currentNode
            currentNode = nextNode
        }

        if (nodesReversed < x) {
            throw IllegalArgumentException("$x is greater than the size of the list!")
        }

        return previousNode
    }
}

