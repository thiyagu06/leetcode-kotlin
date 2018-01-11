package algorithms.medium._098_validate_bst

import datastructures.tree.TreeNode
import datastructures.tree.hasLeft
import datastructures.tree.hasRight

/**
 * 98 - https://leetcode.com/problems/validate-binary-search-tree/description/
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
