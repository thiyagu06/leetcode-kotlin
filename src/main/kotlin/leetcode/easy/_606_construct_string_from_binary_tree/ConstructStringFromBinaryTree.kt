package leetcode.easy._606_construct_string_from_binary_tree

import datastructures.tree.TreeNode
import datastructures.tree.hasLeft
import datastructures.tree.hasRight
import datastructures.tree.isLeaf

/**
 * 606 - https://leetcode.com/problems/construct-string-from-binary-tree/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun tree2str(t: TreeNode?): String = when {
        t == null -> ""
        t.isLeaf -> "${t.`val`}"
        t.hasLeft && !t.hasRight -> "${t.`val`}(${tree2str(t.left)})"
        !t.hasLeft && t.hasRight -> "${t.`val`}()(${tree2str(t.right)})"
        else -> "${t.`val`}(${tree2str(t.left)})(${tree2str(t.right)})"
    }

}

class SolutionTwo {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun tree2str(t: TreeNode?): String =
        if (t == null) ""
        else ("${t.`val`}"
            + (if (!t.isLeaf) "(${tree2str(t.left)})" else "")
            + (if (t.hasRight) "(${tree2str(t.right)})" else ""))
}
