package leetcode.easy._066_plus_one

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class PlusOneTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()

    @Test
    fun plusOne() {
        assertArrayEquals(intArrayOf(1), solution.plusOne(intArrayOf(0)))
        assertArrayEquals(intArrayOf(2), solution.plusOne(intArrayOf(1)))
        assertArrayEquals(intArrayOf(1, 0), solution.plusOne(intArrayOf(9)))
        assertArrayEquals(intArrayOf(1, 0, 0), solution.plusOne(intArrayOf(9, 9)))
        assertArrayEquals(intArrayOf(1, 2, 4), solution.plusOne(intArrayOf(1, 2, 3)))
        assertArrayEquals(intArrayOf(9, 9, 0, 0), solution.plusOne(intArrayOf(9, 8, 9, 9)))
        assertArrayEquals(intArrayOf(9, 0, 0, 0), solution.plusOne(intArrayOf(8, 9, 9, 9)))
    }

    @Test
    fun plusOne2() {
        assertArrayEquals(intArrayOf(1), solution2.plusOne(intArrayOf(0)))
        assertArrayEquals(intArrayOf(2), solution2.plusOne(intArrayOf(1)))
        assertArrayEquals(intArrayOf(1, 0), solution2.plusOne(intArrayOf(9)))
        assertArrayEquals(intArrayOf(1, 0, 0), solution2.plusOne(intArrayOf(9, 9)))
        assertArrayEquals(intArrayOf(1, 2, 4), solution2.plusOne(intArrayOf(1, 2, 3)))
        assertArrayEquals(intArrayOf(9, 9, 0, 0), solution2.plusOne(intArrayOf(9, 8, 9, 9)))
        assertArrayEquals(intArrayOf(9, 0, 0, 0), solution2.plusOne(intArrayOf(8, 9, 9, 9)))
    }

    @Test
    fun plusOne3() {
        assertArrayEquals(intArrayOf(1), solution3.plusOne(intArrayOf(0)))
        assertArrayEquals(intArrayOf(2), solution3.plusOne(intArrayOf(1)))
        assertArrayEquals(intArrayOf(1, 0), solution3.plusOne(intArrayOf(9)))
        assertArrayEquals(intArrayOf(1, 0, 0), solution3.plusOne(intArrayOf(9, 9)))
        assertArrayEquals(intArrayOf(1, 2, 4), solution3.plusOne(intArrayOf(1, 2, 3)))
        assertArrayEquals(intArrayOf(9, 9, 0, 0), solution3.plusOne(intArrayOf(9, 8, 9, 9)))
        assertArrayEquals(intArrayOf(9, 0, 0, 0), solution3.plusOne(intArrayOf(8, 9, 9, 9)))
    }

}
