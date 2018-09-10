package leetcode.medium._513_find_bottom_left_tree_value

import datastructures.tree.TreeNode
import datastructures.tree.height

/**
 * 513 - https://leetcode.com/problems/find-bottom-left-tree-value/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun findBottomLeftValue(root: TreeNode?): Int {
        val treeHeight = root!!.height      // Note: You may assume the tree (i.e., the given root node) is not NULL.
        return findLeftmostLeafAtDepth(root, treeHeight, 0)!!
    }

    private fun findLeftmostLeafAtDepth(root: TreeNode?, treeHeight: Int, depth: Int = 0): Int? {
        root ?: return null

        if (depth == treeHeight) {
            return root.`val`
        }

        val resultLeft = findLeftmostLeafAtDepth(root.left, treeHeight, depth + 1)
        if (resultLeft != null)
            return resultLeft

        val resultRight = findLeftmostLeafAtDepth(root.right, treeHeight, depth + 1)
        if (resultRight != null) {
            return resultRight
        }

        return null
    }
}