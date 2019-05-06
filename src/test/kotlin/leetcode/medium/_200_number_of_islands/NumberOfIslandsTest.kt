package leetcode.medium._200_number_of_islands

import org.junit.Test
import kotlin.test.assertEquals

class NumberOfIslandsTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()
    private val solution4 = SolutionFour()

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

    @Test
    fun numIslands() {
        assertEquals(
            0, solution.numIslands(arrayOf(charArrayOf()))
        )

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

    @Test
    fun largeInput() {
        assertEquals(1, solution.numIslands(largeInput))
    }

    @Test
    fun numIslands2() {
        assertEquals(
            0, solution2.numIslands(arrayOf(charArrayOf()))
        )

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

    @Test
    fun numIslands3() {
        assertEquals(
            0, solution3.numIslands(arrayOf(charArrayOf()))
        )

        assertEquals(
            1, solution3.numIslands(
                arrayOf(
                    charArrayOf('1', '1', '1', '1', '0'),
                    charArrayOf('1', '1', '0', '1', '0'),
                    charArrayOf('1', '1', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0')
                )
            )
        )

        assertEquals(
            3, solution3.numIslands(
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
            2, solution3.numIslands(
                arrayOf(
                    charArrayOf('1', '0', '0', '0', '0'),
                    charArrayOf('0', '1', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0')
                )
            )
        )

        assertEquals(
            1, solution3.numIslands(
                arrayOf(
                    charArrayOf('1', '0', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0')
                )
            )
        )

        assertEquals(
            1, solution3.numIslands(
                arrayOf(
                    charArrayOf('0', '1', '0', '0', '0'),
                    charArrayOf('1', '1', '1', '0', '0'),
                    charArrayOf('0', '1', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0')
                )
            )
        )

        assertEquals(
            5, solution3.numIslands(
                arrayOf(
                    charArrayOf('1', '0', '1', '0', '0'),
                    charArrayOf('0', '1', '0', '0', '0'),
                    charArrayOf('1', '0', '1', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0')
                )
            )
        )
        assertEquals(
            5, solution3.numIslands(
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
    fun largeInput3() {
        assertEquals(1, solution3.numIslands(largeInput))
    }

    @Test
    fun numIslands4() {
        assertEquals(
            0, solution4.numIslands(arrayOf(charArrayOf()))
        )

        assertEquals(
            1, solution4.numIslands(
                arrayOf(
                    charArrayOf('1', '1', '1', '1', '0'),
                    charArrayOf('1', '1', '0', '1', '0'),
                    charArrayOf('1', '1', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0')
                )
            )
        )

        assertEquals(
            3, solution4.numIslands(
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
            2, solution4.numIslands(
                arrayOf(
                    charArrayOf('1', '0', '0', '0', '0'),
                    charArrayOf('0', '1', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0')
                )
            )
        )

        assertEquals(
            1, solution4.numIslands(
                arrayOf(
                    charArrayOf('1', '0', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0')
                )
            )
        )

        assertEquals(
            1, solution4.numIslands(
                arrayOf(
                    charArrayOf('0', '1', '0', '0', '0'),
                    charArrayOf('1', '1', '1', '0', '0'),
                    charArrayOf('0', '1', '0', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0')
                )
            )
        )

        assertEquals(
            5, solution4.numIslands(
                arrayOf(
                    charArrayOf('1', '0', '1', '0', '0'),
                    charArrayOf('0', '1', '0', '0', '0'),
                    charArrayOf('1', '0', '1', '0', '0'),
                    charArrayOf('0', '0', '0', '0', '0')
                )
            )
        )
        assertEquals(
            5, solution4.numIslands(
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
    fun largeInput4() {
        assertEquals(1, solution4.numIslands(largeInput))
    }
}