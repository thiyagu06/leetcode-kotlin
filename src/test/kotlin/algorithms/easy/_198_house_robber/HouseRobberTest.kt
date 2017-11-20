package algorithms.easy._198_house_robber

import org.junit.Test

import org.junit.Assert.*

/**
 * @author nrojiani
 * @date 11/19/17
 */
class HouseRobberTest {
    private val solution = Solution()

    @Test
    fun rob() {
        assertEquals(8, solution.rob(intArrayOf(2, 4, 2, 4)))
        assertEquals(4, solution.rob(intArrayOf(2, 1, 1, 2)))
    }

}