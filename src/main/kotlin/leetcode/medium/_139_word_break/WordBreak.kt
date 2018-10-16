package leetcode.medium._139_word_break

/**
 * 139 - https://leetcode.com/problems/word-break/
 */
class Solution {
    /**
     * Brute-force, without memoization.
     * Time: O(2^n)
     * Space: O(n)
     */
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        if (s.isEmpty()) return true

        val matchingPrefixes = wordDict.filter { s.startsWith(it) }

        return matchingPrefixes.any { prefix ->
            val afterPrefix = s.drop(prefix.length)
            wordBreak(afterPrefix, wordDict)
        }
    }
}

class SolutionTwo {
    /**
     * With memoization.
     * Time: O(n^3)
     * Space: O(n^2)
     */
    fun wordBreak(s: String, wordDict: List<String>): Boolean = wordBreak(s, wordDict, hashMapOf())

    private fun wordBreak(s: String, wordDict: List<String>, cache: MutableMap<String, Boolean>): Boolean {
        if (s.isEmpty()) return true

        val matchingPrefixes = wordDict.filter { s.startsWith(it) }

        return matchingPrefixes.any { prefix ->
            val afterPrefix = s.drop(prefix.length)
            if (!cache.contains(afterPrefix)) {
                cache[afterPrefix] = wordBreak(afterPrefix, wordDict, cache)
            }
            cache[afterPrefix]!!
        }
    }
}