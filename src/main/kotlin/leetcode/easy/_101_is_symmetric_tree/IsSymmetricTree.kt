package leetcode.easy._101_is_symmetric_tree

import datastructures.tree.TreeNode
import java.util.LinkedList
import java.util.Queue

/**
 * 101 - https://leetcode.com/problems/symmetric-tree/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun isSymmetric(root: TreeNode?): Boolean =
        (root == null) || areMirrorNodes(root.left, root.right)

    private fun areMirrorNodes(p: TreeNode?, q: TreeNode?): Boolean = when {
        p == null || q == null -> p == q
        p.`val` != q.`val` -> false
        else -> areMirrorNodes(p.left, q.right) && areMirrorNodes(p.right, q.left)
    }
}

class IterativeSolution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun isSymmetric(root: TreeNode?): Boolean {
        root ?: return true

        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root.left)
        queue.add(root.right)

        while (queue.size >= 2) {
            val (left, right) = (queue.poll() to queue.poll())

            if (left == null && right == null)
                continue

            when {
                (left == null) xor (right == null) -> return false
                left.`val` != right.`val` -> return false
                else -> {
                    queue.add(left.left)
                    queue.add(right.right)
                    queue.add(left.right)
                    queue.add(right.left)
                }
            }
        }

        return true
    }
}
