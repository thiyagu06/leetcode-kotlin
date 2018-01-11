package algorithms.medium._623_add_one_row_to_tree

import datastructures.tree.TreeNode

/**
 * 623 - https://leetcode.com/problems/add-one-row-to-tree/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun addOneRow(root: TreeNode?, v: Int, d: Int): TreeNode? {
        root ?: return null

        return when (d) {
            1 -> {  /* Row at level of root */
                TreeNode(v).apply { left = root }
            }

            2 -> {  /* Parent of row to add */
                val oldLeft = root.left
                val newLeft = TreeNode(v).apply { left = oldLeft }
                root.left = newLeft

                val oldRight = root.right
                val newRight = TreeNode(v).apply { right = oldRight }
                root.right = newRight

                root
            }
            else -> {
                root.left = addOneRow(root.left, v = v, d = d - 1)
                root.right = addOneRow(root.right, v = v, d = d - 1)
                root
            }
        }
    }
}

/**
 * Easier to understand with separate parameter for depth.
 */
class Solution2 {
    fun addOneRow(root: TreeNode?, v: Int, d: Int, nodeDepth: Int = 1): TreeNode? {
        root ?: return null

        return when (d) {
            nodeDepth -> {      /* Row at level of root */
                TreeNode(v).apply { left = root }
            }
            nodeDepth + 1 -> {  /* Parent of row to add */
                val oldLeft = root.left
                val newLeft = TreeNode(v).apply { left = oldLeft }
                root.left = newLeft

                val oldRight = root.right
                val newRight = TreeNode(v).apply { right = oldRight }
                root.right = newRight

                root
            }
            else -> {
                root.left = addOneRow(root.left, v = v, d = d, nodeDepth = nodeDepth + 1)
                root.right = addOneRow(root.right, v = v, d = d, nodeDepth = nodeDepth + 1)
                root
            }
        }
    }
}