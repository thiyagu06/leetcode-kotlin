package algorithms.easy._796_rotate_string

/**
 * 796 - https://leetcode.com/problems/rotate-string/description/
 */
class Solution {
    fun rotateString(A: String, B: String): Boolean =
        (A == B) || (0 until A.length).any { shifts ->
            (A.rotate(shifts) == B)
        }

    // Not the most performant way to do it, but simple
    private fun String.rotate(shifts: Int): String {
        val adjustedShifts = (shifts % length)
        return drop(adjustedShifts) + take(adjustedShifts)
    }
}