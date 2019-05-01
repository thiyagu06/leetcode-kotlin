package leetcode.easy._965_univalued_binary_tree

import datastructures.tree.TreeNode

/**
 * 965 - https://leetcode.com/problems/univalued-binary-tree/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun isUnivalTree(root: TreeNode?): Boolean = isUnivalTree(root, root!!.`val`)   // tree has at least 1 node

    private fun isUnivalTree(root: TreeNode?, treeValue: Int): Boolean = when {
        root == null -> true
        root.`val` != treeValue -> false
        else -> isUnivalTree(root.left, treeValue) && isUnivalTree(root.right, treeValue)
    }
}