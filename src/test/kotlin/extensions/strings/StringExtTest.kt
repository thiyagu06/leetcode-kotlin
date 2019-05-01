package extensions.strings

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.lang.StringBuilder

class StringExtTest {

    @Test
    fun isAllCaps() {
        assertTrue("FOOBAR".isAllCaps)
        assertFalse("FOObar".isAllCaps)
        assertFalse("foobar".isAllCaps)
        assertFalse("FOOBAR 99".isAllCaps)
    }

    @Test
    fun isAllLowercase() {
        assertFalse("FOOBAR".isAllLowercase)
        assertFalse("FOObar".isAllLowercase)
        assertTrue("foobar".isAllLowercase)
        assertFalse("foobar 99".isAllLowercase)
    }

    @Test
    fun repeated() {
        assertEquals("ABCABCABC", "ABC".repeated(3))
        assertEquals("XYZXYZXYZXYZ", StringBuilder("XYZ").repeated(4))
    }

    @Test
    fun isPalindrome() {
        assertTrue("".isPalindrome())
        assertTrue("a".isPalindrome())
        assertTrue("aa".isPalindrome())
        assertTrue("aba".isPalindrome())
        assertTrue("a-b-a".isPalindrome())

        assertFalse("ab".isPalindrome())
        assertFalse("abb".isPalindrome())
        assertFalse("a-ba".isPalindrome())
    }

    @Test
    fun headAndTail() {
        assertEquals(('f' to "oobar"), "foobar".headAndTail)
        assertEquals(('f' to ""), "f".headAndTail)
        assertEquals((null to ""), "".headAndTail)
    }

    @Test
    fun reverseCharsInRange() {
        assertEquals("hlleo", "hello".reverseCharsInRange(1..3))
        assertEquals("niltok", "kotlin".reverseCharsInRange(0..5))
        assertEquals("kotlin", "kotlin".reverseCharsInRange(0..0))
        assertEquals("ktolin", "kotlin".reverseCharsInRange(1..2))
    }

    @Test(expected = StringIndexOutOfBoundsException::class)
    fun `reverseCharsInRange throws exception when range is invalid`() {
        assertEquals("kotlni", "kotlin".reverseCharsInRange(4..7))
    }

    @Test
    fun swappingCharsAt() {
        assertEquals("notlik", "kotlin".swappingCharsAt(0, 5))
        assertEquals("kntlio", "kotlin".swappingCharsAt(1, 5))
        assertEquals("kitlon", "kotlin".swappingCharsAt(1, 4))
        assertEquals("koltin", "kotlin".swappingCharsAt(2, 3))
        assertEquals("kotlin", "kotlin".swappingCharsAt(3, 3))
    }

    @Test
    fun characterFrequencies() {
        assertEquals(
            mapOf('k' to 1, 'o' to 1, 't' to 1, 'l' to 1, 'i' to 1, 'n' to 1),
            "kotlin".characterFrequencies()
        )
        assertEquals(mapOf('f' to 1, 'o' to 2), "foo".characterFrequencies())
        assertEquals(mapOf('f' to 1, 'o' to 2), "FOo".characterFrequencies(caseSensitive = false))
        assertEquals(mapOf('F' to 1, 'o' to 1, 'O' to 1), "FOo".characterFrequencies())
        assertEquals(mapOf('F' to 1, 'o' to 1, 'O' to 1), "FOo".characterFrequencies(caseSensitive = true))

    }

    @Test
    fun characterIndices() {
        assertEquals(
            mapOf(
                'l' to listOf(0, 4),
                'o' to listOf(1, 9),
                'v' to listOf(2),
                'e' to listOf(3, 5, 6, 11),
                't' to listOf(7),
                'c' to listOf(8),
                'd' to listOf(10)
            ),
            "loveleetcode".characterIndices()
        )
    }

    @Test
    fun distinctChars() {
        assertEquals(listOf('f', 'o', 'b', 'a', 'r'), "foobar".distinctChars())
        assertEquals(listOf('k', 'o', 't', 'l', 'i', 'n'), "kotlin".distinctChars())
        assertEquals(listOf('v', 'o', 'd'), "voodoo".distinctChars())
    }

    @Test
    fun toSortedChars() {
        assertEquals(listOf('a', 'b', 'c'), "bac".toSortedChars())
        assertEquals(listOf('a', 'a', 'a', 'b', 'b', 'b', 'c', 'c', 'd', 'e'), "cbaebabacd".toSortedChars())
        assertEquals(listOf(' ', ' ', 'a', 'b', 'c'), "b a c".toSortedChars())
    }

    @Test
    fun toSortedString() {
        assertEquals("abc", "bac".toSortedString())
        assertEquals("aaabbbccde", "cbaebabacd".toSortedString())
        assertEquals("  abc", "b a c".toSortedString())
        assertEquals("!!#$@", "!@#$!".toSortedString())
        assertEquals("14789", "19748".toSortedString())
        assertEquals("14789abc", "19c7a4b8".toSortedString())
        assertEquals("14789ABc", "19c7A4B8".toSortedString())
        assertEquals("\t !$&*14789abc", "1 *&9c7a\t4b!$8".toSortedString())
    }

    @Test
    fun isAnagramOf() {
        assertTrue("anagram".isAnagramOf("nagaram"))
        assertTrue("rac".isAnagramOf("car"))
        assertFalse("rat".isAnagramOf("car"))
        assertFalse("aa".isAnagramOf("a"))
    }

    @Test
    fun substrings() {
        assertEquals(
            listOf("", "a", "ab", "abc", "b", "bc", "c"),
            "abc".substrings()
        )

        assertEquals(
            listOf(
                "",
                "f", "fo", "foo", "foob", "fooba", "foobar",
                "o", "oo", "oob", "ooba", "oobar",
                "o", "ob", "oba", "obar",
                "b", "ba", "bar",
                "a", "ar",
                "r"
            ),
            "foobar".substrings()
        )
    }

    @Test
    fun permutations() {
        assertEquals(emptySet<String>(), "".permutations())
        assertEquals(setOf("a"), "a".permutations())
        assertEquals(setOf("ab", "ba"), "ab".permutations())
        assertEquals(setOf("abc", "acb", "bac", "bca", "cab", "cba"), "abc".permutations())
        assertEquals(
            setOf(
                "abcd", "abdc", "acbd", "acdb", "adbc", "adcb",
                "bacd", "badc", "bcad", "bcda", "bdac", "bdca",
                "cabd", "cadb", "cbad", "cbda", "cdab", "cdba",
                "dabc", "dacb", "dbac", "dbca", "dcab", "dcba"
            ),
            "abcd".permutations()
        )
        assertEquals(
            setOf("aba", "aab", "baa"),
            "aba".permutations()
        )
    }

    @Test
    fun `replaceLast - Char`() {
        assertEquals("foobaz", "foobar".replaceLast(oldChar = 'r', newChar = 'z', ignoreCase = false))
        assertEquals("foobaz", "foobaR".replaceLast(oldChar = 'r', newChar = 'z', ignoreCase = true))
        assertEquals("foobaR", "foobaR".replaceLast(oldChar = 'r', newChar = 'z', ignoreCase = false))
        assertEquals("foobaz", "foobaR".replaceLast(oldChar = 'r', newChar = 'z', ignoreCase = true))
        assertEquals("foobar", "foobar".replaceLast(oldChar = 'r', newChar = 'z', startIndex = 4))
    }

    @Test
    fun `replaceLast - String`() {
        assertEquals("(()())__abcxyz", "(()())()abcxyz".replaceLast(oldValue = "()", newValue = "__"))
        assertEquals("(()())()zyxcba", "(()())()abcxyz".replaceLast(oldValue = "abcxyz", newValue = "zyxcba"))
        assertEquals(
            "(()())()CBAxyz",
            "(()())()abcxyz".replaceLast(oldValue = "ABC", newValue = "CBA", ignoreCase = true)
        )
        assertEquals(
            "(()())()abcxyz",
            "(()())()abcxyz".replaceLast(oldValue = "ABC", newValue = "CBA", ignoreCase = false)
        )
        assertEquals(
            "(()())()abcxyz",
            "(()())()abcxyz".replaceLast(oldValue = "abcxyz", newValue = "zyxcba", startIndex = 4)
        )
    }


    @Test
    fun longestCommonSubstring() {
        kotlin.test.assertEquals("", longestCommonSubstring("", ""))
        kotlin.test.assertEquals("", longestCommonSubstring("A", ""))
        kotlin.test.assertEquals("", longestCommonSubstring("", "A"))
        kotlin.test.assertEquals("A", longestCommonSubstring("A", "A"))
        kotlin.test.assertEquals("A", longestCommonSubstring("ABC", "A"))
        kotlin.test.assertEquals("AB", longestCommonSubstring("ABC", "BABA"))
        kotlin.test.assertEquals("ABCABC", longestCommonSubstring("ABCABCA", "CABCABC"))
        kotlin.test.assertEquals("ABCABC", longestCommonSubstring("CABCABC", "ABCABCA"))
        kotlin.test.assertEquals("abcd", longestCommonSubstring("abcdxyz", "xyzabcd"))
        kotlin.test.assertEquals("abcdez", longestCommonSubstring("zxabcdezy", "yzabcdezx"))
        kotlin.test.assertEquals("ABC", longestCommonSubstring("ABC", "ABCD"))
        kotlin.test.assertTrue(longestCommonSubstring("ABAB", "BABA") in setOf("ABA", "BAB"))
    }

    @Test
    fun lcs() {
        kotlin.test.assertTrue(lcs("ABCBDAB", "BDCABA") in setOf("BCBA", "BDAB"))
        kotlin.test.assertTrue(lcs("GTTCCTAATA", "CGATAATTGAGA") in setOf("GTTTAA", "CTAATA"))
        assertEquals("MJAU", lcs("XMJYAUZ", "MZJAWXU"))
        assertEquals("BBCDA", lcs("ABABCDA", "BBCDAXY"))
    }
}
