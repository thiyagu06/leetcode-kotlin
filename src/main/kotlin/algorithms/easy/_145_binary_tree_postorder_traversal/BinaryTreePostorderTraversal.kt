package algorithms.easy._145_binary_tree_postorder_traversal

import datastructures.DFSTraveralOrder
import datastructures.TreeNode
import datastructures.collect

/**
 * 145 - https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 *
 * @author nrojiani
 * @date 11/17/17
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun postorderTraversal(root: TreeNode?): List<Int> =
            root.collect(DFSTraveralOrder.POSTORDER, arrayListOf()) { it.`val` }.toList()
}