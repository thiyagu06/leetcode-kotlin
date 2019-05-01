package leetcode.easy._572_subtree_of_another_tree

import datastructures.tree.TreeNode

/**
 * 572 - https://leetcode.com/problemset/top-interview-questions/
 */
class Solution {
    /**
     * Time: O(m * n), where m & n are the number of nodes in s & t.
     * Space: O(n)
     */
    fun isSubtree(s: TreeNode?, t: TreeNode?): Boolean {
        s ?: return false

        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t)
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    internal fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean =
        when {
            p == null || q == null -> p == q
            p.`val` != q.`val`     -> false
            else                   -> isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
        }
}

