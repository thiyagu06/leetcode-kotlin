package algorithms.easy._104_max_depth_binary_tree

import datastructures.tree.TreeNode

/**
 * 104 - https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 */
class Solution {
    fun maxDepth(root: TreeNode?): Int {
        root ?: return 0
        return 1 + maxOf(maxDepth(root.left), maxDepth(root.right))
    }
}
