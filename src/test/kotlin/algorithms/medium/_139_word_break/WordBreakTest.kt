package algorithms.medium._139_word_break

import extensions.roundedToNDecimalPlaces
import org.junit.Test

import org.junit.Assert.*
import kotlin.math.round
import kotlin.system.measureTimeMillis

class WordBreakTest {

    private val solution = Solution()

    @Test
    fun wordBreak() {
        val times = arrayListOf<Long>()
        val runs = 20
        (1..runs).forEach {
            val ms = measureTimeMillis {
                assertTrue(solution.wordBreak(s = "a", wordDict = listOf("a")))
                assertFalse(solution.wordBreak(s = "leetcode", wordDict = listOf("leet")))
                assertTrue(solution.wordBreak(s = "leetcode", wordDict = listOf("leet", "code")))
                assertTrue(solution.wordBreak(s = "leetcode", wordDict = listOf("leet", "code", "ninja")))
                assertTrue(solution.wordBreak(s = "leetcodeninja", wordDict = listOf("leet", "code", "ninja")))
                assertTrue(solution.wordBreak(s = "leetcode", wordDict = listOf("code", "leet")))

                /* Can a word be used more than once? => Yes */
                assertTrue(solution.wordBreak(s = "aa", wordDict = listOf("a")))
                assertTrue(solution.wordBreak(s = "leetleetcode", wordDict = listOf("leet", "code")))

                /* Are digits, punctuation, whitespace, etc. allowed? => Yes */
                assertTrue(solution.wordBreak(s = "$1.99", wordDict = listOf("$1", ".99")))
                assertTrue(solution.wordBreak(s = "coca-cola$1.99", wordDict = listOf("coca", "cola", "-", "$1", ".99")))
                assertTrue(solution.wordBreak(s = "coca-cola $1.99", wordDict = listOf("coca", "cola", " ", "-", "$1", ".99")))
                assertFalse(solution.wordBreak(s = "coca-cola $1.99", wordDict = listOf("coca", "cola", "-", "$1", ".99")))

                /* Multiple valid solutions */
                assertTrue(solution.wordBreak(s = "leetcode", wordDict = listOf("leet", "code", "leetc", "ode")))

                /* More than 1 first selection, but only 1 yields an answer */
                assertTrue(solution.wordBreak(s = "leetcode", wordDict = listOf("leetc", "od", "leet", "code")))
                assertTrue(solution.wordBreak(s = "leetcode", wordDict = listOf("leet", "code", "leetc", "od")))
                assertTrue(solution.wordBreak(s = "leetcoder", wordDict = listOf("leet", "coder", "leetc", "ode")))
            }
            times += ms
        }
        val adjustedTimes = times.drop(2)   // 1st one or two affected by test startup
        println("times: $times")
        println("adjustedTimes: $adjustedTimes")
        println("average run: ${adjustedTimes.average().roundedToNDecimalPlaces(2)}")
    }
}