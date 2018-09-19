package leetcode.easy._543_diameter_of_binary_tree

import datastructures.tree.TreeNode
import kotlin.math.max

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
        val maxSubtreeDiameter = max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right))
        return max(diameter, maxSubtreeDiameter)
    }

    private fun maxDepth(root: TreeNode?): Int {
        root ?: return 0
        return 1 + max(maxDepth(root.left), maxDepth(root.right))
    }
}

class SolutionTwo {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    private var maxDiameter = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        dfs(root)
        return maxDiameter
    }

    private fun dfs(node: TreeNode?): Int {
        if (node == null)
            return 0

        val left = dfs(node.left)
        val right = dfs(node.right)
        maxDiameter = max(maxDiameter, left + right)
        return if (left > right) left + 1 else right + 1
    }
}