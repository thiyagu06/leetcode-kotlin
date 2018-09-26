package leetcode.medium._139_word_break

/**
 * 139 - https://leetcode.com/problems/word-break/
 */
class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val cache = mutableMapOf<String, Boolean>()
        wordDict.forEach { word ->
            cache[word] = true
        }
        return wordBreak(unmatched = s, wordDict = wordDict.toSet(), cache = cache)
    }

    private fun wordBreak(unmatched: String, wordDict: Set<String>, cache: MutableMap<String, Boolean> = mutableMapOf()): Boolean {
        if (unmatched.isEmpty()) {
            cache[unmatched] = true
            return true
        }

        val prefixMatches = wordDict.filter { unmatched.startsWith(it) }
        prefixMatches.forEach { prefix ->
            val afterPrefix = unmatched.drop(prefix.length)

            when (cache[afterPrefix]) {
                true -> return true
                false -> return@forEach
                else -> {
                    val isSolution = wordBreak(unmatched = afterPrefix, wordDict = wordDict, cache = cache)
                    cache[afterPrefix] = isSolution

                    if (isSolution) return true
                }
            }
        }

        return false
    }
}
