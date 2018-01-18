package algorithms.easy._383_ransom_note

import extensions.strings.characterFrequencies

/**
 * 383 - https://leetcode.com/problems/ransom-note/description/
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val letters = magazine.characterFrequencies().toMutableMap()

        ransomNote.forEach { c ->
            letters[c] ?: return false

            if (letters[c] == 0)
                return false

            letters[c] = letters[c]!! - 1
        }

        return true
    }
}