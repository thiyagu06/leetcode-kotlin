package leetcode.easy._108_convert_sorted_array_to_bst

import datastructures.tree.TreeNode
import extensions.ranges.mid

/**
 * 108 - https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun sortedArrayToBST(nums: IntArray, indices: IntRange = nums.indices, tree: TreeNode? = null): TreeNode? =
        when (indices.count()) {
            0 -> tree
            else -> {
                val midIndex = indices.mid
                TreeNode(nums[midIndex]).apply {
                    left = sortedArrayToBST(nums, (indices.start until midIndex), tree?.left)
                    right = sortedArrayToBST(nums, ((midIndex + 1)..indices.endInclusive), tree?.right)
                }
            }
        }
}
