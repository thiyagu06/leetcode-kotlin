package leetcode.medium._129_sum_root_to_leaf_numbers

import datastructures.tree.TreeNode
import datastructures.tree.isLeaf
import datastructures.tree.rootToLeafPaths

/**
 * 129 - https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun sumNumbers(root: TreeNode?): Int {
        val paths = root.rootToLeafPaths()
        val pathNumbers = paths.map { path ->
            pathNumber(path)
        }
        return pathNumbers.sum()
    }

    private fun pathNumber(path: List<Int>): Int = path.fold("") { acc, digit ->
        acc + "$digit"
    }.toInt()
}

class SolutionTwo {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun sumNumbers(root: TreeNode?, path: String = "", sum: Int = 0): Int = when {
        root == null -> sum
        root.isLeaf -> {
            val rootToLeafPath: String = path + root.`val`
            val rootToLeafNumber = rootToLeafPath.toInt()
            sum + rootToLeafNumber
        }
        else -> sumNumbers(root.left, path + root.`val`, sum) + sumNumbers(root.right, path + root.`val`, sum)
    }
}