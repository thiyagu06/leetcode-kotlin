package leetcode.easy._783_min_distance_bst_nodes

import datastructures.tree.TreeNode
import datastructures.tree.collect
import kotlin.math.min

/**
 * 783 - https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
 */
class Solution {
    fun minDiffInBST(root: TreeNode?): Int =
        root.collect().sorted()
            .zipWithNext()
            .fold(Int.MAX_VALUE) { acc, (curr,  next) ->
                min(next - curr, acc)
            }
}
