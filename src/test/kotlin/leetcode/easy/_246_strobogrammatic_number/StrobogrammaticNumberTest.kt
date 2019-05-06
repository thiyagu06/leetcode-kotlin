package leetcode.easy._246_strobogrammatic_number

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StrobogrammaticNumberTest {
    private val solution = Solution()

    @Test
    fun isStrobogrammatic() {
        assertTrue(solution.isStrobogrammatic(""))
        assertTrue(solution.isStrobogrammatic("0"))
        assertTrue(solution.isStrobogrammatic("1"))
        assertFalse(solution.isStrobogrammatic("2"))
        assertFalse(solution.isStrobogrammatic("3"))
        assertFalse(solution.isStrobogrammatic("4"))
        assertFalse(solution.isStrobogrammatic("5"))
        assertFalse(solution.isStrobogrammatic("6"))
        assertFalse(solution.isStrobogrammatic("7"))
        assertTrue(solution.isStrobogrammatic("8"))
        assertFalse(solution.isStrobogrammatic("9"))

        assertTrue(solution.isStrobogrammatic("101"))
        assertTrue(solution.isStrobogrammatic("181"))
        assertTrue(solution.isStrobogrammatic("69"))
        assertTrue(solution.isStrobogrammatic("96"))
        assertTrue(solution.isStrobogrammatic("6969"))
        assertTrue(solution.isStrobogrammatic("9696"))
        assertTrue(solution.isStrobogrammatic("88"))
        assertTrue(solution.isStrobogrammatic("1881"))
        assertTrue(solution.isStrobogrammatic("1691"))
        assertTrue(solution.isStrobogrammatic("1961"))
        assertTrue(solution.isStrobogrammatic("169691"))
        assertTrue(solution.isStrobogrammatic("1969696961"))

        assertFalse(solution.isStrobogrammatic("18"))
        assertFalse(solution.isStrobogrammatic("696"))
        assertFalse(solution.isStrobogrammatic("962"))
        assertFalse(solution.isStrobogrammatic("969"))
        assertFalse(solution.isStrobogrammatic("161"))
        assertFalse(solution.isStrobogrammatic("6918"))
        assertFalse(solution.isStrobogrammatic("1818"))
        assertFalse(solution.isStrobogrammatic("69696"))
    }
}