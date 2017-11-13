package algorithms.easy._058_length_of_last_word

import org.junit.Test

import org.junit.Assert.*

/**
 * @author nrojiani
 * @date 11/12/17
 */
class LengthOfLastWordTest {
    private val solution = Solution()

    @Test
    fun lengthOfLastWord() {
        assertEquals(1, solution.lengthOfLastWord("a"))
        assertEquals(3, solution.lengthOfLastWord("abc"))
        assertEquals(3, solution.lengthOfLastWord("abc def"))
    }

    @Test
    fun lengthOfLastWordEdgeCases() {
        // If the last word does not exist, return 0.
        assertEquals(0, solution.lengthOfLastWord(""))
        assertEquals(0, solution.lengthOfLastWord("  "))

        // A word is defined as a character sequence consisting of non-space characters only.
        assertEquals(3, solution.lengthOfLastWord("abc "))
        assertEquals(3, solution.lengthOfLastWord(" abc"))
        assertEquals(3, solution.lengthOfLastWord("   abc "))
    }

}