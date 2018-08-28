package algorithms.medium._094_binary_tree_inorder_traversal

import datastructures.tree.TreeNode

/**
 * 94 - https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 */
class Solution {
    fun inorderTraversal(root: TreeNode?, values: MutableList<Int> = arrayListOf()): List<Int> =
            root?.let {
                root.left?.let { left -> inorderTraversal(left, values) }
                values += root.`val`
                root.right?.let { right -> inorderTraversal(right, values) }
            } ?: values

}
