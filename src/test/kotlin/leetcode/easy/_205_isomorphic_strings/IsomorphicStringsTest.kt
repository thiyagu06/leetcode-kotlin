package leetcode.easy._205_isomorphic_strings

import org.junit.Test

import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IsomorphicStringsTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun isIsomorphic() {
        assertTrue(solution.isIsomorphic("", ""))
        assertTrue(solution.isIsomorphic("a", "a"))
        assertTrue(solution.isIsomorphic("a", "z"))
        assertTrue(solution.isIsomorphic("egg", "add"))
        assertTrue(solution.isIsomorphic("paper", "title"))
        assertFalse(solution.isIsomorphic("foo", "bar"))
        assertFalse(solution.isIsomorphic("foo", "bbb"))    // f & o both map to b
    }

    @Test
    fun isIsomorphic2() {
        assertTrue(solution2.isIsomorphic("", ""))
        assertTrue(solution2.isIsomorphic("a", "a"))
        assertTrue(solution2.isIsomorphic("a", "z"))
        assertTrue(solution2.isIsomorphic("egg", "add"))
        assertTrue(solution2.isIsomorphic("paper", "title"))
        assertFalse(solution2.isIsomorphic("foo", "bar"))
        assertFalse(solution2.isIsomorphic("foo", "bbb"))    // f & o both map to b
    }
}