package leetcode.easy._606_construct_string_from_binary_tree

import datastructures.tree.TreeNode
import datastructures.tree.hasLeft
import datastructures.tree.hasRight
import datastructures.tree.hasTwoChildren

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

        return "${t.`val`}" + when {
            t.hasTwoChildren -> "(${ tree2str(t.left)})" + "(${tree2str(t.right)})"
            t.hasLeft        -> "(${ tree2str(t.left)})"
            t.hasRight       -> "()"                     + "(${tree2str(t.right)})"
            else             -> ""
        }
    }
}

