package algorithms.medium._144_binary_tree_preorder_traversal

import datastructures.tree.DFSTraversalOrder
import datastructures.tree.TreeNode
import datastructures.tree.collect

/**
 * 144 - https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 *
 * @author nrojiani
 * @date 11/17/17
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun preorderTraversal(root: TreeNode?): List<Int> =
            root.collect(DFSTraversalOrder.PREORDER, arrayListOf()) { it.`val` }.toList()
}