package leetcode.easy._205_isomorphic_strings

/**
 * 205 - https://leetcode.com/problems/isomorphic-strings/
 */
class Solution {
    /**
     * Time: O(n^2)
     * Space: O(n)
     */
    fun isIsomorphic(s: String, t: String): Boolean {
        val mapping: MutableMap<Char, Char> = hashMapOf()

        // Use Sequences zip to avoid an O(n) pass for zip, and another for the forEach
        s.asSequence().zip(t.asSequence()).forEach { (a, b) ->
            if (mapping.containsKey(a) && mapping[a] != b) {
                return false
            }

            // containsValue call is O(n) - http://tinyurl.com/yycghgg3
            if (mapping.containsValue(b) && (mapping[a] != b)) {
                return false
            }
            mapping[a] = b
        }
        return true
    }
}

class SolutionTwo {
    /**
     * Time: O(n) - avoid O(n) containsValue call by using two maps.
     * Space: O(n)
     */
    fun isIsomorphic(s: String, t: String): Boolean {
        val forwardMap: MutableMap<Char, Char> = HashMap()
        val reverseMap: MutableMap<Char, Char> = HashMap()

        // Use Sequences zip to avoid an O(n) pass for zip, and another for the forEach
        s.asSequence().zip(t.asSequence()).forEach { (charS, charT) ->
            if (forwardMap.containsKey(charS) && forwardMap[charS] != charT) return false
            if (reverseMap.containsKey(charT) && reverseMap[charT] != charS) return false
            forwardMap[charS] = charT
            reverseMap[charT] = charS
        }

        return true
    }
}