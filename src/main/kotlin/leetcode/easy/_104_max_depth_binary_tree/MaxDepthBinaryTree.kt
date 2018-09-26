package leetcode.easy._104_max_depth_binary_tree

import datastructures.tree.TreeNode

/**
 * 104 - https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun maxDepth(root: TreeNode?): Int {
        root ?: return 0
        return 1 + maxOf(maxDepth(root.left), maxDepth(root.right))
    }
}

class AltSolution {
    /**
     * Just another way to write it.
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun maxDepth(root: TreeNode?, depth: Int = 1): Int {
        root ?: return depth - 1
        return maxOf(maxDepth(root.left, depth + 1), maxDepth(root.right, depth + 1))
    }
}
