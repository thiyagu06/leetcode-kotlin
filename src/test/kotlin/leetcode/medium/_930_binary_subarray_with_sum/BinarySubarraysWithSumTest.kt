package leetcode.medium._930_binary_subarray_with_sum

import org.junit.Test

import kotlin.test.assertEquals

class BinarySubarraysWithSumTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun numSubarraysWithSum() {
        assertEquals(4, solution.numSubarraysWithSum(intArrayOf(1, 0, 1, 0, 1), 2))
    }

    @Test
    fun numSubarraysWithSum2() {
        assertEquals(4, solution2.numSubarraysWithSum(intArrayOf(1, 0, 1, 0, 1), 2))
    }
}