package algorithms.easy._205_isomorphic_strings

import org.junit.Test

import org.junit.Assert.*

class IsomorphicStringsTest {

    private val solution = Solution()

    @Test
    fun isIsomorphic() {
        assertTrue(solution.isIsomorphic("", ""))
        assertTrue(solution.isIsomorphic("a", "a"))
        assertTrue(solution.isIsomorphic("a", "z"))
        assertTrue(solution.isIsomorphic("egg", "add"))
        assertFalse(solution.isIsomorphic("foo", "bar"))
        assertFalse(solution.isIsomorphic("foo", "bbb"))    // f & o both map to b
        assertTrue(solution.isIsomorphic("paper", "title"))
    }
}