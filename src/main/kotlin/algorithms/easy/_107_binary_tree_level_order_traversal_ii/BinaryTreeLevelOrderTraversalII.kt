package algorithms.easy._107_binary_tree_level_order_traversal_ii

import algorithms.medium._102_binary_tree_level_order_traversal.BFSSolution
import datastructures.tree.TreeNode

/**
 * 107 - https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> = BFSSolution().levelOrder(root).reversed()
}
