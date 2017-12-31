package algorithms.easy._538_convert_bst_to_greater_tree

import datastructures.tree.TreeNode
import datastructures.tree.collect

/**
 * 538 - https://leetcode.com/problems/convert-bst-to-greater-tree/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun convertBST(root: TreeNode?): TreeNode? {
        root ?: return null

        val treeValues = root.collect()         // node values in sorted order
        return convertBST(root, treeValues)
    }

    private fun convertBST(root: TreeNode?, treeValues: List<Int>): TreeNode? {
        root ?: return null

        val convertedRootValue = treeValues.dropWhile { it < root.`val` }.sum()

        return TreeNode(convertedRootValue).apply {
            left = convertBST(root.left, treeValues)
            right = convertBST(root.right, treeValues)
        }
    }
}