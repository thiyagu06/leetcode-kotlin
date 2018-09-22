package leetcode.medium._890_find_and_replace_pattern

/**
 * 890 - https://leetcode.com/problems/find-and-replace-pattern/description/
 */
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
        if (xyMapping.containsKey(x) && xyMapping[x] != y) return false
        if (yxMapping.containsKey(y) && yxMapping[y] != x) return false
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
        word.matchesPattern2(pattern)
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

    val usedInCodomain = HashMap<Char, Boolean>()
    mapping.values.forEach { y ->
        if (usedInCodomain.getOrDefault(y, false)) {
            return false
        }
        usedInCodomain[y] = true
    }

    return true
}
