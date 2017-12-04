package algorithms.easy._268_missing_number

import org.junit.Test

import org.junit.Assert.*

class MissingNumberTest {
    private val solution = Solution()
    private val solution2 = Solution2()
    @Test
    fun missingNumber1() {
        assertEquals(0, solution.missingNumber(intArrayOf(1, 2, 3)))
        assertEquals(1, solution.missingNumber(intArrayOf(0, 2, 3)))
        assertEquals(2, solution.missingNumber(intArrayOf(0, 1, 3)))
        assertEquals(3, solution.missingNumber(intArrayOf(0, 1, 2, 4)))
        assertEquals(2, solution.missingNumber(intArrayOf(3, 0, 1)))
        assertEquals(1, solution.missingNumber(intArrayOf(0)))
    }

    @Test
    fun missingNumber2() {
        assertEquals(0, solution2.missingNumber(intArrayOf(1, 2, 3)))
        assertEquals(1, solution2.missingNumber(intArrayOf(0, 2, 3)))
        assertEquals(2, solution2.missingNumber(intArrayOf(0, 1, 3)))
        assertEquals(3, solution2.missingNumber(intArrayOf(0, 1, 2)))
    }
}