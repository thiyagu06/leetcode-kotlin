package leetcode.easy._771_jewels_and_stones

/**
 * 771 - https://leetcode.com/problems/jewels-and-stones
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun numJewelsInStones(J: String, S: String): Int {
        val jewels = J.fold(hashSetOf<Char>()) { acc, jewel ->
            acc.apply { acc += jewel }
        }
        return S.count { stone -> stone in jewels }
    }
}