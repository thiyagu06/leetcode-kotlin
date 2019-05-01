package leetcode.easy._437_path_sum_iii

import datastructures.tree.TreeNode
import datastructures.tree.allDownwardPaths

/**
 * 437 - https://leetcode.com/problems/path-sum-iii/
 */
class Solution {
    /**
     * Time: O(?)
     * Space: O(?)
     */
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

class SolutionTwo {
    /**
     * Exceeds Memory Limit.
     * Using [TreeNode.allDownwardPaths].
     * Time: O(?)
     * Space: O(?)
     */
    fun pathSum(root: TreeNode?, sum: Int): Int {
        root ?: return 0

        val allPaths = root.allDownwardPaths()
        return allPaths.asSequence()
            .map { it.sum() }
            .count { it == sum }
    }
}

class SolutionThree {
    /**
     * Collects all path sums.
     * Time: O(?)
     * Space: O(?)
     */
    fun pathSum(root: TreeNode?, sum: Int): Int = collectAllPathSums(root).count { it == sum }

    private fun collectAllPathSums(root: TreeNode?, pathSums: List<Int> = emptyList()): List<Int> {
        root ?: return emptyList()

        val pathsToRootSums = pathSums.map { it + root.`val` } + root.`val`

        return (pathsToRootSums +
                collectAllPathSums(root.left, pathsToRootSums) +
                collectAllPathSums(root.right, pathsToRootSums))
    }
}

class SolutionFour {
    /**
     * Collects all paths from the root node.
     * Time: O(?)
     * Space: O(?)
     */
    fun pathSum(root: TreeNode?, sum: Int): Int = pathsFrom(root).count { it.sum() == sum }

    internal fun pathsFrom(root: TreeNode?, paths: List<List<Int>> = listOf()): List<List<Int>> {
        root ?: return emptyList()
        val pathsToRoot = paths.map { path -> path + root.`val` } + listOf(listOf(root.`val`))
        return pathsToRoot + pathsFrom(root.left, pathsToRoot) + pathsFrom(root.right, pathsToRoot)
    }
}
