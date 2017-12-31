package algorithms.easy._744_find_smallest_letter_greater_than_target

/**
 * 744 - https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
 */
class Solution {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char =
            letters.firstOrNull { it > target } ?: letters.first()

}