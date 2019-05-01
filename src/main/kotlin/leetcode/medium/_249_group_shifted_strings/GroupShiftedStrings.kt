package leetcode.medium._249_group_shifted_strings

/**
 * 249 - https://leetcode.com/problems/group-shifted-strings
 */
class Solution {
    fun groupStrings(strings: Array<String>): List<List<String>> {
        val grouped: MutableMap<List<Int>, List<String>> = hashMapOf()
        for (s in strings) {
            // the key for each string is the distance of each char from the char preceding it.
            // for example, "abc" & "xyz" will have key [1, 1]
            val key: List<Int> = (1..s.lastIndex).fold(listOf()) { acc, i ->
                acc + (s[i].distanceFrom(s[i - 1]))
            }
            grouped[key] = grouped.getOrDefault(key, emptyList()) + s
        }

        return grouped.values.toList()
    }

    /**
     * Distance to right in 'a'..'z' (and wrapping around).
     * ```
     * 'b'.distanceFrom('a') = 1
     * 'a'.distanceFrom('b') = 25
     * ```
     */
    private fun Char.distanceFrom(prevChar: Char): Int {
        val distance = this - prevChar
        return if (distance >= 0) distance else (26 + distance)
    }
}