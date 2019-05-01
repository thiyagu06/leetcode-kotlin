package leetcode.easy._387_first_unique_char_in_string

import org.junit.Test

import org.junit.Assert.*

class FirstUniqueCharTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun firstUniqChar() {
        assertEquals(0, solution.firstUniqChar("leetcode"))
        assertEquals(2, solution.firstUniqChar("loveleetcode"))
        assertEquals(8, solution.firstUniqChar("dddccdbba"))
    }

    @Test
    fun firstUniqChar2() {
        assertEquals(0, solution2.firstUniqChar("leetcode"))
        assertEquals(2, solution2.firstUniqChar("loveleetcode"))
        assertEquals(8, solution2.firstUniqChar("dddccdbba"))
    }
}