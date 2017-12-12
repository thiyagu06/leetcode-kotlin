package algorithms.medium._103_binary_tree_zigzag_level_order_traversal

import algorithms.medium._102_binary_tree_level_order_traversal.LevelOrderSolution
import append
import datastructures.queue.ListQueue
import datastructures.tree.TreeNode
import extensions.isEven
import extensions.isOdd
import prepend

/**
 * 103 -
 *
 * @author nrojiani
 * @date 11/25/17
 */
class Solution {

    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun zigzagLevelOrder(root: TreeNode?,
                         values: MutableList<MutableList<Int>> = arrayListOf()): List<List<Int>> {

        root ?: return values

        val queue = ListQueue<Pair<TreeNode, Int>>()    // Pair: TreeNode & its depth (level - 1)
        queue.enqueue(Pair(root, 0))

        while (queue.isNotEmpty()) {
            val (node, depth) = queue.dequeue()!!

            when {
                depth > values.lastIndex -> values += arrayListOf(node.`val`)
                depth.isOdd -> values[depth].prepend(node.`val`)
                depth.isEven -> values[depth].append(node.`val`)
            }

            node.left?.let { queue.enqueue(Pair(it, depth + 1)) }
            node.right?.let { queue.enqueue(Pair(it, depth + 1)) }
        }

        return values
    }
}

class SimpleSolution1 {
    /**
     * This solution uses the solution from #102, and then reverses every other level.
     * Time: O(n)
     * Space: O(n)
     */
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> =
            LevelOrderSolution().levelOrder(root)
                    .mapIndexed { depth, values ->
                        if (depth.isOdd) values.reversed() else values
                    }

}

class SimpleSolution2 {
    /**
     * Same as [SimpleSolution1], but uses a bit less space by reversing mutable lists in place.
     * Time: O(n)
     * Space: O(n)
     */
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> = levelOrder(root)
            .mapIndexed { depth, values ->
                if (depth.isOdd)
                    values.reverse()

                values
            }

    private fun levelOrder(root: TreeNode?, depth: Int = 0,
                           values: MutableList<MutableList<Int>> = arrayListOf()): MutableList<MutableList<Int>> {

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
