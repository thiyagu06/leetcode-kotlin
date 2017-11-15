package algorithms.easy._101_is_symmetric_tree

import datastructures.TreeNode

/**
 * 101 - https://leetcode.com/problems/symmetric-tree/description/
 *
 * @author nrojiani
 * @date 11/13/17
 */
/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
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