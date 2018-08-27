package leetcode.hard._145_binary_tree_postorder_traversal

import datastructures.tree.DFSTraversalOrder
import datastructures.tree.TreeNode
import datastructures.tree.collect

/**
 * 145 - https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 */
class Solution {
    /**
     * TODO: Add Tests
     * Time: O(n)
     * Space: O(n)
     */
    fun postorderTraversal(root: TreeNode?): List<Int> =
            root.collect(DFSTraversalOrder.POSTORDER, arrayListOf()) { it.`val` }.toList()
}

// TODO iterative solution
