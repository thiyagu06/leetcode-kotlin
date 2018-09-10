package leetcode.hard._140_word_break_ii

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

        if (unmatched.isRepeatingChar()) {
            (1 until unmatched.length / 2).forEach { i ->
                val j = unmatched.length - i
                val a = unmatched.substring(0 until i)
                val b = unmatched.substring(j until unmatched.length)
                if (a.isRepeatingChar() && b.isRepeatingChar() && cache.contains(a) && cache.contains(b)) {
                    cache.getOrPut(key = a + b, defaultValue = { mutableListOf() })
                    cache[a + b]!!.add(
                            combine(cache[a]!!.first(), cache[b]!!.first()) + combine(cache[b]!!.first(), cache[a]!!.first()).distinct()
                    )
                }
            }
        }

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

    private fun combine(list1: List<String>, list2: List<String>): List<String> {
        return list1.fold(arrayListOf()) { acc, el1 ->
            list2.forEach { el2 ->
                acc.apply { acc.add("$el1 $el2") }
            }
            acc
        }
    }

    private fun String.isRepeatingChar() = all { it == first() }
}
