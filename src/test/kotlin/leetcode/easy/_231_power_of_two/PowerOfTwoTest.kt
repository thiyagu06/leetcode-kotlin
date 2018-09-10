package leetcode.easy._231_power_of_two

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PowerOfTwoTest {
    private val solution = Solution()

    @Test
    fun isPowerOfTwo() {
        assertTrue(solution.isPowerOfTwo(1))
        assertTrue(solution.isPowerOfTwo(2))
        assertTrue(solution.isPowerOfTwo(4))
        assertTrue(solution.isPowerOfTwo(8))
        assertTrue(solution.isPowerOfTwo(32))
        assertTrue(solution.isPowerOfTwo(128))
        assertFalse(solution.isPowerOfTwo(218))
        assertFalse(solution.isPowerOfTwo(0))
        assertFalse(solution.isPowerOfTwo(-1))
        assertFalse(solution.isPowerOfTwo(3))
    }
}