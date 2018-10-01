package leetcode.medium._113_path_sum_ii

import datastructures.tree.TreeNode
import datastructures.tree.isLeaf
import datastructures.tree.rootToLeafPaths

/**
 * 113 - https://leetcode.com/problems/path-sum-ii/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> = root.rootToLeafPaths().filter { it.sum() == sum }
}

class SolutionTwo {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
        val kSumPaths = arrayListOf<List<Int>>()
        findKSumPaths(root, sum, arrayListOf(), kSumPaths)
        return kSumPaths
    }

    private fun findKSumPaths(
        node: TreeNode?,
        k: Int,
        currentPath: MutableList<Int>,
        kSumPaths: MutableList<List<Int>>
    ) {
        when {
            node == null -> return
            k - node.`val` == 0 && node.isLeaf -> {
                currentPath += node.`val`
                kSumPaths += currentPath
            }
            else -> {
                findKSumPaths(
                    node.left,
                    k - node.`val`,
                    (currentPath + node.`val`).toMutableList(),
                    kSumPaths
                )

                findKSumPaths(
                    node.right,
                    k - node.`val`,
                    (currentPath + node.`val`).toMutableList(),
                    kSumPaths
                )
            }
        }
    }
}
