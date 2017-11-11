package algorithms.easy._027_remove_element

import org.junit.Test

import org.junit.Assert.*

/**
 * @author nrojiani
 * @date 11/10/17
 */
class RemoveElementTest {

    private val solution = Solution()

    @Test
    fun removeElement() {
        assertEquals(0, solution.removeElement(intArrayOf(), 3))
        assertEquals(0, solution.removeElement(intArrayOf(3), 3))
        assertEquals(0, solution.removeElement(intArrayOf(3, 3), 3))
        assertEquals(0, solution.removeElement(intArrayOf(3, 3, 3, 3, 3), 3))

        assertEquals(1, solution.removeElement(intArrayOf(3), 2))
        assertEquals(2, solution.removeElement(intArrayOf(2, 2, 7, 7), 2))
        assertEquals(2, solution.removeElement(intArrayOf(3, 2, 2, 3), 3))
    }

}