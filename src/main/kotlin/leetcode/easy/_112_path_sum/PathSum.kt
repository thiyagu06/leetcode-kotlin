package leetcode.easy._112_path_sum

import datastructures.tree.TreeNode
import datastructures.tree.isLeaf

/**
 * 112 - https://leetcode.com/problems/path-sum/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        root ?: return false

        if (root.`val` == sum && root.isLeaf) return true

        return hasPathSum(root.left, sum - root.`val`) || hasPathSum(root.right, sum - root.`val`)
    }
}

class SolutionTwo {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun hasPathSum(root: TreeNode?, sum: Int): Boolean = when {
        root == null -> false
        root.isLeaf -> sum - root.`val` == 0
        else -> hasPathSum(root.left, sum - root.`val`) ||
                hasPathSum(root.right, sum - root.`val`)
    }
}

class SolutionThree {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun hasPathSum(root: TreeNode?, sum: Int, currentPathSum: Int = 0): Boolean = when {
        root == null -> false
        (currentPathSum + root.`val`) == sum && root.isLeaf -> true
        else -> hasPathSum(root.left, sum, currentPathSum + root.`val`) ||
                hasPathSum(root.right, sum, currentPathSum + root.`val`)
    }
}
