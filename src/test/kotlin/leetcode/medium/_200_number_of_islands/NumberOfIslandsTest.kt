package leetcode.medium._200_number_of_islands

import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Test

class NumberOfIslandsTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val largeInput = arrayOf(
        charArrayOf('1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '0', '1', '1'),
        charArrayOf('0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '0'),
        charArrayOf('1', '0', '1', '1', '1', '0', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'),
        charArrayOf('1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'),
        charArrayOf('1', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'),
        charArrayOf('1', '0', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1'),
        charArrayOf('0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1'),
        charArrayOf('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '0', '1', '1'),
        charArrayOf('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1'),
        charArrayOf('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'),
        charArrayOf('0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'),
        charArrayOf('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'),
        charArrayOf('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'),
        charArrayOf('1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1'),
        charArrayOf('1', '0', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1'),
        charArrayOf('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '0', '0'),
        charArrayOf('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'),
        charArrayOf('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'),
        charArrayOf('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1')
    )

    @Ignore
    @Test
    fun numIslands() {
        assertEquals(
            1, solution.numIslands(
                arrayOf(
                    charArrayOf('1', '1', '1', '1', '0'),
                    charArrayOf('1', '1', '0', '1', '0'),
                    charArrayOf('1', '1', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0')
                )
            )
        )

        assertEquals(
            3, solution.numIslands(
                arrayOf(
                    charArrayOf('1', '1', '0', '0', '0'),
                    charArrayOf('1', '1', '0', '0', '0'),
                    charArrayOf('0', '0', '1', '0', '0'),
                    charArrayOf('0', '0', '0', '1', '1')
                )
            )
        )

        // 1's must be horizontally or vertically adjacent (not diagonally)
        // Each 1 counts as 1 island
        assertEquals(
            2, solution.numIslands(
                arrayOf(
                    charArrayOf('1', '0', '0', '0', '0'),
                    charArrayOf('0', '1', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0')
                )
            )
        )

        assertEquals(
            1, solution.numIslands(
                arrayOf(
                    charArrayOf('1', '0', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0')
                )
            )
        )

        assertEquals(
            1, solution.numIslands(
                arrayOf(
                    charArrayOf('0', '1', '0', '0', '0'),
                    charArrayOf('1', '1', '1', '0', '0'),
                    charArrayOf('0', '1', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0')
                )
            )
        )

        assertEquals(
            5, solution.numIslands(
                arrayOf(
                    charArrayOf('1', '0', '1', '0', '0'),
                    charArrayOf('0', '1', '0', '0', '0'),
                    charArrayOf('1', '0', '1', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0')
                )
            )
        )
        assertEquals(
            5, solution.numIslands(
                arrayOf(
                    charArrayOf('1', '0', '0', '0', '0', '1'),
                    charArrayOf('1', '1', '0', '0', '1', '1'),
                    charArrayOf('0', '1', '0', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '1', '0', '0'),
                    charArrayOf('1', '0', '0', '0', '1', '1')
                )
            )
        )
    }


    @Ignore
    @Test
    fun largeInput() {
        assertEquals(1, solution.numIslands(largeInput))
    }

    @Test
    fun numIslands2() {
        assertEquals(
            1, solution2.numIslands(
                arrayOf(
                    charArrayOf('1', '1', '1', '1', '0'),
                    charArrayOf('1', '1', '0', '1', '0'),
                    charArrayOf('1', '1', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0')
                )
            )
        )

        assertEquals(
            3, solution2.numIslands(
                arrayOf(
                    charArrayOf('1', '1', '0', '0', '0'),
                    charArrayOf('1', '1', '0', '0', '0'),
                    charArrayOf('0', '0', '1', '0', '0'),
                    charArrayOf('0', '0', '0', '1', '1')
                )
            )
        )

        // 1's must be horizontally or vertically adjacent (not diagonally)
        // Each 1 counts as 1 island
        assertEquals(
            2, solution2.numIslands(
                arrayOf(
                    charArrayOf('1', '0', '0', '0', '0'),
                    charArrayOf('0', '1', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0')
                )
            )
        )

        assertEquals(
            1, solution2.numIslands(
                arrayOf(
                    charArrayOf('1', '0', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0')
                )
            )
        )

        assertEquals(
            1, solution2.numIslands(
                arrayOf(
                    charArrayOf('0', '1', '0', '0', '0'),
                    charArrayOf('1', '1', '1', '0', '0'),
                    charArrayOf('0', '1', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0')
                )
            )
        )

        assertEquals(
            5, solution2.numIslands(
                arrayOf(
                    charArrayOf('1', '0', '1', '0', '0'),
                    charArrayOf('0', '1', '0', '0', '0'),
                    charArrayOf('1', '0', '1', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0')
                )
            )
        )
        assertEquals(
            5, solution2.numIslands(
                arrayOf(
                    charArrayOf('1', '0', '0', '0', '0', '1'),
                    charArrayOf('1', '1', '0', '0', '1', '1'),
                    charArrayOf('0', '1', '0', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '1', '0', '0'),
                    charArrayOf('1', '0', '0', '0', '1', '1')
                )
            )
        )
    }

    @Test
    fun largeInput2() {
        assertEquals(1, solution2.numIslands(largeInput))
    }
}