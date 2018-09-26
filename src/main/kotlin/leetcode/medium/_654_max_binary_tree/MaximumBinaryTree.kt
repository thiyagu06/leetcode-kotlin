package leetcode.medium._654_max_binary_tree

import datastructures.tree.TreeNode

/**
 * 654 - https://leetcode.com/problems/maximum-binary-tree/
 */
class Solution {
    /**
     * See https://leetcode.com/problems/maximum-binary-tree/solution/
     * Time (Worst): O(n^2)
     * Time (Avg): O(n log n)
     * Space: O(n)
     */
    fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
        if (nums.isEmpty()) return null

        val (maxIndex, max) = nums.withIndex().maxBy { it.value }!!

        val leftIndexed = nums.withIndex().takeWhile { it.index < maxIndex }
        val rightIndexed = nums.withIndex().dropWhile { it.index <= maxIndex }

        return TreeNode(max).apply {
            left = constructMaximumBinaryTree(leftIndexed.map { it.value }.toIntArray())
            right = constructMaximumBinaryTree(rightIndexed.map { it.value }.toIntArray())
        }
    }
}