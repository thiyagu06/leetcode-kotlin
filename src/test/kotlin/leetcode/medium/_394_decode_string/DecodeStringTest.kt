package leetcode.medium._394_decode_string

import org.junit.Test
import kotlin.test.assertEquals

class DecodeStringTest {

    private val solution = Solution()
    private val solutionTwo = SolutionTwo()
    private val solutionThree = SolutionThree()

    @Test
    fun decodeString() {
        assertEquals("cc", solution.decodeString("2[c]"))
        assertEquals("aaabcbc", solution.decodeString("3[a]2[bc]"))
        assertEquals("abcabccdcdcdef", solution.decodeString("2[abc]3[cd]ef"))
        assertEquals("codecodecodecodecodecodecodecodecodecode", solution.decodeString("10[code]"))
        assertEquals("accaccacc", solution.decodeString("3[a2[c]]"))
        assertEquals("aaabFFFFcbFFFFc", solution.decodeString("3[a]2[b4[F]c]"))
        assertEquals("bFFFFcbFFFFcaaa", solution.decodeString("2[b4[F]c]3[a]"))
        assertEquals(
            "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef",
            solution.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef")
        )
    }

    @Test
    fun parseFirstK() {
        assertEquals(1, solution.parseFirstK("ef"))
        assertEquals(1, solution.parseFirstK("1[f]"))
        assertEquals(3, solution.parseFirstK("3[a]"))
        assertEquals(3, solution.parseFirstK("3[abc]"))
        assertEquals(3, solution.parseFirstK("3[a2[bc]]"))
        assertEquals(10, solution.parseFirstK("10[a]"))
        assertEquals(9999, solution.parseFirstK("9999[a]"))
    }

    @Test(expected = IllegalArgumentException::class)
    fun parseFirstKInvalid() {
        solution.parseFirstK("[abc]")
    }

    @Test
    fun readFirstEncodedString() {
        assertEquals(Pair("ef", ""), solution.readFirstEncodedString("ef"))
        assertEquals(Pair("ef", "[a2[c]]"), solution.readFirstEncodedString("ef[a2[c]]"))
        assertEquals(Pair("a", ""), solution.readFirstEncodedString("[a]"))
        assertEquals(Pair("abc", ""), solution.readFirstEncodedString("[abc]"))
        assertEquals(Pair("a2[c]", ""), solution.readFirstEncodedString("[a2[c]]"))
        assertEquals(Pair("b4[F]c", ""), solution.readFirstEncodedString("[b4[F]c]"))
        assertEquals(Pair("b4[F]c", "[a2[c]]"), solution.readFirstEncodedString("[b4[F]c][a2[c]]"))
        assertEquals(Pair("b", "4[F]c"), solution.readFirstEncodedString("b4[F]c"))
        assertEquals(Pair("a", "2[c]a2[c]a2[c]"), solution.readFirstEncodedString("a2[c]a2[c]a2[c]"))
        assertEquals(Pair("abc", "3[cd]ef"), solution.readFirstEncodedString("[abc]3[cd]ef"))
        assertEquals(Pair("a2[c]", ""), solution.readFirstEncodedString("[a2[c]]"))
    }

    @Test
    fun decodeString2() {
        assertEquals("cc", solutionTwo.decodeString("2[c]"))
        assertEquals("aaabcbc", solutionTwo.decodeString("3[a]2[bc]"))
        assertEquals("abcabccdcdcdef", solutionTwo.decodeString("2[abc]3[cd]ef"))
        assertEquals("codecodecodecodecodecodecodecodecodecode", solutionTwo.decodeString("10[code]"))
        assertEquals("accaccacc", solutionTwo.decodeString("3[a2[c]]"))
        assertEquals("aaabFFFFcbFFFFc", solutionTwo.decodeString("3[a]2[b4[F]c]"))
        assertEquals(
            "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef",
            solutionTwo.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef")
        )
    }

    @Test
    fun denestInput() {
        assertEquals("aaa", solutionTwo.denestInput("3[a]"))
        assertEquals("aaabcbc", solutionTwo.denestInput("3[a]2[bc]"))
        assertEquals("ef", solutionTwo.denestInput("ef"))
        assertEquals("aaaef", solutionTwo.denestInput("3[a]ef"))
        assertEquals("abcabccdcdcdef", solutionTwo.denestInput("2[abc]3[cd]ef"))
        assertEquals("aaab4[F]cb4[F]c", solutionTwo.denestInput("3[a]2[b4[F]c]"))
    }

    @Test
    fun decodeString3() {
        assertEquals("cc", solutionThree.decodeString("2[c]"))
        assertEquals("aaabcbc", solutionThree.decodeString("3[a]2[bc]"))
        assertEquals("abcabccdcdcdef", solutionThree.decodeString("2[abc]3[cd]ef"))
        assertEquals("codecodecodecodecodecodecodecodecodecode", solutionThree.decodeString("10[code]"))
        assertEquals("accaccacc", solutionThree.decodeString("3[a2[c]]"))
        assertEquals("aaabFFFFcbFFFFc", solutionThree.decodeString("3[a]2[b4[F]c]"))
        assertEquals(
            "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef",
            solutionThree.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef")
        )
    }
}