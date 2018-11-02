package leetcode.medium._098_validate_bst

import datastructures.tree.TreeNode
import datastructures.tree.hasLeft
import datastructures.tree.hasRight

/**
 * 98 - https://leetcode.com/problems/validate-binary-search-tree/
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
                val rightSubtreeRange = root.`val` + 1..validRange.endInclusive

                root.`val` in validRange
                        && isValidBST(root.left, leftSubtreeRange)
                        && isValidBST(root.right, rightSubtreeRange)
            }
        }
}

class SolutionTwo {
    fun isValidBST(
        root: TreeNode?,
        validRange: LongRange = Long.MIN_VALUE..Long.MAX_VALUE
    ): Boolean {
        root ?: return true

        return root.`val` in validRange &&
                isValidBST(root.left, validRange.start until root.`val`) &&
                isValidBST(root.right, (root.`val` + 1L)..validRange.endInclusive)
    }
}
