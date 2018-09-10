package leetcode.medium._049_group_anagrams

/**
 * 49 - https://leetcode.com/problems/group-anagrams/description/
 */
class Solution {
    /**
     * Time: O(N * K * log (K)), where N = strs.size, K = max. length of a string in strs.
     *       The outer loop has complexity O(N) as we iterate through each string. Then, we sort each string in
     *       O(K log (K)) time
     * Space: O(N * K) -  the total information content stored in the map
     */
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val wordAndLetters = strs.map { (it to it.toCharArray().sorted()) }     // [(eat, [a, e, t]), ... ]

        return wordAndLetters.groupingBy { (word, letters) -> letters }
                .fold(emptyList<String>()) { acc, (word, letters) ->
                    acc + word
                }.values
                .map { anagramList -> anagramList.sorted() }
    }
}
