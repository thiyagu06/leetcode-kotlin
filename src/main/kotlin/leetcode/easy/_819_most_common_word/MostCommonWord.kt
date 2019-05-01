package leetcode.easy._819_most_common_word

/**
 * 819 - https://leetcode.com/problems/most-common-word/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun mostCommonWord(paragraph: String, banned: Array<String>): String =
        paragraph.split(regex = """\W""".toRegex())
            .asSequence()
            .map { it.toLowerCase() }
            .filter { it.isNotEmpty() && it !in banned }
            .groupingBy { it }
            .eachCount()
            .maxBy { (word, freq) -> freq }!!
            .key
}