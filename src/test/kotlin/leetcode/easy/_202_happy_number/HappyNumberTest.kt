package leetcode.easy._202_happy_number

import org.junit.Test

import org.junit.Assert.*

class HappyNumberTest {

    private val solution = Solution()

    @Test
    fun isHappy() {
        (1..40).forEach { n ->
            if (n in setOf(1, 7, 10, 13, 19, 23, 28, 31, 32)) {
                assertTrue(solution.isHappy(n))
            } else {
                assertFalse(solution.isHappy(n))
            }
        }
    }
}