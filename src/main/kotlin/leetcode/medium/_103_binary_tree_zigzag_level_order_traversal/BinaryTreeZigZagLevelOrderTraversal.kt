package leetcode.medium._103_binary_tree_zigzag_level_order_traversal

import datastructures.tree.TreeNode
import datastructures.tree.levels
import extensions.lists.append
import extensions.lists.prepend
import extensions.math.isEven
import extensions.math.isOdd
import java.util.ArrayDeque
import java.util.Queue

/**
 * 103 - https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
class Solution {

    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun zigzagLevelOrder(
        root: TreeNode?,
        levels: MutableList<MutableList<Int>> = arrayListOf()
    ): List<List<Int>> {

        root ?: return levels

        val queue: Queue<Pair<TreeNode, Int>> = ArrayDeque()
        queue.offer(Pair(root, 0))

        while (queue.isNotEmpty()) {
            val (node, depth) = queue.poll()

            when {
                depth == levels.size -> levels += arrayListOf(node.`val`)
                depth.isOdd -> levels[depth].prepend(node.`val`)
                depth.isEven -> levels[depth].append(node.`val`)
            }

            node.left?.let { queue.offer(it to depth + 1) }
            node.right?.let { queue.offer(it to depth + 1) }
        }

        return levels
    }
}

class SolutionTwo {
    /**
     * This solution uses the solution from #102, and then reverses every other level.
     * Time: O(n)
     * Space: O(n)
     */
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> = root.levels()
        .mapIndexed { depth, level ->
            if (depth.isOdd) level.reversed() else level
        }
}

class SolutionThree {
    /**
     * Same as [SolutionTwo], but uses a bit less space by reversing mutable lists in-place.
     * Time: O(n)
     * Space: O(n)
     */
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> = levelOrder(root)
        .mapIndexed { depth, level ->
            if (depth.isOdd)
                level.reverse()

            level
        }

    private fun levelOrder(
        root: TreeNode?,
        depth: Int = 0,
        values: MutableList<MutableList<Int>> = arrayListOf()
    ): MutableList<MutableList<Int>> {

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
