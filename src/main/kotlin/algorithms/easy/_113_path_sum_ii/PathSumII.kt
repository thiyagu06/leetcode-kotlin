package algorithms.easy._113_path_sum_ii

import datastructures.tree.TreeNode
import datastructures.tree.rootToLeafPaths

/**
 * 113 - https://leetcode.com/problems/path-sum-ii/description/
 *
 * @author nrojiani
 * @date 11/19/17
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> =
            root.rootToLeafPaths().filter { it.sum() == sum }
}