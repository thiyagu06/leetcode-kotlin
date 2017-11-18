package algorithms.easy._144_binary_tree_inorder_traversal

import datastructures.DFSTraveralOrder
import datastructures.TreeNode
import datastructures.collect

/**
 * 144 - https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 *
 * @author nrojiani
 * @date 11/17/17
 */
class Solution {
    fun preorderTraversal(root: TreeNode?): List<Int> =
            root.collect(DFSTraveralOrder.PREORDER, arrayListOf()) { it.`val` }.toList()
}