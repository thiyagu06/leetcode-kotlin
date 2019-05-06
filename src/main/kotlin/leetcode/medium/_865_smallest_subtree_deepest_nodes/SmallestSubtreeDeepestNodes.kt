package leetcode.medium._865_smallest_subtree_deepest_nodes

import datastructures.tree.TreeNode
import kotlin.math.max

/**
 * 865 - https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 */
class Solution {
    /**
     * http://tinyurl.com/y752avkg
     * Time: O(n)
     * Space: O(n)
     */
    fun subtreeWithAllDeepest(root: TreeNode?): TreeNode? {
        return findDeepest(root).first
    }

    private fun findDeepest(root: TreeNode?): Pair<TreeNode?, Int> {
        root ?: return (null to 0)

        val (deepestLeftNode, depthL) = findDeepest(root.left)
        val (deepestRightNode, depthR) = findDeepest(root.right)

        val deepestNode: TreeNode? = when {
            depthL == depthR -> root
            depthL > depthR -> deepestLeftNode
            else -> deepestRightNode
        }

        return (deepestNode to max(depthL, depthR) + 1)
    }
}

class SolutionTwo {

    private var deepestDepth: Int = 0
    private var result: TreeNode? = null

    /**
     * http://tinyurl.com/y9sywqxr
     * Time: O(n)
     * Space: O(n)
     */
    fun subtreeWithAllDeepest(root: TreeNode?): TreeNode? {
        dfs(root, 0)
        return result
    }

    private fun dfs(root: TreeNode?, depth: Int): Int {
        root ?: return depth - 1

        val leftDepth = dfs(root.left, depth + 1)
        val rightDepth = dfs(root.right, depth + 1)

        val currentDepth = max(leftDepth, rightDepth)
        deepestDepth = max(deepestDepth, currentDepth)

        // Set result only if both children are at deepest depth
        if (leftDepth == deepestDepth && rightDepth == deepestDepth) {
            result = root
        }

        return currentDepth
    }
}