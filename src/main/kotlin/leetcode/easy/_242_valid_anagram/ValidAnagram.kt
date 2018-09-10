package leetcode.easy._242_valid_anagram

import extensions.strings.characterFrequencies

const val NUMBER_OF_LETTERS = 26

/**
 * 242 - https://leetcode.com/problems/valid-anagram/description/
 *
 * Note: You may assume the string contains only lowercase alphabets.
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(1) - character table used is of constant size
     */
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val charTable = IntArray(NUMBER_OF_LETTERS)

        s.forEach { c ->
            charTable[c.letterIndex()]++
        }

        t.forEach { c ->
            val cIndex = c.letterIndex()
            charTable[cIndex]--
            if (charTable[cIndex] < 0) return false
        }
        return true
    }

    /** Maps a-z to indices 0..25 */
    private fun Char.letterIndex(): Int = this.toLowerCase() - 'a'
}

class SolutionTwo {
    /**
     * Time: O(n log n)
     * Space: O(1) - ignore space used by `toCharArray()` - see https://leetcode.com/problems/valid-anagram/solution/
     */
    fun isAnagram(s: String, t: String): Boolean = s.toCharArray().sorted() == t.toCharArray().sorted()
}

class SolutionThree {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun isAnagram(s: String, t: String): Boolean = s.length == t.length
            && s.characterFrequencies() == t.characterFrequencies()
}

class SolutionFour {
    /**
     * Time: O(n)
     * Space: O(1) - uses space for HashMap, but size is limited to 26 mappings.
     */
    fun isAnagram(s: String, t: String): Boolean {
        val charsInS = HashMap<Char, Int>()
        s.forEach { ch ->
            charsInS[ch] = (charsInS[ch] ?: 0) + 1
        }

        t.forEach { ch ->
            if (!charsInS.containsKey(ch)) {
                return false
            } else {
                charsInS[ch] = charsInS[ch]!! - 1
                charsInS.remove(ch, 0)  // if ch => 0, remove mapping
            }

        }
        return charsInS.isEmpty()
    }
}