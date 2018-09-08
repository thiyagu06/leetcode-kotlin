package algorithms.easy._387_first_unique_char_in_string

import org.junit.Test

import org.junit.Assert.*

class FirstUniqueCharTest {

    private val solution = Solution()

    @Test
    fun firstUniqChar() {
        assertEquals(0, solution.firstUniqChar("leetcode"))
        assertEquals(2, solution.firstUniqChar("loveleetcode"))
    }
}