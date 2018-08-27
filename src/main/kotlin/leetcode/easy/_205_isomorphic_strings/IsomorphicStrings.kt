package algorithms.easy._205_isomorphic_strings

/**
 * 205 - https://leetcode.com/problems/isomorphic-strings/description/
 */
class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        val mapping = hashMapOf<Char, Char>()
        s.zip(t).forEach { (a, b) ->
            if (mapping.containsKey(a) && mapping[a] != b) {
                return false
            }
            if (mapping.containsValue(b) && (mapping[a] != b)) {
                return false
            }

            mapping[a] = b
        }
        return true
    }
}