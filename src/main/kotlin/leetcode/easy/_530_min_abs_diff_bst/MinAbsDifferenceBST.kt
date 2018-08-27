package leetcode.easy._530_min_abs_diff_bst

import datastructures.tree.TreeNode
import datastructures.tree.collect
import kotlin.math.abs

/**
 * 530 - https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
 */
class Solution {
    /**
     * Time: O(n log n)
     * Space: O(n)
     */
    fun getMinimumDifference(root: TreeNode?, parentValue: Int? = null): Int {
        root ?: return 0

        val sortedValues = root.collect(arrayListOf()).sorted()
        return (1..sortedValues.lastIndex).fold(Int.MAX_VALUE) { min, i ->
            val currMin = abs(sortedValues[i] - sortedValues[i - 1])
            if (currMin <= min) currMin else min
        }
    }
}
