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
    fun kthSmallest(root: TreeNode?, k: Int, traversed: Int = 0): Int {
        val kth = traverseFirstK(root, k)
        return kth!!
    }

    private fun traverseFirstK(root: TreeNode?, k: Int, traversed: MutableList<Int> = arrayListOf()): Int? {
        if (k <= 0 || root == null) {
            return null
        }

        val leftResult = traverseFirstK(root.left, k, traversed)
        if (leftResult != null)
            return leftResult

        traversed += root.`val`
        if (traversed.size == k) {
            return traversed.last()
        }

        val rightResult = traverseFirstK(root.right, k, traversed)
        if (rightResult != null)
            return rightResult

        return null
    }
}
