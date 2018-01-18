package algorithms.hard._140_word_break_ii

import extensions.math.roundedToNDecimalPlaces
import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Test
import kotlin.system.measureTimeMillis

class WordBreakIITest {

    private val solution = Solution()

    @Test
    fun wordBreak() {
        assertEquals(listOf("leet code", "leetc ode").toSet(), solution.wordBreak("leetcode", listOf("leet", "code", "leetc", "ode")).toSet())
        assertEquals(listOf("leet coder").toSet(), solution.wordBreak("leetcoder", listOf("leet", "coder", "leetc", "ode")).toSet())
        assertEquals(listOf("cats and dog", "cat sand dog").toSet(), solution.wordBreak("catsanddog", listOf("cat", "cats", "and", "sand", "dog")).toSet())
        assertEquals(emptyList<String>(), solution.wordBreak("a", emptyList()))
        assertEquals(emptyList<String>(), solution.wordBreak("a", listOf("b")))
        assertEquals(listOf("a").toSet(), solution.wordBreak("a", listOf("a")).toSet())
        assertEquals(listOf("a a").toSet(), solution.wordBreak("aa", listOf("a")).toSet())
        assertEquals(listOf("a a", "aa").toSet(), solution.wordBreak("aa", listOf("a", "aa")).toSet())
        assertEquals(listOf("a a a", "aa a", "a aa", "aaa").toSet(),
                solution.wordBreak("aaa", listOf("a", "aa", "aaa")).toSet())
        assertEquals(listOf("a a a a", "aa a a", "a aa a", "aaa a", "a a aa", "aa aa", "a aaa", "aaaa").toSet(),
                solution.wordBreak("aaaa", listOf("a", "aa", "aaa", "aaaa")).toSet())
    }

    @Test
    fun wordBreakLongRepeating() {
        assertEquals(listOf("a a a a a a a a", "aa a a a a a a", "a aa a a a a a", "aaa a a a a a", "a a aa a a a a",
                "aa aa a a a a", "a aaa a a a a", "aaaa a a a a", "a a a aa a a a", "aa a aa a a a", "a aa aa a a a",
                "aaa aa a a a", "a a aaa a a a", "aa aaa a a a", "a aaaa a a a", "a a a a aa a a", "aa a a aa a a",
                "a aa a aa a a", "aaa a aa a a", "a a aa aa a a", "aa aa aa a a", "a aaa aa a a", "aaaa aa a a", "a a a aaa a a",
                "aa a aaa a a", "a aa aaa a a", "aaa aaa a a", "a a aaaa a a", "aa aaaa a a", "a a a a a aa a", "aa a a a aa a",
                "a aa a a aa a", "aaa a a aa a", "a a aa a aa a", "aa aa a aa a", "a aaa a aa a", "aaaa a aa a", "a a a aa aa a",
                "aa a aa aa a", "a aa aa aa a", "aaa aa aa a", "a a aaa aa a", "aa aaa aa a", "a aaaa aa a", "a a a a aaa a",
                "aa a a aaa a", "a aa a aaa a", "aaa a aaa a", "a a aa aaa a", "aa aa aaa a", "a aaa aaa a", "aaaa aaa a", "a a a aaaa a",
                "aa a aaaa a", "a aa aaaa a", "aaa aaaa a", "a a a a a a aa", "aa a a a a aa", "a aa a a a aa", "aaa a a a aa", "a a aa a a aa",
                "aa aa a a aa", "a aaa a a aa", "aaaa a a aa", "a a a aa a aa", "aa a aa a aa", "a aa aa a aa", "aaa aa a aa", "a a aaa a aa",
                "aa aaa a aa", "a aaaa a aa", "a a a a aa aa", "aa a a aa aa", "a aa a aa aa", "aaa a aa aa", "a a aa aa aa", "aa aa aa aa",
                "a aaa aa aa", "aaaa aa aa", "a a a aaa aa", "aa a aaa aa", "a aa aaa aa", "aaa aaa aa", "a a aaaa aa", "aa aaaa aa",
                "a a a a a aaa", "aa a a a aaa", "a aa a a aaa", "aaa a a aaa", "a a aa a aaa", "aa aa a aaa", "a aaa a aaa", "aaaa a aaa",
                "a a a aa aaa", "aa a aa aaa", "a aa aa aaa", "aaa aa aaa", "a a aaa aaa", "aa aaa aaa", "a aaaa aaa", "a a a a aaaa",
                "aa a a aaaa", "a aa a aaaa", "aaa a aaaa", "a a aa aaaa", "aa aa aaaa", "a aaa aaaa", "aaaa aaaa").toSet(),
                solution.wordBreak("aaaaaaaa", listOf("a", "aa", "aaa", "aaaa")).toSet())
//        assertEquals(emptyList<String>(), solution.wordBreak(
//                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
//                listOf("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")))
    }

    @Ignore
    @Test
    fun wordBreakTimed() {
        val times = arrayListOf<Long>()
        val runs = 10
        (1..runs).forEach {
            val ms = measureTimeMillis {
                wordBreak()
            }
            times += ms
        }
        val adjustedTimes = times.drop(2)   // 1st one or two affected by test startup
        println("times: $times")
        println("adjustedTimes: $adjustedTimes")
        println("average run: ${adjustedTimes.average().roundedToNDecimalPlaces(2)}")
    }
}