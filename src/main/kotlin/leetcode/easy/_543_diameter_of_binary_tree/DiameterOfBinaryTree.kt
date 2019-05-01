package leetcode.easy._543_diameter_of_binary_tree

import datastructures.tree.TreeNode
import datastructures.tree.hasLeft
import datastructures.tree.hasRight
import datastructures.tree.hasTwoChildren
import datastructures.tree.height
import kotlin.math.max

/**
 * 543 - https://leetcode.com/problems/diameter-of-binary-tree/
 */
class Solution {
    /**
     * https://leetcode.com/problems/diameter-of-binary-tree/discuss/101120/
     *
     * Time: O(n log n)
     * Space: O(n)
     */
    fun diameterOfBinaryTree(root: TreeNode?): Int = when {
        root == null -> 0
        root.hasTwoChildren -> {
            val longestLeafToLeafPathThroughRoot = 2 + root.left!!.height + root.right!!.height
            maxOf(
                diameterOfBinaryTree(root.left),
                diameterOfBinaryTree(root.right),
                longestLeafToLeafPathThroughRoot
            )
        }
        root.hasLeft -> diameterOfBinaryTree(root.left) + if (root.left!!.hasTwoChildren) 0 else 1
        root.hasRight -> diameterOfBinaryTree(root.right) + if (root.right!!.hasTwoChildren) 0 else 1
        else -> 0   // leaf
    }
}

class SolutionTwo {
    /**
     * https://leetcode.com/problems/diameter-of-binary-tree/discuss/101120/
     *
     * Time: O(n log n) - actually O(Nh) --> where h is the height of the tree: can be logN or N in case of skew tree. So the worst case time complexity is O(NN)
     * Space: O(n)
     */
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        root ?: return 0

        val diameter = maxDepth(root.left) + maxDepth(root.right)
        val maxSubtreeDiameter = max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right))
        return max(diameter, maxSubtreeDiameter)
    }

    private fun maxDepth(root: TreeNode?): Int {
        root ?: return 0
        return 1 + max(maxDepth(root.left), maxDepth(root.right))
    }
}

class SolutionThree {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    private var maxDiameter = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        dfs(root)
        return maxDiameter
    }

    private fun dfs(node: TreeNode?): Int {
        node ?: return 0

        val left = dfs(node.left)
        val right = dfs(node.right)
        maxDiameter = max(maxDiameter, left + right)
        return if (left > right) left + 1 else right + 1
    }
}