package algorithms.easy._100_same_tree

import datastructures.tree.TreeNode

/**
 * 100 - https://leetcode.com/problems/same-tree/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean =
        when {
            p == null || q == null -> p == q
            p.`val` != q.`val` -> false
            else                   -> isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
        }
}
