package leetcode.easy._501_find_mode_in_bst

import datastructures.tree.TreeNode
import datastructures.tree.collect

/**
 * 501 - https://leetcode.com/problems/find-mode-in-binary-search-tree/
 */
class Solution {
    /**
     * TODO
     * Time: O(?)
     * Space: O(?)
     */
    fun findMode(root: TreeNode?): IntArray {
        val values = root?.collect(arrayListOf()) ?: return intArrayOf()

        val frequencies = values.groupingBy { it }.eachCount()
        val modeFrequency = frequencies.maxBy { (_, freq) -> freq }!!.value

        return frequencies.filter { (_, freq) -> freq == modeFrequency }
            .keys
            .toIntArray()
    }
}
