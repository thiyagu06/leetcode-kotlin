package leetcode.medium._365_water_and_jug_problem

import org.junit.Test

import org.junit.Assert.*

class WaterAndJugProblemTest {

    private val solution = Solution()

    @Test
    fun canMeasureWater() {
        assertTrue(solution.canMeasureWater(x = 2, y = 3, z = 1))
        assertTrue(solution.canMeasureWater(x = 2, y = 3, z = 2))
        assertTrue(solution.canMeasureWater(x = 2, y = 3, z = 3))
        assertTrue(solution.canMeasureWater(x = 2, y = 3, z = 4))
        assertTrue(solution.canMeasureWater(x = 2, y = 3, z = 5))
        assertFalse(solution.canMeasureWater(x = 2, y = 3, z = 6))
        assertFalse(solution.canMeasureWater(x = 2, y = 3, z = 7))
        assertFalse(solution.canMeasureWater(x = 2, y = 3, z = 8))

        assertTrue(solution.canMeasureWater(x = 3, y = 5, z = 1))
        assertTrue(solution.canMeasureWater(x = 3, y = 5, z = 2))
        assertTrue(solution.canMeasureWater(x = 3, y = 5, z = 3))
        assertTrue(solution.canMeasureWater(x = 3, y = 5, z = 4))
        assertTrue(solution.canMeasureWater(x = 3, y = 5, z = 5))
        assertTrue(solution.canMeasureWater(x = 3, y = 5, z = 6))
        assertTrue(solution.canMeasureWater(x = 3, y = 5, z = 7))
        assertTrue(solution.canMeasureWater(x = 3, y = 5, z = 8))
        assertFalse(solution.canMeasureWater(x = 3, y = 5, z = 9))
        assertFalse(solution.canMeasureWater(x = 3, y = 5, z = 10))
        assertFalse(solution.canMeasureWater(x = 3, y = 5, z = 11))

        assertFalse(solution.canMeasureWater(x = 2, y = 6, z = 5))

        assertTrue(solution.canMeasureWater(x = 34, y = 5, z = 4))
        assertTrue(solution.canMeasureWater(x = 34, y = 5, z = 6))
    }
}