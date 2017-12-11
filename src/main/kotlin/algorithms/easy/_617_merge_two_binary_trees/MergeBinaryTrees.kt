package algorithms.easy._617_merge_two_binary_trees

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
        return when {
            t1 != null && t2 != null -> TreeNode(t1.`val` + t2.`val`).apply {
                left =  mergeTrees(t1.left,  t2.left)
                right = mergeTrees(t1.right, t2.right)
            }
            t1 != null && t2 == null -> TreeNode(t1.`val`).apply {
                    left =  mergeTrees(t1.left,  null)
                    right = mergeTrees(t1.right, null)
                }
            t1 == null && t2 != null -> TreeNode(t2.`val`).apply {
                left =  mergeTrees(null, t2.left)
                right = mergeTrees(null, t2.right)
            }
            else -> null
        }
    }
}