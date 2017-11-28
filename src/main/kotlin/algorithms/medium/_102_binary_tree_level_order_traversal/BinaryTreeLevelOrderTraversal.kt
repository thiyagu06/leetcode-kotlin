package algorithms.medium._102_binary_tree_level_order_traversal

import datastructures.tree.TreeNode

/**
 * 102 - https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * @author nrojiani
 * @date 11/25/17
 */
class LevelOrderSolution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun levelOrder(root: TreeNode?, depth: Int = 0,
                   values: MutableList<MutableList<Int>> = arrayListOf()): List<List<Int>> {

        root ?: return values

        if (depth > values.lastIndex) {
            values += arrayListOf(root.`val`)
        } else {
            values[depth].add(root.`val`)
        }

        levelOrder(root.left, depth + 1, values)
        levelOrder(root.right, depth + 1, values)

        return values
    }
}
