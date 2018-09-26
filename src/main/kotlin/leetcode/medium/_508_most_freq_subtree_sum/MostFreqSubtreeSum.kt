package leetcode.medium._508_most_freq_subtree_sum

import datastructures.tree.TreeNode

/**
 * 508 - https://leetcode.com/problems/most-frequent-subtree-sum/
 */
class Solution {
    fun findFrequentTreeSum(root: TreeNode?): IntArray {
        val subtreeSums = hashMapOf<Int, Int>()
        collectSubtreeSums(root, subtreeSums)

        val mostFrequentCount = subtreeSums.values.maxBy { it }
        return subtreeSums.filter { (sum, count) ->
            count == mostFrequentCount
        }.map {
            (sum, count) -> sum
        }.toIntArray()
    }

    private fun collectSubtreeSums(root: TreeNode?, sums: MutableMap<Int, Int> = hashMapOf()): Int {
        root ?: return 0

        val subtreeSum = root.`val` + collectSubtreeSums(root.left, sums) + collectSubtreeSums(root.right, sums)
        sums[subtreeSum] = (sums[subtreeSum] ?: 0) + 1
        return subtreeSum
    }
}