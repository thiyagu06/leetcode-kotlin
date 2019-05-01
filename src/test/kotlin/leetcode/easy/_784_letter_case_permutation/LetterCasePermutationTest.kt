package leetcode.easy._784_letter_case_permutation

import kotlin.test.assertEquals
import org.junit.Test

class LetterCasePermutationTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val solution3 = SolutionThree()

    @Test
    fun letterCasePermutation() {
        assertEquals(
            listOf("a1b2", "a1B2", "A1b2", "A1B2").sorted(),
            solution.letterCasePermutation("a1b2").sorted()
        )

        assertEquals(
            listOf("abc", "abC", "aBc", "aBC", "Abc", "AbC", "ABc", "ABC").sorted(),
            solution.letterCasePermutation("abc").sorted()
        )

        assertEquals(
            listOf("3z4", "3Z4").sorted(),
            solution.letterCasePermutation("3z4").sorted()
        )

        assertEquals(
            listOf("12345").sorted(),
            solution.letterCasePermutation("12345").sorted()
        )
    }

    @Test
    fun letterCasePermutation2() {
        assertEquals(
            listOf("a1b2", "a1B2", "A1b2", "A1B2").sorted(),
            solution2.letterCasePermutation("a1b2").sorted()
        )

        assertEquals(
            listOf("abc", "abC", "aBc", "aBC", "Abc", "AbC", "ABc", "ABC").sorted(),
            solution2.letterCasePermutation("abc").sorted()
        )

        assertEquals(
            listOf("3z4", "3Z4").sorted(),
            solution2.letterCasePermutation("3z4").sorted()
        )

        assertEquals(
            listOf("12345").sorted(),
            solution2.letterCasePermutation("12345").sorted()
        )
    }

    @Test
    fun letterCasePermutation3() {
        assertEquals(
            listOf("a1b2", "a1B2", "A1b2", "A1B2").sorted(),
            solution3.letterCasePermutation("a1b2").sorted()
        )

        assertEquals(
            listOf("abc", "abC", "aBc", "aBC", "Abc", "AbC", "ABc", "ABC").sorted(),
            solution3.letterCasePermutation("abc").sorted()
        )

        assertEquals(
            listOf("3z4", "3Z4").sorted(),
            solution3.letterCasePermutation("3z4").sorted()
        )

        assertEquals(
            listOf("12345").sorted(),
            solution3.letterCasePermutation("12345").sorted()
        )
    }
}