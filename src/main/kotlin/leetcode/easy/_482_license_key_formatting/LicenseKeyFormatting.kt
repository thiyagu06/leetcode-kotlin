package leetcode.easy._482_license_key_formatting

/**
 * 482 - https://leetcode.com/problems/license-key-formatting/
 */
class Solution {
    /**
     * Time: O(?)
     * Space: O(?)
     */
    fun licenseKeyFormatting(S: String, K: Int): String {
        val noDashes = S.filterNot { it == '-' }
            .map { it.toUpperCase() }
            .joinToString("")

        return when (val group1Size = noDashes.length % K) {
            // All groups have K chars
            0 -> return noDashes.chunked(K).joinToString("-")
            // First group has 1..K-1 chars
            else -> buildString {
                append(noDashes.take(group1Size))
                noDashes.drop(group1Size)
                    .chunked(K)
                    .forEach { append("-$it") }
            }
        }
    }
}