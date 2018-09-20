package leetcode.medium._890_find_and_replace_pattern

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class FindAndReplacePatternTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun findAndReplacePattern() {
        assertEquals(
            listOf("mee", "aqq"),
            solution.findAndReplacePattern(
                words = arrayOf("abc", "deq", "mee", "aqq", "dkd", "ccc"),
                pattern = "abb"
            )
        )

        assertEquals(
            emptyList<String>(),
            solution.findAndReplacePattern(
                words = arrayOf("abc", "deq", "dkd", "ccc"),
                pattern = "abb"
            )
        )

        // Order matters - permutation
        assertEquals(
            emptyList<String>(),
            solution.findAndReplacePattern(
                words = arrayOf("bba", "bab"),
                pattern = "abb"
            )
        )
    }

    @Test
    fun `findAndReplacePattern - differing lengths`() {
        // according to LeetCode, these are matches, although it also guarantees that
        // 1 <= pattern.length = words[i].length <= 20

        // pattern.length < words[i]
        assertEquals(
            listOf("abba"),
            solution.findAndReplacePattern(
                words = arrayOf("abba"),
                pattern = "abb"
            )
        )

        assertEquals(
            listOf("abbc"),
            solution.findAndReplacePattern(
                words = arrayOf("abbc"),
                pattern = "abb"
            )
        )

        // pattern.length > words[i]
        assertEquals(
            listOf("abb"),
            solution.findAndReplacePattern(
                words = arrayOf("abb"),
                pattern = "abba"
            )
        )

        assertEquals(
            listOf("abb"),
            solution.findAndReplacePattern(
                words = arrayOf("abb"),
                pattern = "abbc"
            )
        )
    }

    @Test
    fun matchesPattern() {
        assertTrue("abb".matchesPattern("abb"))
        assertTrue("xyy".matchesPattern("abb"))
        assertTrue("xyz".matchesPattern("abc"))
        assertTrue("zyx".matchesPattern("abc"))
        assertTrue("xyyz".matchesPattern("abbc"))
        assertTrue("baa".matchesPattern("abb"))
        assertTrue("uvwxyzuvwxyzuvwxyz".matchesPattern("abcdefabcdefabcdef"))

        assertFalse("bab".matchesPattern("abb"))
        assertFalse("bba".matchesPattern("abb"))
        assertFalse("xzzz".matchesPattern("abbc"))

        // surjective, !injective -> !bijective
        assertFalse("abc".matchesPattern("abb"))
        assertFalse("deq".matchesPattern("abb"))

        // Unequal length
        assertTrue("abb".matchesPattern("abba"))
        assertTrue("abb".matchesPattern("abbc"))
        assertTrue("xyy".matchesPattern("abbsdaofijqwijfqiowjfasidjfoq"))
    }


    @Test
    fun findAndReplacePattern2() {
        assertEquals(
            listOf("mee", "aqq"),
            solution2.findAndReplacePattern(
                words = arrayOf("abc", "deq", "mee", "aqq", "dkd", "ccc"),
                pattern = "abb"
            )
        )

        assertEquals(
            emptyList<String>(),
            solution2.findAndReplacePattern(
                words = arrayOf("abc", "deq", "dkd", "ccc"),
                pattern = "abb"
            )
        )

        // Order matters - permutation
        assertEquals(
            emptyList<String>(),
            solution2.findAndReplacePattern(
                words = arrayOf("bba", "bab"),
                pattern = "abb"
            )
        )
    }

    @Test
    fun `findAndReplacePattern - differing lengths - SolutionTwo`() {
        // according to LeetCode, these are matches, although it also guarantees that
        // 1 <= pattern.length = words[i].length <= 20

        // pattern.length < words[i]
        assertEquals(
            listOf("abba"),
            solution2.findAndReplacePattern(
                words = arrayOf("abba"),
                pattern = "abb"
            )
        )

        assertEquals(
            listOf("abbc"),
            solution2.findAndReplacePattern(
                words = arrayOf("abbc"),
                pattern = "abb"
            )
        )

        // pattern.length > words[i]
        assertEquals(
            listOf("abb"),
            solution2.findAndReplacePattern(
                words = arrayOf("abb"),
                pattern = "abba"
            )
        )

        assertEquals(
            listOf("abb"),
            solution2.findAndReplacePattern(
                words = arrayOf("abb"),
                pattern = "abbc"
            )
        )
    }


    @Test
    fun matchesPattern2() {
        assertTrue("abb".matchesPattern2("abb"))
        assertTrue("xyy".matchesPattern2("abb"))
        assertTrue("xyz".matchesPattern2("abc"))
        assertTrue("zyx".matchesPattern2("abc"))
        assertTrue("xyyz".matchesPattern2("abbc"))
        assertTrue("baa".matchesPattern2("abb"))
        assertTrue("uvwxyzuvwxyzuvwxyz".matchesPattern2("abcdefabcdefabcdef"))

        assertFalse("bab".matchesPattern2("abb"))
        assertFalse("bba".matchesPattern2("abb"))
        assertFalse("xzzz".matchesPattern2("abbc"))

        // surjective, !injective -> !bijective
        assertFalse("abc".matchesPattern2("abb"))
        assertFalse("deq".matchesPattern2("abb"))

        // Unequal length
        assertTrue("abb".matchesPattern2("abba"))
        assertTrue("abb".matchesPattern2("abbc"))
        assertTrue("xyy".matchesPattern2("abbsdaofijqwijfqiowjfasidjfoq"))
    }
}