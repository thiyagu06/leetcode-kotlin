package leetcode.easy._437_path_sum_iii

import datastructures.tree.TreeNode

/**
 * 437 - https://leetcode.com/problems/path-sum-iii/
 */
class Solution {
    fun pathSum(root: TreeNode?, sum: Int, pathStarted: Boolean = false): Int {
        root ?: return 0

        return if (pathStarted) {
            // Must include this node in path if pathStarted.
            val rootSum = if (sum - root.`val` == 0) 1 else 0
            val leftSums = pathSum(root.left, sum - root.`val`, true)
            val rightSums = pathSum(root.right, sum - root.`val`, true)
            rootSum + leftSums + rightSums
        } else {
            // If !pathStarted, can either include or not include.
            val rootSum = pathSum(root, sum, true)
            val leftSums = pathSum(root.left, sum, false)
            val rightSums = pathSum(root.right, sum, false)
            rootSum + leftSums + rightSums
        }
    }
}

class SolutionWithPathSums {
    fun pathSum(root: TreeNode?, sum: Int): Int =
        pathSums(root, sum).count { it == sum }

    private fun pathSums(root: TreeNode?, sum: Int, sums: List<Int> = emptyList()): List<Int> {
        root ?: return emptyList()

        val pathsToRootSums = sums.map { it + root.`val`} + root.`val`

        return pathsToRootSums + pathSums(root.left, sum, pathsToRootSums) + pathSums(root.right, sum, pathsToRootSums)
    }
}

class SolutionWithPathLists {
    fun pathSum(root: TreeNode?, sum: Int): Int = pathsFrom(root).count { it.sum() == sum }

    internal fun pathsFrom(root: TreeNode?, paths: List<List<Int>> = listOf()): List<List<Int>> =
        root?.let {
            val pathsToRoot = paths.map { path -> path + root.`val` } + listOf(listOf(root.`val`))
            return pathsToRoot + pathsFrom(root.left, pathsToRoot) + pathsFrom(root.right, pathsToRoot)
    } ?: emptyList()
}