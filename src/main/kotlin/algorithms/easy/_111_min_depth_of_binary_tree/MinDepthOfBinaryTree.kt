package algorithms.easy._111_min_depth_of_binary_tree

import datastructures.tree.TreeNode
import datastructures.tree.hasLeft
import datastructures.tree.hasRight
import datastructures.tree.hasTwoChildren

/**
 * 111 - https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * @author nrojiani
 * @date 11/19/17
 */
class Solution {
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
