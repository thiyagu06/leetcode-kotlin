package algorithms.easy._226_invert_binary_tree

import datastructures.tree.TreeNode
import datastructures.tree.children

/**
 * 226 - https://leetcode.com/problems/invert-binary-tree/description/
 */
class Solution1 {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun invertTree(root: TreeNode?): TreeNode? {
        root ?: return null

        val invertedLeft = invertTree(root.left)
        val invertedRight = invertTree(root.right)

        root.left = invertedRight
        root.right = invertedLeft

        return root
    }
}

class Solution2 {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun invertTree(root: TreeNode?): TreeNode? = root?.apply {
        val tmpLeft = left
        left = invertTree(right)
        right = invertTree(tmpLeft)
    }
}

class Solution3 {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun invertTree(root: TreeNode?): TreeNode? = root?.apply {
        val (l, r) = Pair(left, right)
        left = invertTree(r)
        right = invertTree(l)
    }
}