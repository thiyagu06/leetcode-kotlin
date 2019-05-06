package leetcode.medium._102_binary_tree_level_order_traversal

import datastructures.tree.TreeNode
import java.util.ArrayDeque
import java.util.Queue

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
        val levels: MutableList<MutableList<Int>> = ArrayList()
        root ?: return levels

        val queue: Queue<Pair<TreeNode, Int>> = ArrayDeque()
        queue.offer(root to 0)

        while (queue.isNotEmpty()) {
            val (node, depth) = queue.poll()

            if (depth > levels.lastIndex) {
                levels += ArrayList<Int>()
            }
            levels[depth].add(node.`val`)

            node.left?.let { queue.offer(it to depth + 1) }
            node.right?.let { queue.offer(it to depth + 1) }
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
        levels: MutableList<MutableList<Int>> = ArrayList()
    ): List<List<Int>> {
        root ?: return levels

        if (depth > levels.lastIndex) {
            levels += ArrayList<Int>()
        }
        levels[depth].add(root.`val`)

        levelOrder(root.left, depth + 1, levels)
        levelOrder(root.right, depth + 1, levels)

        return levels
    }
}
