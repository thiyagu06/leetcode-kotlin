package algorithms.easy._101_is_symmetric_tree

import datastructures.tree.TreeNode

/**
 * 101 - https://leetcode.com/problems/symmetric-tree/description/
 */
class Solution {
    fun isSymmetric(root: TreeNode?): Boolean {
        root ?: return true

        return areMirrorNodes(root.left, root.right)
    }

    private fun areMirrorNodes(leftTree: TreeNode?, rightTree: TreeNode?): Boolean = when {
        leftTree == null && rightTree == null -> true
        leftTree != null && rightTree != null -> {
            leftTree.`val` == rightTree.`val`
            && areMirrorNodes(leftTree.left, rightTree.right)
            && areMirrorNodes(leftTree.right, rightTree.left)
        }
        else -> false
    }
}
