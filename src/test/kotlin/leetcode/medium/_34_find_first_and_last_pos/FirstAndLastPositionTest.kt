package leetcode.medium._34_find_first_and_last_pos

import org.junit.Test

import org.junit.Assert.*

class FirstAndLastPositionTest {

    private val solution = Solution()
    private val solutionTwo = SolutionTwo()
    private val nums = intArrayOf(5, 7, 7, 8, 8, 10)

    @Test
    fun searchRange() {
        assertArrayEquals(intArrayOf(3, 4), solution.searchRange(nums = nums, target = 8))
        assertArrayEquals(intArrayOf(1, 2), solution.searchRange(nums = nums, target = 7))
        assertArrayEquals(intArrayOf(0, 0), solution.searchRange(nums = nums, target = 5))
        assertArrayEquals(intArrayOf(-1, -1), solution.searchRange(nums = nums, target = 6))
        assertArrayEquals(intArrayOf(0, 1), solution.searchRange(nums = intArrayOf(2, 2), target = 2))
        assertArrayEquals(intArrayOf(-1, -1), solution.searchRange(nums = intArrayOf(2, 2), target = 3))
        assertArrayEquals(intArrayOf(0, 0), solution.searchRange(nums = intArrayOf(2), target = 2))
        assertArrayEquals(intArrayOf(-1, -1), solution.searchRange(nums = intArrayOf(2), target = 3))
    }

    @Test
    fun searchRange2() {
        assertArrayEquals(intArrayOf(3, 4), solutionTwo.searchRange(nums = nums, target = 8))
        assertArrayEquals(intArrayOf(1, 2), solutionTwo.searchRange(nums = nums, target = 7))
        assertArrayEquals(intArrayOf(0, 0), solutionTwo.searchRange(nums = nums, target = 5))
        assertArrayEquals(intArrayOf(-1, -1), solutionTwo.searchRange(nums = nums, target = 6))
        assertArrayEquals(intArrayOf(0, 1), solutionTwo.searchRange(nums = intArrayOf(2, 2), target = 2))
        assertArrayEquals(intArrayOf(-1, -1), solutionTwo.searchRange(nums = intArrayOf(2, 2), target = 3))
        assertArrayEquals(intArrayOf(0, 0), solutionTwo.searchRange(nums = intArrayOf(2), target = 2))
        assertArrayEquals(intArrayOf(-1, -1), solutionTwo.searchRange(nums = intArrayOf(2), target = 3))
    }

}