package leetcode.easy._107_binary_tree_level_order_traversal_ii

import datastructures.tree.TreeNode
import datastructures.tree.levels

/**
 * 107 - https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> = root.levels().reversed()
}

class SolutionTwo {
    /**
     * Similar to #102, but adds each new row to the front, and uses rows.lastIndex - depth to
     * index nodes at the current depth.
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun levelOrderBottom(
        root: TreeNode?,
        depth: Int = 0,
        rows: MutableList<MutableList<Int>> = arrayListOf()
    ): List<List<Int>> {
        root ?: return rows

        if (depth > rows.lastIndex) {
            rows.add(0, arrayListOf())
        }
        rows[rows.lastIndex - depth].add(root.`val`)

        levelOrderBottom(root.left, depth + 1, rows)
        levelOrderBottom(root.right, depth + 1, rows)

        return rows
    }
}
