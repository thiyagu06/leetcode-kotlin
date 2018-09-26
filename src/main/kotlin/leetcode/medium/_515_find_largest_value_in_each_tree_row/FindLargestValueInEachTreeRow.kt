package leetcode.medium._515_find_largest_value_in_each_tree_row

import datastructures.tree.TreeNode
import java.util.*

/**
 * 515 - https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 */
class Solution {
    /**
     * BFS
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun largestValues(root: TreeNode?): List<Int> {
        root ?: return emptyList()

        val treeLevels = hashMapOf<Int, List<Int>>()
        bfs(root) { (node, depth) ->
            treeLevels[depth] = (treeLevels[depth] ?: emptyList()) + node.`val`
        }

        return treeLevels.values.map { it.max()!! }
    }

    /**
     * @param visit Lambda that accepts a pair containing a TreeNode and its depth in the tree
     */
    private fun bfs(root: TreeNode?, visit: (Pair<TreeNode, Int>) -> Unit) {
        root ?: return

        val queue: Queue<Pair<TreeNode, Int>> = ArrayDeque<Pair<TreeNode, Int>>()
        queue.add(Pair(root, 0))

        while (queue.isNotEmpty()) {
            val (node, depth) = queue.remove()!!
            visit(node to depth)
            node.left?.let {
                queue.add(Pair(it, depth + 1))
            }
            node.right?.let {
                queue.add(Pair(it, depth + 1))
            }
        }
    }
}

class Solution2 {
    /**
     * DFS + Hashing
     *
     * Time: O(n)
     * Space: O(m)
     */
    fun largestValues(root: TreeNode?): List<Int> = valuesByDepth(root).values.map { it.max()!! }

    fun valuesByDepth(root: TreeNode?): Map<Int, List<Int>> {
        val treeValues = hashMapOf<Int, List<Int>>()
        valuesByDepth(root, depth = 0, treeValues = treeValues)
        return treeValues
    }

    private fun valuesByDepth(root: TreeNode?, depth: Int = 0, treeValues: MutableMap<Int, List<Int>> = hashMapOf()) {
        root ?: return

        valuesByDepth(root.left, depth + 1, treeValues)
        treeValues[depth] = (treeValues[depth] ?: emptyList()) + root.`val`
        valuesByDepth(root.right, depth + 1, treeValues)
    }
}