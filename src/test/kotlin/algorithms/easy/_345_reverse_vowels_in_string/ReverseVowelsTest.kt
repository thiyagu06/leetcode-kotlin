package algorithms.easy._345_reverse_vowels_in_string

import org.junit.Test

import org.junit.Assert.*

class ReverseVowelsTest {

    private val solution = Solution()

    @Test
    fun reverseVowels() {
        assertEquals("holle", solution.reverseVowels("hello"))
        assertEquals("leetcode", solution.reverseVowels("leotcede"))
    }

}
