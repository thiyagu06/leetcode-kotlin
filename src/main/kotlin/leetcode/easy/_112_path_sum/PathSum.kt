package leetcode.easy._112_path_sum

import datastructures.tree.TreeNode
import datastructures.tree.isLeaf

/**
 * 112 - https://leetcode.com/problems/path-sum/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        root ?: return false

        val value = root.`val`
        if (sum - value == 0 && root.isLeaf) {
            return true
        }

        return hasPathSum(root.left, sum - value) || hasPathSum(root.right, sum - value)
    }
}
