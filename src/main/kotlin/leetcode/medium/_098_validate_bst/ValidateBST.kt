package leetcode.medium._098_validate_bst

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
    fun isValidBST(root: TreeNode?, validRange: IntRange = (Int.MIN_VALUE..Int.MAX_VALUE)): Boolean =
        when {
            root == null -> true

            // Int Overflow
            root.`val` == Int.MIN_VALUE && root.hasLeft -> false
            root.`val` == Int.MAX_VALUE && root.hasRight -> false

            else -> {
                val leftSubtreeRange = validRange.start until root.`val`
                val rightSubtreeRange = root.`val` + 1 .. validRange.endInclusive

                root.`val` in validRange
                        && isValidBST(root.left, leftSubtreeRange)
                        && isValidBST(root.right, rightSubtreeRange)
            }
        }
}