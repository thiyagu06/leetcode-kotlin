package leetcode.medium._031_next_permutation

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class NextPermutationTest {

    private val solution = Solution()

    @Test
    fun nextPermutation() {
        val nums = intArrayOf(1, 2, 3)
        val nextPermutations = listOf(
            intArrayOf(1, 3, 2), intArrayOf(2, 1, 3), intArrayOf(2, 3, 1),
            intArrayOf(3, 1, 2), intArrayOf(3, 2, 1)
        )

        nextPermutations.forEach { p ->
            solution.nextPermutation(nums)
            assertArrayEquals(p, nums)
        }
    }

    @Test
    fun `nextPermutation when last permutation`() {
        val nums = intArrayOf(3, 2, 1)
        solution.nextPermutation(nums)
        assertArrayEquals(intArrayOf(1, 2, 3), nums)
    }

    @Test
    fun `nextPermutation with duplicates`() {
        val nums = intArrayOf(1, 1, 5)
        solution.nextPermutation(nums)
        assertArrayEquals(intArrayOf(1, 5, 1), nums)
    }
}