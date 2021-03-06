package leetcode.easy._400_nth_digit

import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

class NthDigitTest {

    private val solution = Solution()

    @Test
    fun findNthDigit() {
        assertEquals(1, solution.findNthDigit(1))
        assertEquals(3, solution.findNthDigit(3))
        assertEquals(0, solution.findNthDigit(11))
        assertEquals(4, solution.findNthDigit(99))
        assertEquals(5, solution.findNthDigit(100))
        assertEquals(3, solution.findNthDigit(1000))
    }

    @Ignore("Long-running (~5s)")
    @Test
    fun findNthDigitExtremal() {
        assertEquals(1, solution.findNthDigit(Int.MAX_VALUE - 1000))
        assertEquals(2, solution.findNthDigit(Int.MAX_VALUE))
    }
}