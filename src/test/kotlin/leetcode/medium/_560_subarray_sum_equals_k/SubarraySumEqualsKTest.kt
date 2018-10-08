package leetcode.medium._560_subarray_sum_equals_k

import org.junit.Assert.*
import org.junit.Test

class SubarraySumEqualsKTest {

    private val solution = Solution()

    @Test
    fun subarraySum() {
        assertEquals(0, solution.subarraySum(intArrayOf(), k = 2))
        assertEquals(2, solution.subarraySum(intArrayOf(1, 1, 1), k = 2))
        assertEquals(2, solution.subarraySum(intArrayOf(1, 2, 3), k = 3))
        assertEquals(1, solution.subarraySum(intArrayOf(1, 2, 3), k = 6))
        assertEquals(1, solution.subarraySum(intArrayOf(1, 2, 4), k = 3))
    }
}