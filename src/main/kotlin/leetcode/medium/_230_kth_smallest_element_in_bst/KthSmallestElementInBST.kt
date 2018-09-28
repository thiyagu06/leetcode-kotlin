package leetcode.medium._230_kth_smallest_element_in_bst

import datastructures.tree.TreeNode
import datastructures.tree.collect

/**
 * 230 - https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 *
 * Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */
class Solution {
    /**
     * Suboptimal - always traverses entire tree.
     * Time: O(n)
     * Space: O(n)
     */
    fun kthSmallest(root: TreeNode?, k: Int): Int = (root?.collect(arrayListOf()) as ArrayList<Int>)[k - 1]
}

class FollowUpSolution {
    /**
     * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
     * How would you optimize the kthSmallest routine?
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        return traverseFirstK(root, k) ?: throw IllegalArgumentException("Invalid Input - no kth smallest")
    }

    /**
     * Traverse only the first K elements using inorder DFS.
     */
    private fun traverseFirstK(
        node: TreeNode?,
        k: Int,
        visited: MutableList<Int> = arrayListOf()
    ): Int? {
        when {
            node == null -> return null
            visited.size == k -> return visited[k - 1]
            else -> {
                val leftResult = traverseFirstK(node.left, k, visited)
                if (leftResult != null) return leftResult

                visited += node.`val`

                val rightResult = traverseFirstK(node.right, k, visited)
                if (rightResult != null) return rightResult

                return null
            }
        }
    }
}