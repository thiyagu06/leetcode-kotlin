package algorithms.medium._002_add_two_numbers

import datastructures.list.linkedListOf
import org.junit.Assert.assertEquals
import org.junit.Test
import java.math.BigInteger

class AddTwoNumbersTest {

    private val solution = Solution()

    @Test
    fun addTwoNumbers() {
        assertEquals(linkedListOf(0), solution.addTwoNumbers(linkedListOf(0), linkedListOf(0)))
        assertEquals(linkedListOf(2, 4, 3), solution.addTwoNumbers(linkedListOf(0), linkedListOf(2, 4, 3)))
        assertEquals(linkedListOf(7, 0, 8), solution.addTwoNumbers(linkedListOf(5, 6, 4), linkedListOf(2, 4, 3)))
        assertEquals(linkedListOf(7, 0, 8, 7, 1), solution.addTwoNumbers(linkedListOf(5, 6, 4, 7, 1), linkedListOf(2, 4, 3)))
        assertEquals(linkedListOf(7, 0, 8), solution.addTwoNumbers(linkedListOf(2, 4, 3), linkedListOf(5, 6, 4)))
        // Int overflow
        assertEquals(linkedListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1), solution.addTwoNumbers(linkedListOf(9), linkedListOf(1, 9, 9, 9, 9, 9, 9, 9, 9, 9)))
        // Long overflow
        assertEquals(
                linkedListOf(7, 0, 8, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6,
                        4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 1, 4, 3, 9, 1),
                solution.addTwoNumbers(
                        linkedListOf(2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2,
                                4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 9),
                        linkedListOf(5, 6, 4, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2,
                                4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 9, 9, 9, 9)))
    }

    @Test
    fun valueOf() {
        assertEquals(BigInteger("9342342342342342342342342342342342342342342342342342342342342"),
                solution.valueOf(linkedListOf(2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3,
                        2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2,
                        4, 3, 2, 4, 3, 9)))
        assertEquals(BigInteger("9999342342342342342342342342342342342342342342342342342342465"),
                solution.valueOf(linkedListOf(5, 6, 4, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3,
                        2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2,
                        4, 3, 9, 9, 9, 9)))
        assertEquals(BigInteger("19341684684684684684684684684684684684684684684684684744684807"),
                solution.valueOf(linkedListOf(7, 0, 8, 4, 8, 6, 4, 4, 7, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6,
                        4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6, 4, 8, 6,
                        1, 4, 3, 9, 1)))
        assertEquals(9999999991L.toBigInteger(), solution.valueOf(linkedListOf(1, 9, 9, 9, 9, 9, 9, 9, 9, 9)))
    }
}