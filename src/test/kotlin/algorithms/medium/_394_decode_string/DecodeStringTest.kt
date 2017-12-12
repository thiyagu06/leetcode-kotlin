package algorithms.medium._394_decode_string

import org.junit.Assert.assertEquals
import org.junit.Test

class DecodeStringTest {

    private val solution = Solution()

    @Test
    fun decodeString() {
        assertEquals("aaabcbc", solution.decodeString("3[a]2[bc]"))
        assertEquals("abcabccdcdcdef", solution.decodeString("2[abc]3[cd]ef"))
        assertEquals("accaccacc", solution.decodeString("3[a2[c]]"))
        assertEquals("codecodecodecodecodecodecodecodecodecode", solution.decodeString("10[code]"))
    }

    @Test
    fun denestInput() {
        assertEquals("aaa", solution.denestInput("3[a]"))
        assertEquals("aaabcbc", solution.denestInput("3[a]2[bc]"))
        assertEquals("ef", solution.denestInput("ef"))
        assertEquals("aaaef", solution.denestInput("3[a]ef"))
        assertEquals("abcabccdcdcdef", solution.denestInput("2[abc]3[cd]ef"))

        // Recursively nested:
        assertEquals("a2[c]a2[c]a2[c]", solution.denestInput("3[a2[c]]"))
        assertEquals("accaccacc", solution.denestInput("a2[c]a2[c]a2[c]"))
    }
}