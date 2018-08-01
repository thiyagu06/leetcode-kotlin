package algorithms.medium._451_sort_characters_by_freq

import extensions.java.repeated

/**
 * 451 - https://leetcode.com/problems/sort-characters-by-frequency/description/
 */
class Solution {
    /**
     * TODO: Add Tests
     * Time: O(n)
     * Space: O(n)
     */
    fun frequencySort(s: String): String =
             s.groupingBy { it }
                     .eachCount()
                     .entries
                     .sortedByDescending { (_, freq) -> freq }
                     .flatMap { (char, freq) -> char.repeated(freq) }
                     .joinToString("")

}
