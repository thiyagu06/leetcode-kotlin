package leetcode.easy._687_longest_univalue_path

import datastructures.tree.TreeNode

/**
 * TODO - REVIEW
 * Avoid global var or repetition w/ lambda: http://tinyurl.com/y8b7qd4z
 *
 * 687 - https://leetcode.com/problems/longest-univalue-path/
 */
class Solution {
    fun longestUnivaluePath(root: TreeNode?): Int =
        root?.let {
            val sub = maxOf(longestUnivaluePath(root.left), longestUnivaluePath(root.right))
            maxOf(sub, helper(root.left, root.`val`) + helper(root.right, root.`val`))
        } ?: 0

    private fun helper(root: TreeNode?, parentVal: Int): Int =
        root?.let {
            if (root.`val` == parentVal)
                1 + maxOf(helper(root.left, parentVal), helper(root.right, parentVal))
            else 0
        } ?: 0
}

class IntWrapper(var value: Int = 0)
class Solution2 {

    fun longestUnivaluePath(root: TreeNode?): Int {
        val ans = IntWrapper()
        arrowLength(root, ans)
        return ans.value
    }

    private fun arrowLength(node: TreeNode?, ans: IntWrapper): Int {
        if (node == null) return 0
        val left = arrowLength(node.left, ans)
        val right = arrowLength(node.right, ans)
        var arrowLeft = 0
        var arrowRight = 0

        if (node.left != null && node.left!!.`val` == node.`val`) {
            arrowLeft += left + 1
        }
        if (node.right != null && node.right!!.`val` == node.`val`) {
            arrowRight += right + 1
        }
        ans.value = maxOf(ans.value, arrowLeft + arrowRight)
        return maxOf(arrowLeft, arrowRight)
    }
}

