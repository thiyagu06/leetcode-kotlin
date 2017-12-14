package algorithms.easy._669_trim_bst

import datastructures.tree.TreeNode

/**
 * 669 - https://leetcode.com/problems/trim-a-binary-search-tree/description/
 */
class Solution {
    fun trimBST(root: TreeNode?, L: Int, R: Int): TreeNode? {
        var node = when {
            root == null -> null
            root.`val` < L -> trimBST(root.right, L, R)
            root.`val` > R -> trimBST(root.left, L, R)
            else -> root    // root.`val` in (L..R)
        }

        return node?.apply {
            left = trimBST(node.left, L, R)
            right = trimBST(node.right, L, R)
        }
    }
}
