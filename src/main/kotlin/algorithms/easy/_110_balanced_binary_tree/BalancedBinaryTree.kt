package algorithms.easy._110_balanced_binary_tree

import datastructures.tree.TreeNode

/**
 * 110 - https://leetcode.com/problems/balanced-binary-tree/
 *
 * Height (of a node): the number of edges on the longest path between the node and a leaf.
 *
 * Balanced: a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
 * of every node never differ by more than 1.
 *
 * @author nrojiani
 * @date 11/27/17
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun isBalanced(root: TreeNode?): Boolean {
        root ?: return true

        return isBalanced(root.left) && isBalanced(root.right)
                && Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
    }

    private fun maxDepth(root: TreeNode?): Int {
        root ?: return 0
        return 1 + maxOf(maxDepth(root.left), maxDepth(root.right))
    }
}
