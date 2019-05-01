package leetcode.medium._508_most_freq_subtree_sum

import datastructures.tree.TreeNode
import datastructures.tree.isLeaf

/**
 * 508 - https://leetcode.com/problems/most-frequent-subtree-sum/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun findFrequentTreeSum(root: TreeNode?): IntArray {
        val sumFreqs: MutableMap<Int, Int> = HashMap()
        findSubtreeSums(root, sumFreqs)

        val maxFreq = sumFreqs.values.max()
        return sumFreqs.filter { (_, freq) -> freq == maxFreq }
            .map { (sum, _) -> sum }
            .toIntArray()
    }

    private fun findSubtreeSums(root: TreeNode?, sumFreqs: MutableMap<Int, Int>): Int = when {
        root == null -> 0
        root.isLeaf -> {
            sumFreqs[root.`val`] = sumFreqs.getOrDefault(root.`val`, 0) + 1
            root.`val`
        }
        else -> {
            val leftSum = findSubtreeSums(root.left, sumFreqs)
            val rightSum = findSubtreeSums(root.right, sumFreqs)
            val subtreeSum = leftSum + rightSum + root.`val`
            sumFreqs[subtreeSum] = sumFreqs.getOrDefault(subtreeSum, 0) + 1
            subtreeSum
        }
    }
}