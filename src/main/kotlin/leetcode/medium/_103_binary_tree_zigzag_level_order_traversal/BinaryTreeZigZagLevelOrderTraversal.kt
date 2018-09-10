package leetcode.medium._103_binary_tree_zigzag_level_order_traversal

import datastructures.tree.TreeNode
import extensions.lists.append
import extensions.lists.prepend
import extensions.math.isEven
import extensions.math.isOdd
import leetcode.medium._102_binary_tree_level_order_traversal.BFSSolution
import java.util.*

/**
 * 103 - https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
class Solution {

    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun zigzagLevelOrder(root: TreeNode?,
                         values: MutableList<MutableList<Int>> = arrayListOf()): List<List<Int>> {

        root ?: return values

        val queue: Queue<Pair<TreeNode, Int>> = ArrayDeque<Pair<TreeNode, Int>>()
        queue.add(Pair(root, 0))

        while (queue.isNotEmpty()) {
            val (node, depth) = queue.remove()!!

            when {
                depth > values.lastIndex -> values += arrayListOf(node.`val`)
                depth.isOdd -> values[depth].prepend(node.`val`)
                depth.isEven -> values[depth].append(node.`val`)
            }

            node.left?.let { queue.add(Pair(it, depth + 1)) }
            node.right?.let { queue.add(Pair(it, depth + 1)) }
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
            BFSSolution().levelOrder(root)
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
