package leetcode.easy._007_reverse_integer

import org.junit.Assert.*
import org.junit.Test

class ReverseIntegerTest {
    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test fun reverse() {
        assertEquals(0, solution.reverse(0))
        assertEquals(1, solution.reverse(1))
        assertEquals(-1, solution.reverse(-1))
        assertEquals(-1, solution.reverse(-100))
        assertEquals(1001, solution.reverse(1001))
        assertEquals(-1001, solution.reverse(-1001))
        assertEquals(1234567, solution.reverse(7654321))
        assertEquals(-1234567, solution.reverse(-7654321))
        assertEquals(-1234567, solution.reverse(-76543210))
    }

    @Test fun `reverse - Overflow`() {
        // 8463847412 > Int.MAX_VALUE
        assertEquals(0, solution.reverse(Int.MIN_VALUE))

        // 7463847412 > Int.MAX_VALUE
        assertEquals(0, solution.reverse(Int.MAX_VALUE))

        assertEquals(0, solution.reverse(1534236469))
    }

    @Test fun reverse2() {
        assertEquals(0, solution2.reverse(0))
        assertEquals(1, solution2.reverse(1))
        assertEquals(-1, solution2.reverse(-1))
        assertEquals(-1, solution2.reverse(-100))
        assertEquals(1001, solution2.reverse(1001))
        assertEquals(-1001, solution2.reverse(-1001))
        assertEquals(1234567, solution2.reverse(7654321))
        assertEquals(-1234567, solution2.reverse(-7654321))
        assertEquals(-1234567, solution2.reverse(-76543210))
    }

    @Test fun `reverse2 - Overflow`() {
        // 8463847412 > Int.MAX_VALUE
        assertEquals(0, solution2.reverse(Int.MIN_VALUE))

        // 7463847412 > Int.MAX_VALUE
        assertEquals(0, solution2.reverse(Int.MAX_VALUE))

        assertEquals(0, solution2.reverse(1534236469))
    }
}
