package algorithms.hard._140_word_break_ii

/**
 * 140 - https://leetcode.com/problems/word-break-ii/description/
 */
class Solution {
    /**
     * TODO - exceeds time limit for long (repeating only?) input
     * Time: O(?)
     * Space: O(?)
     */
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        if (wordDict.isEmpty()) return emptyList()

        /* Prefill cache with words from dictionary */
        val cache = mutableMapOf<String, MutableList<List<String>>>()
        wordDict.forEach { word ->
            cache.getOrPut(key = word, defaultValue = { mutableListOf() })
            cache[word]!!.add(listOf(word))
        }

        val solutions = wordBreak(
            matched = "",
            unmatched = s,
            wordDict = wordDict.toSet(),
            cache = cache
        )[s] ?: emptyList()

        return solutions.map { it.joinToString(" ") }
    }

    private fun wordBreak(
            matched: String,
            unmatched: String,
            wordDict: Set<String>,
            cache: MutableMap<String, MutableList<List<String>>>,
            selectedWords: MutableList<String> = arrayListOf()
    ): Map<String, List<List<String>>> {

        /* TODO
val x1 = ["a"]
val x2 = ["aa", "a a"]
val x3 = ["a a a", "aa a", "a aa", "aaa"]
val x4 = ["a a a a", "aa a a", "a aa a", "aaa a", "a a aa", "aa aa", "a aaa", "aaaa"]

solution for "aaaa":
(combine(x1, x3) + combine(x2, x2) + combine(x3, x1) + x4).distinct()
         */


        val matchingPrefixes = wordDict.filter { unmatched.startsWith(it) }
        matchingPrefixes.forEach { prefix ->

            val prefixSolution: List<String> = selectedWords + prefix
            cache.getOrPut(key = matched + prefix, defaultValue = { mutableListOf() })
            if (!cache[matched + prefix]!!.contains(prefixSolution)) {
                cache[matched + prefix]!!.add(prefixSolution)
            }

            wordBreak(
                    matched = if (matched.isEmpty()) prefix else matched + prefix,
                    unmatched = unmatched.drop(prefix.length),
                    wordDict = wordDict,
                    cache = cache,
                    selectedWords = (selectedWords + prefix).toMutableList()
            )

        }
        return cache
    }

    private fun longestPrefixSolved(str: String, cache: MutableMap<String, MutableList<List<String>>>): String =
        (0..str.length).fold("") { longestPrefix, i ->
            val prefix = str.take(i)
            if (!cache.contains(prefix)) longestPrefix
            else prefix
        }

    private fun combine(list1: List<String>, list2: List<String>): List<String> {
        return list1.fold(arrayListOf()) { acc, el1 ->
            list2.forEach { el2 ->
                acc.apply { acc.add(el1 + " " + el2) }
            }
            acc
        }
    }
}
