package leetcode.easy._226_invert_binary_tree

import datastructures.tree.TreeNode
import datastructures.tree.children

/**
 * 226 - https://leetcode.com/problems/invert-binary-tree/description/
 */
class Solution {
    /**
     * Does not modify input tree.
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun invertTree(root: TreeNode?): TreeNode? {
        root ?: return null

        val mirrored: TreeNode? = TreeNode(root.`val`)
        mirrored?.left = invertTree(root.right)
        mirrored?.right = invertTree(root.left)

        return mirrored
    }
}

class SolutionTwo {
    /**
     * Does not modify input tree.
     * Same as Solution1, but uses Kotlin's `apply()` scoping function.
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun invertTree(root: TreeNode?): TreeNode? {
        root ?: return null

        return TreeNode(root.`val`).apply {
            left = invertTree(root.right)
            right = invertTree(root.left)
        }
    }
}

class SolutionThree {
    /**
     * Modifies input tree.
     *
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

class SolutionFour {
    /**
     * Modifies input tree.
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun invertTree(root: TreeNode?): TreeNode? = root?.apply {
        val tmpLeft = left
        left = invertTree(right)
        right = invertTree(tmpLeft)
    }
}

class SolutionFive {
    /**
     * Modifies input tree.
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun invertTree(root: TreeNode?): TreeNode? = root?.apply {
        val (l, r) = children
        left = invertTree(r)
        right = invertTree(l)
    }
}