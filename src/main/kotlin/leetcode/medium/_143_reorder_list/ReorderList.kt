package leetcode.medium._143_reorder_list

import datastructures.list.ListNode
import datastructures.list.forEachNode
import java.util.ArrayDeque
import java.util.Deque

/**
 * 143 - https://leetcode.com/problems/reorder-list/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun reorderList(head: ListNode?) {
        head ?: return
        val deque: Deque<ListNode> = ArrayDeque()
        head.forEachNode { node ->
            deque.addLast(node)
        }

        var node: ListNode? = deque.removeFirst()

        var dequeueFromEnd = true
        while (deque.isNotEmpty()) {
            val nodeToAdd = if (dequeueFromEnd) {
                deque.removeLast()
            } else {
                deque.removeFirst()
            }

            node?.next = nodeToAdd
            node = node?.next
            dequeueFromEnd = !dequeueFromEnd
        }

        node?.next = null
    }
}