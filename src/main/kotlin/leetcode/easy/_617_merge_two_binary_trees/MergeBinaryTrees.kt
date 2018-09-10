package leetcode.easy._617_merge_two_binary_trees

import datastructures.tree.TreeNode

/**
 * 617 - https://leetcode.com/problems/merge-two-binary-trees/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun mergeTrees(t1: TreeNode?, t2: TreeNode?): TreeNode? {
        t1 ?: return t2
        t2 ?: return t1

        return TreeNode(t1.`val` + t2.`val`).apply {
            left =  mergeTrees(t1.left, t2.left)
            right = mergeTrees(t1.right, t2.right)
        }
    }
}