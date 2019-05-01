package leetcode.easy._771_jewels_and_stones

import org.junit.Test

import org.junit.Assert.*

class JewelsAndStonesTest {

    private val solution = Solution()

    @Test
    fun numJewelsInStones() {
        assertEquals(3, solution.numJewelsInStones(J = "aA", S = "aAAbbbb"))
        assertEquals(0, solution.numJewelsInStones(J = "z", S = "ZZ"))
    }
}