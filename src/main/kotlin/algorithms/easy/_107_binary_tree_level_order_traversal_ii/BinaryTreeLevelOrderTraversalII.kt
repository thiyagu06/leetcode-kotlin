package algorithms.easy._107_binary_tree_level_order_traversal_ii

import algorithms.medium._102_binary_tree_level_order_traversal.LevelOrderSolution
import datastructures.tree.TreeNode

/**
 *
 *
 * @author nrojiani
 * @date 11/27/17
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> = LevelOrderSolution().levelOrder(root).reversed()
}
