package leetcode.easy._108_convert_sorted_array_to_bst

import datastructures.tree.TreeNode

/**
 * 108 - https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
class Solution {
    /**
     * Time: O(n) - array copying
     * Space: O(n) - recursion & array copying
     */
    fun sortedArrayToBST(nums: IntArray): TreeNode? = when (nums.size) {
        0 -> null
        1 -> TreeNode(nums.first())
        /* 2 elements: make the smaller the left child */
        2 -> TreeNode(nums[1]).apply {
            left = TreeNode(nums[0])
        }
        /* 3 elements: make the middle the root */
        3 -> TreeNode(nums[1]).apply {
            left = TreeNode(nums[0])
            right = TreeNode(nums[2])
        }
        else -> {
            /* Choose median as root */
            val mid = nums.size / 2
            val root = TreeNode(nums[mid]).apply {
                left = sortedArrayToBST(nums.sliceArray(0 until mid))
                right = sortedArrayToBST(nums.sliceArray((mid + 1)..nums.lastIndex))
            }
            root
        }
    }
}


class SolutionAlt {
    /**
     * Use IntRange of indices instead of copying array, compress base cases
     * Time: O(n)
     * Space: O(n) - recursive stack space
     */
    fun sortedArrayToBST(nums: IntArray, indexRange: IntRange = 0..nums.lastIndex): TreeNode? =
            when (indexRange.count()) {
                0 -> null
                1 -> TreeNode(nums[indexRange.start])
                else -> {
                    val mid = (indexRange.start + indexRange.endInclusive + 1) / 2
                    val leftRange = indexRange.start until mid
                    val rightRange = (mid + 1)..indexRange.endInclusive
                    val root = TreeNode(nums[mid]).apply {
                        left = sortedArrayToBST(nums, leftRange)
                        right = sortedArrayToBST(nums, rightRange)
                    }
                    root
                }
            }
}
