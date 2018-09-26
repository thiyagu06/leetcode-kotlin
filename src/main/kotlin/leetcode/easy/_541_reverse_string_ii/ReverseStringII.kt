package leetcode.easy._541_reverse_string_ii

/**
 * 541 - https://leetcode.com/problems/reverse-string-ii/
 */
class Solution {
    fun reverseStr(s: String, k: Int): String =
            buildString {
                (0..s.length step (2 * k)).forEach { i ->
                    val firstK = s.drop(i).take(k)
                    append(firstK.reversed())

                    val secondK = s.drop(i + k).take(k)
                    append(secondK)
                }
            }
}
