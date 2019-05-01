package leetcode.medium._508_most_freq_subtree_sum

import datastructures.tree.buildTree
import org.junit.Assert.assertArrayEquals
import org.junit.Test

class MostFreqSubtreeSumTest {

    private val solution = Solution()

    @Test
    fun findFrequentTreeSum() {
        assertArrayEquals(intArrayOf(), solution.findFrequentTreeSum(null))
        assertArrayEquals(intArrayOf(2, -3, 4), solution.findFrequentTreeSum(buildTree(5, 2, -3)))
        assertArrayEquals(intArrayOf(2), solution.findFrequentTreeSum(buildTree(5, 2, -5)))
        assertArrayEquals(intArrayOf(-3, 2), solution.findFrequentTreeSum(buildTree(5, null, -3)))
        assertArrayEquals(intArrayOf(2), solution.findFrequentTreeSum(buildTree(5, 2, -3, null, null, 1, 4)))
        assertArrayEquals(intArrayOf(2, -3, 4, 5), solution.findFrequentTreeSum(buildTree(1, null, 5, 2, -3)))
    }
}