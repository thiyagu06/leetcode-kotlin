package leetcode.medium._513_find_bottom_left_tree_value

import datastructures.tree.TreeNode
import datastructures.tree.height
import datastructures.tree.levels
import java.util.ArrayDeque
import java.util.Queue

/**
 * 513 - https://leetcode.com/problems/find-bottom-left-tree-value/
 */
class Solution {
    /**
     * Use modified BFS to get the nodes by depth, then take the first node of the last row.
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun findBottomLeftValue(root: TreeNode?): Int {
        val rows = root!!.nodesByDepth()    // Problem guarantees root is not null
        return rows.asSequence().last().first()
    }

    private fun TreeNode.nodesByDepth(): List<List<Int>> {
        val rows: MutableList<MutableList<Int>> = arrayListOf()

        val queue: Queue<Pair<TreeNode, Int>> = ArrayDeque()
        queue.offer(this to 0)

        while (queue.isNotEmpty()) {
            val (node, depth) = queue.poll()

            /* add to rows */
            if (rows.size <= depth) {
                rows += arrayListOf<Int>()
            }
            rows[depth].add(node.`val`)

            node.left?.let { queue.offer(node.left!! to depth + 1) }
            node.right?.let { queue.offer(node.right!! to depth + 1) }
        }

        return rows
    }
}

class SolutionTwo {
    /**
     * Using the TreeNode extension function
     */
    fun findBottomLeftValue(root: TreeNode?): Int = root.levels()
        .asSequence()
        .last()
        .first()
}

class SolutionThree {
    /**
     * Use modified depth-aware BFS.
     * Improves SolutionTwo - we don't need to store all nodes in `levels()`. Still O(n) because of queue.
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun findBottomLeftValue(root: TreeNode?): Int {
        var maxDepth = 0
        var bottomLeft = root!!.`val`   // Guaranteed to not be null

        val queue: Queue<Pair<TreeNode, Int>> = ArrayDeque()
        queue.offer(root to 0)

        while (queue.isNotEmpty()) {
            val (node, depth) = queue.poll()

            /* First encountered at lowest level is the bottom left */
            if (depth > maxDepth) {
                maxDepth++
                bottomLeft = node.`val`
            }

            node.left?.let { queue.offer(node.left!! to depth + 1) }
            node.right?.let { queue.offer(node.right!! to depth + 1) }
        }

        return bottomLeft
    }
}

class SolutionFour {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun findBottomLeftValue(root: TreeNode?): Int {
        val treeHeight = root!!.height      // root guaranteed to not be null
        return findLeftmostLeafAtDepth(root, treeHeight, 0)!!
    }

    private fun findLeftmostLeafAtDepth(root: TreeNode?, treeHeight: Int, depth: Int = 0): Int? {
        root ?: return null

        if (depth == treeHeight)
            return root.`val`

        return findLeftmostLeafAtDepth(root.left, treeHeight, depth + 1)
            ?: findLeftmostLeafAtDepth(root.right, treeHeight, depth + 1)
    }
}
