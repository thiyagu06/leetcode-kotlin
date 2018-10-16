package leetcode.hard._140_word_break_ii

/**
 * 140 - https://leetcode.com/problems/word-break-ii/
 */
class Solution {
    /**
     * http://tinyurl.com/ybwqtkw5
     * Time: O(?)
     * Space: O(?)
     */
    fun wordBreak(s: String, wordDict: List<String>): List<String> = wordBreak(s, wordDict, hashMapOf()).toList()

    private fun wordBreak(
        s: String,
        wordDict: List<String>,
        memo: MutableMap<String, Set<String>>
    ): Set<String> =
        when {
            s in memo -> memo[s]!!
            s.isEmpty() -> emptySet()
            else -> {
                val results = hashSetOf<String>()
                val matchingPrefixes = wordDict.filter { s.startsWith(it) }

                for (prefix in matchingPrefixes) {
                    if (s.length == prefix.length) {    // Last word
                        results.add(prefix)
                    } else {
                        val restOfString = s.drop(prefix.length)
                        val restOfStringResult = wordBreak(restOfString, wordDict, memo)
                        val newResults = restOfStringResult.map {
                            "$prefix $it"
                        }
                        results.addAll(newResults)
                    }
                }

                memo[s] = results
                results
            }
        }
}