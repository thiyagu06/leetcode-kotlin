package algorithms.easy._557_reverse_words_in_string_III

import org.junit.Test

import org.junit.Assert.*

class ReverseWordsInAStringTest {

    private val solution = Solution()

    @Test
    fun reverseWords() {
        assertEquals("s'teL ekat edoCteeL tsetnoc", solution.reverseWords("Let's take LeetCode contest"))
    }
}