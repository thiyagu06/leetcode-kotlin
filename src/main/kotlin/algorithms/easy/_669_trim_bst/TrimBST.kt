package algorithms.easy._669_trim_bst

import datastructures.tree.TreeNode

/**
 * 669 - https://leetcode.com/problems/trim-a-binary-search-tree/description/
 */
class Solution {
    fun trimBST(root: TreeNode?, L: Int, R: Int): TreeNode? {
        root ?: return null

        var node = when {
            root.`val` in (L..R) -> root
            root.`val` < L -> trimBST(root.right, L, R)
            root.`val` > R -> trimBST(root.left, L, R)
        }
    }

}