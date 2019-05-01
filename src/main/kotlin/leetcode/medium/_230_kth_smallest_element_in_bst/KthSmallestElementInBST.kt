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
    fun kthSmallest(root: TreeNode?, k: Int): Int = dfs(root, k)!!      // Guaranteed k is valid

    private fun dfs(
        node: TreeNode?,
        k: Int,
        visited: MutableList<Int> = arrayListOf()
    ): Int? {
        node ?: return null

        // Visit left side and return kth smallest if found
        dfs(node.left, k, visited)?.let { return it }

        // Add node to visited; if kth element, return it
        visited += node.`val`
        if (visited.size == k) return visited.last()

        // Visit right side and return kth smallest if found
        return dfs(node.right, k, visited)
    }
}