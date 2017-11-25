package algorithms.medium._098_validate_bst

import datastructures.tree.TreeNode
import datastructures.tree.hasLeft
import datastructures.tree.hasRight

/**
 * 98 - https://leetcode.com/problems/validate-binary-search-tree/description/
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * - The left subtree of a node contains only nodes with keys **less than** the node's key.
 * - The right subtree of a node contains only nodes with keys **greater than** the node's key.
 * - Both the left and right subtrees must also be binary search trees.
 *
 * @author nrojiani
 * @date 11/23/17
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun isValidBST(root: TreeNode?, validRange: IntRange = (Int.MIN_VALUE..Int.MAX_VALUE)): Boolean {
        root ?: return true

        // check for overflow
        if (root.`val` == Int.MIN_VALUE && root.hasLeft) return false
        if (root.`val` == Int.MAX_VALUE && root.hasRight) return false

        val leftSubtreeRange = validRange.first..(root.`val` - 1)
        val rightSubtreeRange = (root.`val` + 1)..validRange.last

        return root.`val` in validRange
            && isValidBST(root.left, leftSubtreeRange)
            && isValidBST(root.right, rightSubtreeRange)
    }
}