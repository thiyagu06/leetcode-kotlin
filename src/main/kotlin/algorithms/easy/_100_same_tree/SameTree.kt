package algorithms.easy._100_same_tree

import datastructures.tree.TreeNode

/**
 * 100 - https://leetcode.com/problems/same-tree/description/
 *
 * @author nrojiani
 * @date 11/13/17
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null || q == null)
            return p == q

        if (p.`val` != q.`val`)
            return false

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }
}