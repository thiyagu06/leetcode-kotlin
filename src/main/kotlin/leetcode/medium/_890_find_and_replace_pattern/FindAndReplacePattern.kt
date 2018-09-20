package leetcode.medium._890_find_and_replace_pattern

import extensions.chars.alphaIndex

class Solution {
    /**
     * Time: O(n * k) - where n is words.size, k is pattern.length. 1 <= n <= 50, 1 <= k <= 20
     * Space: O(n * k)
     */
    fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> = words.filter { word ->
        word.matchesPattern(pattern)
    }
}

/**
 * Time: O(n) - where n is words.size, 1 <= n <= 50
 * Space: O(k)
 *
 * Note: only checks the first min(length, pattern.length) characters
 * On LeetCode:
 * ["abb"], "abbc" -> ["abb"]
 * ["abbc"], "abb" -> ["abbc"]
 */
internal fun String.matchesPattern(pattern: String): Boolean {
    val xyMapping = mutableMapOf<Char, Char>()
    val yxMapping = mutableMapOf<Char, Char>()

    this.zip(pattern).forEach { (x, y) ->
        if (xyMapping.containsKey(x) && xyMapping[x] != y) {
            return false
        }
        if (yxMapping.containsKey(y) && yxMapping[y] != x) {
            return false
        }
        xyMapping[x] = y
        yxMapping[y] = x
    }

    return true
}

/**
 * Using a single map.
 */
class SolutionTwo {
    /**
     * Time: O(n * k) - where n is words.size, k is pattern.length. 1 <= n <= 50, 1 <= k <= 20
     * Space: O(n * k)
     */
    fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> = words.filter { word ->
        word.matchesPattern(pattern)
    }

}

internal fun String.matchesPattern2(pattern: String): Boolean {
    val mapping = HashMap<Char, Char>()     // x -> y = f(x)
    this.zip(pattern).forEach { (x, y) ->
        if (mapping.containsKey(x) && mapping[x] != y) {
            return false
        }
        mapping[x] = y
    }

    val usedInCodomain = BooleanArray(26)
    mapping.values.forEach { y ->
        if (usedInCodomain[y.alphaIndex]) {
            return false
        }
        usedInCodomain[y.alphaIndex] = true
    }

    return true
}
