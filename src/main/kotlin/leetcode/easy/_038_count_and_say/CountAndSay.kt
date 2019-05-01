package leetcode.easy._038_count_and_say

/**
 * 38 - https://leetcode.com/problems/count-and-say/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun countAndSay(n: Int): String = generateSequence("1") {
            generateNext(it)
        }.elementAt(index = n - 1)

    /**
     * Time: O(n)
     * Space: O(n)
     */
    internal fun generateNext(digitString: String): String {
        require(digitString.isNotEmpty()) { "Empty digitString" }

        return buildString {
            var remainingChars = digitString
            while (remainingChars.isNotEmpty()) {
                val currentDigit = remainingChars.first()
                val spanLength = remainingChars.takeWhile { it == currentDigit }.length
                append("$spanLength$currentDigit")

                remainingChars = remainingChars.drop(spanLength)
            }
        }
    }
}