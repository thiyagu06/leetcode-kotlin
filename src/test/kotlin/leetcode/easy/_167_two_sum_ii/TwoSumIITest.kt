package leetcode.easy._167_two_sum_ii

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class TwoSumIITest {

    private val solution = Solution()

    @Test
    fun twoSum() {
        assertArrayEquals(intArrayOf(1, 2), solution.twoSum(intArrayOf(2, 7, 11, 15), target = 9))
        assertArrayEquals(intArrayOf(1, 2), solution.twoSum(intArrayOf(2, 2, 7, 11), target = 4))
        assertArrayEquals(intArrayOf(1, 3), solution.twoSum(intArrayOf(2, 3, 4), target = 6))
        assertArrayEquals(intArrayOf(3, 4), solution.twoSum(intArrayOf(1, 2, 4, 4), target = 8))
    }

}