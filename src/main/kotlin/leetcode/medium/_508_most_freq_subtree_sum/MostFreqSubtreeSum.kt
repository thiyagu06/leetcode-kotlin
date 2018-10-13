package leetcode.medium._508_most_freq_subtree_sum

import datastructures.tree.TreeNode
import extensions.iterable.frequencyMap

/**
 * 508 - https://leetcode.com/problems/most-frequent-subtree-sum/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun findFrequentTreeSum(root: TreeNode?): IntArray {
        // Get all the subtree sums.
        val subtreeSums = arrayListOf<Int>()
        findAllSubtreeSums(root, subtreeSums)

        // Map each sum to the frequency amongst the subtree sums
        val subtreeSumFreqs = subtreeSums.frequencyMap()
        val maxFreq = subtreeSumFreqs.values.max() ?: return intArrayOf()
        return subtreeSumFreqs.filter { (_, freq) ->
            freq == maxFreq
        }.keys.toIntArray()
    }

    internal fun findAllSubtreeSums(root: TreeNode?, sums: MutableList<Int>): Int? {
        if (root == null) {
            return null
        }
        val leftSubtreeSum = findAllSubtreeSums(root.left, sums)
        val rightSubtreeSum = findAllSubtreeSums(root.right, sums)
        val rootSum = root.`val` + (leftSubtreeSum ?: 0) + (rightSubtreeSum ?: 0)
        sums += rootSum
        return rootSum
    }
}