package leetcode.easy._687_longest_univalue_path

import datastructures.tree.TreeNode

/**
 * TODO - REVIEW
 *
 * 687 - https://leetcode.com/problems/longest-univalue-path/
 */
class Solution {
    fun longestUnivaluePath(root: TreeNode?): Int {
        root ?: return 0

        return maxOf(
            arrowLength(root.left, root.`val`) + arrowLength(root.right, root.`val`),
            longestUnivaluePath(root.left),
            longestUnivaluePath(root.right)
        )
    }

    private fun arrowLength(node: TreeNode?, parentVal: Int): Int = when {
        node == null -> 0
        node.`val` != parentVal -> 0
        else -> 1 + maxOf(
            arrowLength(node.left, parentVal),
            arrowLength(node.right, parentVal)
        )
    }
}

class SolutionTwo {

    private class IntWrapper(var value: Int = 0)

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

class SolutionThree {
    /**
     * Avoid global var or repetition w/ nested function (or just a private function like [Solution]): http://tinyurl.com/y8b7qd4z
     * Time: O(?)
     * Space: O(?)
     */
    fun longestUnivaluePath(root: TreeNode?): Int {

        fun arrowLength(node: TreeNode?, parentVal: Int?): Int = when {
            node == null -> 0
            node.`val` != parentVal -> 0
            else -> 1 + maxOf(
                arrowLength(node.left, node.`val`),
                arrowLength(node.right, node.`val`)
            )
        }

        root ?: return 0

        val maxPathRootedHere = arrowLength(root.left, root.`val`) + arrowLength(root.right, root.`val`)
        return maxOf(
            maxPathRootedHere,
            longestUnivaluePath(root.left),
            longestUnivaluePath(root.right)
        )
    }
}