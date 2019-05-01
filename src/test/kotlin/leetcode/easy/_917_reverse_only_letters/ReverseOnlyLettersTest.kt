package leetcode.easy._917_reverse_only_letters

import org.junit.Test

import kotlin.test.assertEquals

class ReverseOnlyLettersTest {

    private val solution = Solution()

    @Test
    fun reverseOnlyLetters() {
        assertEquals("dc-ba", solution.reverseOnlyLetters("ab-cd"))
        assertEquals("j-Ih-gfE-dCba", solution.reverseOnlyLetters("a-bC-dEf-ghIj"))
        assertEquals("Qedo1ct-eeLg=ntse-T!", solution.reverseOnlyLetters("Test1ng-Leet=code-Q!"))
    }
}