package leetcode.medium._047_permutations_ii

import kotlin.test.assertEquals
import org.junit.Test

class PermutationsIITest {

    private val solution = Solution()

    @Test
    fun permutationsUnique() {
        assertEquals(
            setOf(
                listOf(1, 2, 3),
                listOf(1, 3, 2),
                listOf(2, 1, 3),
                listOf(2, 3, 1),
                listOf(3, 1, 2),
                listOf(3, 2, 1)
            ),
            solution.permuteUnique(intArrayOf(1, 2, 3)).toSet()
        )

        assertEquals(
            setOf(
                listOf(1, 1, 3),
                listOf(1, 3, 1),
                listOf(3, 1, 1)
            ),
            solution.permuteUnique(intArrayOf(1, 1, 3)).toSet()
        )
    }
}
