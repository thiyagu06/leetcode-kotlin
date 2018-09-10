package leetcode.easy._257_binary_tree_paths

import datastructures.tree.TreeNode
import datastructures.tree.rootToLeafPaths

/**
 * 257 - https://leetcode.com/problems/binary-tree-paths/description/
 */
class Solution {
    /**
     * Time: O(?)
     * Space: O(?)
     */
    fun binaryTreePaths(root: TreeNode?): List<String> {
        val valuePaths = root.rootToLeafPaths()     /* [[1, 2, 5], [1, 3]] */
        return valuePaths.map { path ->
            path.joinToString("->")
        }
    }
}
