package algorithms.medium._102_binary_tree_level_order_traversal

import datastructures.queue.ListQueue
import datastructures.tree.TreeNode

/**
 * 102 - https://leetcode.com/problems/binary-tree-level-order-traversal/description/
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
        val queue = ListQueue<Pair<TreeNode, Int>>()

        queue.enqueue(root to 0)

        while (queue.isNotEmpty()) {
            val (node, depth) = queue.dequeue() ?: return levels
            if (levels.lastIndex < depth) {
                levels.add(arrayListOf(node.`val`))
            } else {
                levels[depth].add(node.`val`)
            }
            node.left?.let { queue.enqueue(it to depth + 1) }
            node.right?.let { queue.enqueue(it to depth + 1) }
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
            values += arrayListOf(root.`val`)
        } else {
            values[depth].add(root.`val`)
        }

        levelOrder(root.left, depth + 1, values)
        levelOrder(root.right, depth + 1, values)

        return values
    }
}
