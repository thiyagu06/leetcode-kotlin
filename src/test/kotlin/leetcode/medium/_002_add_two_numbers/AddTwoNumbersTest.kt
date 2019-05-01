package leetcode.medium._002_add_two_numbers

import datastructures.list.linkedListOf
import kotlin.test.assertEquals
import kotlin.test.assertNull
import org.junit.Test

class AddTwoNumbersTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun addTwoNumbers() {
        assertNull(solution.addTwoNumbers(null, null))
        assertEquals(linkedListOf(1, 2, 3), solution.addTwoNumbers(linkedListOf(1, 2, 3), null))
        assertEquals(linkedListOf(1, 2, 3), solution.addTwoNumbers(linkedListOf(1, 2, 3), null))
        assertEquals(linkedListOf(1, 2, 3), solution.addTwoNumbers(null, linkedListOf(1, 2, 3)))
        assertEquals(linkedListOf(0), solution.addTwoNumbers(linkedListOf(0), linkedListOf(0)))
        assertEquals(linkedListOf(2, 4, 3), solution.addTwoNumbers(linkedListOf(0), linkedListOf(2, 4, 3)))
        assertEquals(linkedListOf(7, 0, 8), solution.addTwoNumbers(linkedListOf(5, 6, 4), linkedListOf(2, 4, 3)))
        assertEquals(
            linkedListOf(7, 0, 8, 7, 1),
            solution.addTwoNumbers(linkedListOf(5, 6, 4, 7, 1), linkedListOf(2, 4, 3))
        )
        assertEquals(linkedListOf(7, 0, 8), solution.addTwoNumbers(linkedListOf(2, 4, 3), linkedListOf(5, 6, 4)))

        assertEquals(
            linkedListOf(8, 3, 1, 0, 1),
            solution.addTwoNumbers(
                linkedListOf(1, 0, 9, 9),
                linkedListOf(7, 3, 2)
            )
        )

        // Int overflow
        assertEquals(
            linkedListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1),
            solution.addTwoNumbers(linkedListOf(9), linkedListOf(1, 9, 9, 9, 9, 9, 9, 9, 9, 9))
        )
        // Long overflow
        assertEquals(
            linkedListOf(
                7, 0, 8, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6,
                4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 1, 4, 3, 9, 1
            ),
            solution.addTwoNumbers(
                linkedListOf(
                    2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2,
                    4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 9
                ),
                linkedListOf(
                    5, 6, 4, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2,
                    4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 9, 9, 9, 9
                )
            )
        )
    }

    @Test
    fun addTwoNumbers2() {
        assertNull(solution2.addTwoNumbers(null, null))
        assertEquals(linkedListOf(1, 2, 3), solution2.addTwoNumbers(linkedListOf(1, 2, 3), null))
        assertEquals(linkedListOf(1, 2, 3), solution2.addTwoNumbers(linkedListOf(1, 2, 3), null))
        assertEquals(linkedListOf(1, 2, 3), solution2.addTwoNumbers(null, linkedListOf(1, 2, 3)))
        assertEquals(linkedListOf(0), solution2.addTwoNumbers(linkedListOf(0), linkedListOf(0)))
        assertEquals(linkedListOf(2, 4, 3), solution2.addTwoNumbers(linkedListOf(0), linkedListOf(2, 4, 3)))
        assertEquals(linkedListOf(7, 0, 8), solution2.addTwoNumbers(linkedListOf(5, 6, 4), linkedListOf(2, 4, 3)))
        assertEquals(
            linkedListOf(7, 0, 8, 7, 1),
            solution2.addTwoNumbers(linkedListOf(5, 6, 4, 7, 1), linkedListOf(2, 4, 3))
        )
        assertEquals(linkedListOf(7, 0, 8), solution2.addTwoNumbers(linkedListOf(2, 4, 3), linkedListOf(5, 6, 4)))

        assertEquals(
            linkedListOf(8, 3, 1, 0, 1),
            solution2.addTwoNumbers(
                linkedListOf(1, 0, 9, 9),
                linkedListOf(7, 3, 2)
            )
        )

        // Int overflow
        assertEquals(
            linkedListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1),
            solution2.addTwoNumbers(linkedListOf(9), linkedListOf(1, 9, 9, 9, 9, 9, 9, 9, 9, 9))
        )
        // Long overflow
        assertEquals(
            linkedListOf(
                7, 0, 8, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6,
                4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 1, 4, 3, 9, 1
            ),
            solution2.addTwoNumbers(
                linkedListOf(
                    2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2,
                    4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 9
                ),
                linkedListOf(
                    5, 6, 4, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2,
                    4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 9, 9, 9, 9
                )
            )
        )
    }
}