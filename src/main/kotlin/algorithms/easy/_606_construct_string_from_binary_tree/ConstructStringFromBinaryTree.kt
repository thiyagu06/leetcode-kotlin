package algorithms.easy._606_construct_string_from_binary_tree

import datastructures.tree.TreeNode
import datastructures.tree.hasLeft
import datastructures.tree.hasTwoChildren
import datastructures.tree.isLeaf

/**
 * 606 - https://leetcode.com/problems/construct-string-from-binary-tree/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun tree2str(t: TreeNode?): String {
        t ?: return ""

        val rootValStr = "${t.`val`}"
        return when {
            t.isLeaf -> rootValStr
            t.hasTwoChildren -> "$rootValStr(${tree2str(t.left)})(${tree2str(t.right)})"
            t.hasLeft -> "$rootValStr(${tree2str(t.left)})"
            else -> "$rootValStr()(${tree2str(t.right)})"
        }
    }
}

