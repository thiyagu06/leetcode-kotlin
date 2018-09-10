package leetcode.medium._238_product_of_array_except_self

import org.junit.Assert.assertArrayEquals
import org.junit.Ignore
import org.junit.Test

class ProductOfArrayExceptSelfTest {

    private val solution = Solution()
    private val followup = FollowUpSolution()

    @Test
    fun productExceptSelf() {
        assertArrayEquals(
            intArrayOf(24, 12, 8, 6),
            solution.productExceptSelf(intArrayOf(1, 2, 3, 4))
        )
    }

    @Ignore // Not implemented
    @Test
    fun productExceptSelfFollowup() {
        assertArrayEquals(
            intArrayOf(24, 12, 8, 6),
            followup.productExceptSelf(intArrayOf(1, 2, 3, 4))
        )
    }
}