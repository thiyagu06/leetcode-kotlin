package leetcode.easy._344_reverse_string

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class ReverseStringTest {

    private val solution = Solution()

    @Test
    fun reverseString() {
        val chars1 = charArrayOf('h','e','l','l','o')
        solution.reverseString(chars1)
        assertArrayEquals(charArrayOf('o', 'l', 'l', 'e', 'h'), chars1)

        val chars2 = charArrayOf('H','a','n','n','a','h')
        solution.reverseString(chars2)
        assertArrayEquals(charArrayOf('h','a','n','n','a','H'), chars2)

        val chars3 = charArrayOf()
        solution.reverseString(chars3)
        assertArrayEquals(charArrayOf(), chars3)

    }
}