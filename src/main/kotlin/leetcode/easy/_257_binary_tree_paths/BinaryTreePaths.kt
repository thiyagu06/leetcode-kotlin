package leetcode.easy._257_binary_tree_paths

import datastructures.tree.TreeNode
import datastructures.tree.rootToLeafPaths

/**
 * 257 - https://leetcode.com/problems/binary-tree-paths/
 */
class Solution {
    /**
     * Using the [rootToLeafPaths] extension.
     * Time: O(n)
     * Space: O(n)
     */
    fun binaryTreePaths(root: TreeNode?): List<String> =
        root?.let {
            it.rootToLeafPaths().map { path ->
                path.joinToString("->")
            }
        } ?: emptyList()
    }
