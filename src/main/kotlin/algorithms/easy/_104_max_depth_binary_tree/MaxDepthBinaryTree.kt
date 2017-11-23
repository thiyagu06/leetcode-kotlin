package algorithms.easy._104_max_depth_binary_tree

import datastructures.tree.TreeNode

/**
 * 104 - https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * @author nrojiani
 * @date 11/13/17
 */
class Solution {
    fun maxDepth(root: TreeNode?): Int {
        root ?: return 0
        return 1 + maxOf(maxDepth(root.left), maxDepth(root.right))
    }
}