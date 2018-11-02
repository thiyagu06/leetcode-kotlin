package leetcode.easy._872_leaf_similar_trees

import datastructures.tree.TreeNode
import datastructures.tree.isLeaf

/**
 * 872 - https://leetcode.com/problems/leaf-similar-trees
 */
class Solution {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean =
        collectLeaves(root1) == collectLeaves(root2)

    private fun collectLeaves(root: TreeNode?, leaves: MutableList<Int> = arrayListOf()): MutableList<Int> {
        return when {
            root == null -> leaves
            root.isLeaf -> {
                leaves += root.`val`
                leaves
            }
            else -> {
                collectLeaves(root.left, leaves)
                collectLeaves(root.right, leaves)
                leaves
            }
        }
    }
}