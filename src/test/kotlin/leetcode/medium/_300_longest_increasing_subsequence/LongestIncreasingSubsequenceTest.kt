package leetcode.medium._300_longest_increasing_subsequence

import org.junit.Test

import kotlin.test.assertEquals

class LongestIncreasingSubsequenceTest {

    private val solution = Solution()

    @Test
    fun lengthOfLIS() {
        assertEquals(0, solution.lengthOfLIS(intArrayOf()))
        assertEquals(1, solution.lengthOfLIS(intArrayOf(7)))
        assertEquals(1, solution.lengthOfLIS(intArrayOf(7, 1)))
        assertEquals(2, solution.lengthOfLIS(intArrayOf(1, 7)))
        assertEquals(2, solution.lengthOfLIS(intArrayOf(1, 7, 1)))
        assertEquals(2, solution.lengthOfLIS(intArrayOf(1, 2, 2, 2)))
        assertEquals(4, solution.lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)))
        assertEquals(4, solution.lengthOfLIS(intArrayOf(2, 5, 3, 4, 6)))
        assertEquals(5, solution.lengthOfLIS(intArrayOf(2, 4, 3, 5, 1, 7, 6, 9, 8)))
        assertEquals(4, solution.lengthOfLIS(intArrayOf(6, 3, 5, 2, 7, 8, 1)))
        assertEquals(3, solution.lengthOfLIS(intArrayOf(3, 10, 2, 1, 20)))
        assertEquals(4, solution.lengthOfLIS(intArrayOf(50, 3, 10, 7, 40, 80)))
        assertEquals(6, solution.lengthOfLIS(intArrayOf(10, 22, 9, 33, 21, 50, 41, 60, 80)))
    }
}