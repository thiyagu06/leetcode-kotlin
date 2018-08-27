package algorithms.easy._404_sum_of_left_leaves

import datastructures.tree.TreeNode
import datastructures.tree.isLeaf

/**
 * 404 - https://leetcode.com/problems/sum-of-left-leaves/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun sumOfLeftLeaves(root: TreeNode?, isLeftChild: Boolean = false): Int {
        root ?: return 0

        return when {
            root.isLeaf && isLeftChild -> root.`val`
            root.isLeaf && !isLeftChild -> 0
            else -> sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false)
        }
    }
}