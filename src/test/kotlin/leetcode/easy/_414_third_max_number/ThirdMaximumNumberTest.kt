package leetcode.easy._414_third_max_number

import org.junit.Test

import org.junit.Assert.*

class ThirdMaximumNumberTest {

    private val solution = Solution()

    @Test
    fun thirdMax() {
        assertEquals(1, solution.thirdMax(intArrayOf(3, 2, 1)))
        assertEquals(2, solution.thirdMax(intArrayOf(1, 2)))
        assertEquals(1, solution.thirdMax(intArrayOf(2, 2, 3, 1)))
        assertEquals(Int.MIN_VALUE, solution.thirdMax(intArrayOf(1, 2, Int.MIN_VALUE)))
    }

}