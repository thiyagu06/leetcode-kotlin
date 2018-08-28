package algorithms.easy._111_min_depth_of_binary_tree

import datastructures.tree.TreeNode
import datastructures.tree.hasLeft
import datastructures.tree.hasRight
import datastructures.tree.hasTwoChildren

/**
 * 111 - https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun minDepth(root: TreeNode?, depth: Int = 1): Int = when {
        root == null        -> depth - 1
        root.hasTwoChildren -> minOf(minDepth(root.left, depth + 1), minDepth(root.right, depth + 1))
        root.hasLeft        -> minDepth(root.left, depth + 1)
        root.hasRight       -> minDepth(root.right, depth + 1)
        else /* is leaf */  -> depth
    }
}

class AltSolution {
    /**
     * Another way to write the solution - same complexity.
     * 
     * Time: O(n)
     * Space: O(n)
     */
    fun minDepth(root: TreeNode?): Int {
        root ?: return 0

        return when {
            root.hasTwoChildren -> 1 + minOf(minDepth(root.left), minDepth(root.right))
            root.hasLeft -> 1 + minDepth(root.left)
            root.hasRight -> 1 + minDepth(root.right)
            else -> 1
        }
    }
}
