package algorithms.easy._100_same_tree

import datastructures.tree.TreeNode

/**
 * 100 - https://leetcode.com/problems/same-tree/description/
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
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null || q == null)
            return p == q

        if (p.`val` != q.`val`)
            return false

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }
}