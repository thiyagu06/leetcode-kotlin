package algorithms.medium._031_next_permutation

import org.junit.Test

import org.junit.Assert.*
import org.junit.Ignore

class NextPermutationTest {

    private val solution = Solution()

    // TODO
    @Ignore
    @Test
    fun nextPermutation1() {
        val nums = intArrayOf(1, 2, 3)
        solution.nextPermutation(nums)
        assertArrayEquals(intArrayOf(1, 3, 2), nums)
    }

    @Ignore
    @Test
    fun nextPermutation2() {
        val nums = intArrayOf(3, 2, 1)
        solution.nextPermutation(nums)
        assertArrayEquals(intArrayOf(1, 2, 3), nums)
    }

    @Ignore
    @Test
    fun nextPermutation3() {
        val nums = intArrayOf(1, 2, 3)
        solution.nextPermutation(nums)
        assertArrayEquals(intArrayOf(1, 3, 2), nums)
    }

    @Ignore
    @Test
    fun nextPermutation4() {
        val nums = intArrayOf(1, 1, 5)
        solution.nextPermutation(nums)
        assertArrayEquals(intArrayOf(1, 5, 1), nums)
    }
}