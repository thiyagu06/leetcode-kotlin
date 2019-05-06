package leetcode.easy._111_min_depth_of_binary_tree

import datastructures.tree.TreeNode
import datastructures.tree.hasLeft
import datastructures.tree.hasRight
import datastructures.tree.hasTwoChildren

/**
 * 111 - https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun minDepth(root: TreeNode?, depth: Int = 1): Int = when {
        root == null -> depth - 1
        root.hasTwoChildren -> minOf(minDepth(root.left, depth + 1), minDepth(root.right, depth + 1))
        root.hasLeft -> minDepth(root.left, depth + 1)
        root.hasRight -> minDepth(root.right, depth + 1)
        else -> depth
    }
}

class SolutionTwo {
    /**
     * Another way to write the solution - same complexity.
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun minDepth(root: TreeNode?): Int = when {
        root == null -> 0
        root.hasTwoChildren -> 1 + minOf(minDepth(root.left), minDepth(root.right))
        root.hasLeft -> 1 + minDepth(root.left)
        root.hasRight -> 1 + minDepth(root.right)
        else -> 1
    }
}
