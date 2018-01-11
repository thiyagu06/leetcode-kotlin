package algorithms.easy._110_balanced_binary_tree

import datastructures.tree.TreeNode
import kotlin.math.abs

/**
 * 110 - https://leetcode.com/problems/balanced-binary-tree/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun isBalanced(root: TreeNode?): Boolean {
        root ?: return true

        return isBalanced(root.left) && isBalanced(root.right)
                && abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
    }

    private fun maxDepth(root: TreeNode?): Int {
        root ?: return 0
        return 1 + maxOf(maxDepth(root.left), maxDepth(root.right))
    }
}
