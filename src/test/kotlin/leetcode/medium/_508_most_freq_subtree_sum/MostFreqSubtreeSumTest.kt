package leetcode.medium._508_most_freq_subtree_sum

import datastructures.tree.buildTree
import org.junit.Test

import org.junit.Assert.*

class MostFreqSubtreeSumTest {

    private val solution = Solution()

    @Test
    fun findFrequentTreeSum() {
        assertArrayEquals(intArrayOf(2, -3, 4), solution.findFrequentTreeSum(buildTree(5, 2, -3)))
        assertArrayEquals(intArrayOf(2), solution.findFrequentTreeSum(buildTree(5, 2, -5)))
        assertArrayEquals(intArrayOf(-3, 2), solution.findFrequentTreeSum(buildTree(5, null, -3)))
        assertArrayEquals(intArrayOf(2), solution.findFrequentTreeSum(buildTree(5, 2, -3, null, null, 1, 4)))
        assertArrayEquals(intArrayOf(2, -3, 4, 5), solution.findFrequentTreeSum(buildTree(1, null, 5, 2, -3)))
    }

    @Test
    fun testFindAllSubtreeSums() {
        val subtreeSums = arrayListOf<Int>()
        solution.findAllSubtreeSums(buildTree(1, 6, 8, null, null, null, 10), subtreeSums)
        assertEquals(listOf(6, 10, 18, 25), subtreeSums)

        val sums2 = arrayListOf<Int>()
        solution.findAllSubtreeSums(buildTree(5, 2, -3), sums2)
        assertEquals(listOf(2, -3, 4), sums2)
    }

}