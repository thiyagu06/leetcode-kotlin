package leetcode.easy._733_flood_fill

import extensions.arrays.toMatrix
import org.junit.Test

import org.junit.Assert.*

class FloodFillTest {

    private val solution = Solution()

    @Test
    fun floodFill() {
        assertArrayEquals(
            listOf(listOf(2, 2, 2), listOf(2, 2, 0), listOf(2, 0, 1)).toMatrix(),
            solution.floodFill(
                img = listOf(listOf(1, 1, 1), listOf(1, 1, 0), listOf(1, 0, 1)).toMatrix(),
                sr = 1, sc = 1, newColor = 2
            )
        )

        assertArrayEquals(
            listOf(listOf(0, 0, 0), listOf(0, 1, 1)).toMatrix(),
            solution.floodFill(
                img = listOf(listOf(0, 0, 0), listOf(0, 1, 1)).toMatrix(),
                sr = 1, sc = 1, newColor = 1
            )
        )
    }
}