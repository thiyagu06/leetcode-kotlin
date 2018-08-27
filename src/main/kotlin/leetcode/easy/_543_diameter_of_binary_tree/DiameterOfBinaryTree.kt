package leetcode.easy._543_diameter_of_binary_tree

import datastructures.tree.TreeNode

/**
 * 543 - https://leetcode.com/problems/diameter-of-binary-tree/description/
 */
class Solution {
    /**
     * https://leetcode.com/problems/diameter-of-binary-tree/discuss/101120/
     *
     * Time: O(n log n)
     * Space: O(n)
     */
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        root ?: return 0

        val diameter = maxDepth(root.left) + maxDepth(root.right)
        val leftDiameter = diameterOfBinaryTree(root.left)
        val rightDiameter = diameterOfBinaryTree(root.right)
        val maxSubtreeDiameter = maxOf(leftDiameter, rightDiameter)
        return maxOf(diameter, maxSubtreeDiameter)
    }

    private fun maxDepth(root: TreeNode?): Int {
        root ?: return 0
        return 1 + maxOf(maxDepth(root.left), maxDepth(root.right))
    }
}