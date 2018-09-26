package leetcode.medium._102_binary_tree_level_order_traversal

import datastructures.tree.TreeNode
import java.util.*

/**
 * 102 - https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
class BFSSolution {
    /**
     * Uses BFS modified to track the depth (level)
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        root ?: return emptyList()

        val levels = ArrayList<ArrayList<Int>>()
        val queue: Queue<Pair<TreeNode, Int>> = ArrayDeque<Pair<TreeNode, Int>>()
        queue.add(root to 0)

        while (queue.isNotEmpty()) {
            val (node, depth) = queue.remove() ?: return levels

            if (depth > levels.lastIndex) {
                levels.add(arrayListOf())
            }
            levels[depth].add(node.`val`)

            node.left?.let { queue.add(it to depth + 1) }
            node.right?.let { queue.add(it to depth + 1) }
        }

        return levels
    }
}

class DFSSolution {
    /**
     * DFS Solution
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun levelOrder(
        root: TreeNode?,
        depth: Int = 0,
        values: MutableList<MutableList<Int>> = arrayListOf()
    ): List<List<Int>> {
        root ?: return values

        if (depth > values.lastIndex) {
            values += arrayListOf<Int>()
        }
        values[depth].add(root.`val`)

        levelOrder(root.left, depth + 1, values)
        levelOrder(root.right, depth + 1, values)

        return values
    }
}
