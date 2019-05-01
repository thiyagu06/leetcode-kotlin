package leetcode.easy._989_add_to_array_form_of_int

import org.junit.Test

import org.junit.Assert.*

class AddToArrayFormOfIntTest {

    private val solution = Solution()

    @Test
    fun addToArrayForm() {
        assertEquals(listOf(1, 2, 3, 4), solution.addToArrayForm(A = intArrayOf(1, 2, 0, 0), K = 34))
        assertEquals(listOf(4, 5, 5), solution.addToArrayForm(A = intArrayOf(2, 7, 4), K = 181))
        assertEquals(listOf(1, 0, 2, 1), solution.addToArrayForm(A = intArrayOf(2, 1, 5), K = 806))
        assertEquals(
            listOf(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            solution.addToArrayForm(A = intArrayOf(9, 9, 9, 9, 9, 9, 9, 9, 9, 9), K = 1)
        )
    }
}