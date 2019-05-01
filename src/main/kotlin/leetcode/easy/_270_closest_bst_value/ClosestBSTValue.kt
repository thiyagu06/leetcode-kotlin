package leetcode.easy._270_closest_bst_value

import datastructures.tree.TreeNode
import kotlin.math.abs

/**
 * 270 - https://leetcode.com/problems/closest-binary-search-tree-value
 */
class Solution {
    fun closestValue(root: TreeNode?, target: Double): Int {
        return closestValue(root!!, target, root.`val`)         // Guaranteed that tree is non-empty
    }

    private fun closestValue(root: TreeNode?, target: Double, closest: Int): Int {
        root ?: return closest

        val newClosest = if (abs(root.`val` - target) < abs(closest - target)) root.`val` else closest

        val leftClosest = closestValue(root.left, target, newClosest)
        val rightClosest = closestValue(root.right, target, newClosest)

        return if (abs(leftClosest - target) <= abs(rightClosest - target)) leftClosest else rightClosest
    }
}