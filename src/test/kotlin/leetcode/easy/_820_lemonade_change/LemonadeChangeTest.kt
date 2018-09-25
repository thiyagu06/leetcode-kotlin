package leetcode.easy._820_lemonade_change

import org.junit.Assert.*
import org.junit.Test
import kotlin.test.assert
import kotlin.test.assertTrue

class LemonadeChangeTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun lemonadeChange() {
        assertTrue(solution.lemonadeChange(intArrayOf(5, 5, 5, 10, 20)))
        assertTrue(solution.lemonadeChange(intArrayOf(5, 5, 5, 10)))
        assertFalse(solution.lemonadeChange(intArrayOf(10)))
        assertFalse(solution.lemonadeChange(intArrayOf(10, 10)))
        assertFalse(solution.lemonadeChange(intArrayOf(5, 5, 10, 10, 20)))
    }

    @Test
    fun lemonadeChange2() {
        assertTrue(solution2.lemonadeChange(intArrayOf(5, 5, 5, 10, 20)))
        assertTrue(solution2.lemonadeChange(intArrayOf(5, 5, 5, 10)))
        assertFalse(solution2.lemonadeChange(intArrayOf(10)))
        assertFalse(solution2.lemonadeChange(intArrayOf(10, 10)))
        assertFalse(solution2.lemonadeChange(intArrayOf(5, 5, 10, 10, 20)))
    }

}