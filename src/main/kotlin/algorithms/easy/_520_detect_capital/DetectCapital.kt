package algorithms.easy._520_detect_capital

/**
 * 520 - https://leetcode.com/problems/detect-capital/description/
 */
class Solution {
    fun detectCapitalUse(word: String): Boolean =
            word.all { it.isUpperCase() }
                    || word.all { it.isLowerCase() }
                    || (word.first().isUpperCase() && word.drop(1).all { it.isLowerCase() })
}
