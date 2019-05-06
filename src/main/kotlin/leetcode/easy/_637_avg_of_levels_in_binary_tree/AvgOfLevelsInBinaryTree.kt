package leetcode.easy._637_avg_of_levels_in_binary_tree

import datastructures.tree.TreeNode
import datastructures.tree.levels

/**
 * 637 - https://leetcode.com/problems/average-of-levels-in-binary-tree/
 */
class SolutionDFS {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun averageOfLevels(root: TreeNode?): DoubleArray =
        collectTreeRows(root).map { level ->
            level.sumByDouble { it.toDouble() } / level.size
        }.toDoubleArray()

    private fun collectTreeRows(
        root: TreeNode?,
        depth: Int = 0,
        treeRows: MutableList<MutableList<Int>> = arrayListOf()
    ): List<List<Int>> {
        root ?: return treeRows

        if (depth > treeRows.lastIndex) {
            treeRows.add(arrayListOf(root.`val`))
        } else {
            treeRows[depth].add(root.`val`)
        }

        collectTreeRows(root.left, depth + 1, treeRows)
        collectTreeRows(root.right, depth + 1, treeRows)

        return treeRows
    }
}

class SolutionBFS {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun averageOfLevels(root: TreeNode?): DoubleArray =
        root?.levels()?.map { level ->
            level.sumByDouble { it.toDouble() } / level.size
        }?.toDoubleArray() ?: doubleArrayOf()
}