package algorithms.easy._101_is_symmetric_tree

import datastructures.tree.TreeNode

/**
 * 101 - https://leetcode.com/problems/symmetric-tree/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun isSymmetric(root: TreeNode?): Boolean =
        (root == null) || areMirrorNodes(root.left, root.right)

    private fun areMirrorNodes(l: TreeNode?, r: TreeNode?): Boolean = when {
        l == null && r == null -> true
        (l == null && r != null) || (l != null && r == null) -> false
        else -> (l?.`val` == r?.`val`)
                && areMirrorNodes(l?.left, r?.right)
                && areMirrorNodes(l?.right, r?.left)
    }
}
