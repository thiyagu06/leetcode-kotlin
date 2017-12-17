package algorithms.easy._572_subtree_of_another_tree

import datastructures.tree.TreeNode

/**
 * 572 - https://leetcode.com/problemset/top-interview-questions/
 */
class Solution {
    /**
     * Time: O(m * n) where m & n are the number of nodes in s & t.
     * Space: O(n)
     */
    fun isSubtree(s: TreeNode?, t: TreeNode?): Boolean {
        s ?: return false

        if (isSameTree(s, t))
            return true

        return isSubtree(s.left, t) || isSubtree(s.right, t)
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    private fun isSameTree(s: TreeNode?, t: TreeNode?): Boolean {
        if (s == null || t == null)
            return s == t

        if (s.`val` != t.`val`)
            return false

        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right)
    }
}

