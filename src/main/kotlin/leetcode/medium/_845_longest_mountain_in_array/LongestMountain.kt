package leetcode.medium._845_longest_mountain_in_array

import kotlin.math.max

/**
 * 845 - https://leetcode.com/problems/longest-mountain-in-array
 */
class Solution {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun longestMountain(A: IntArray): Int {
        var longest = 0
        var base: Int
        var end = 0
        var i = 0

        while (i + 1 <= A.lastIndex) {
            // Incline
            base = i
            incline@ while (i + 1 <= A.lastIndex) {
                when {
                    // continuing incline
                    A[i + 1] > A[i] -> {
                        end++
                        i++
                    }
                    // decline
                    A[i + 1] < A[i] -> {
                        // peak at i
                        end = i

                        if (end == base) {
                            // If there hasn't been any prior incline, then retry with base at next index.
                            i++
                            base = i
                            continue@incline
                        } else {
                            // If there is prior incline & dips from i to i+1, then i is the peak. Find decline.
                            break@incline
                        }
                    }
                    // flat
                    A[i + 1] == A[i] -> {
                        base = i + 1
                        i++
                    }
                }
            }

            // Find Decline
            decline@ while (i + 1 <= A.lastIndex) {
                when {
                    // continue decline
                    A[i + 1] < A[i] -> end++
                    // incline or flat
                    else -> {
                        end = i
                        break@decline
                    }
                }
                longest = max(longest, end - base + 1)
                i++
            }
        }

        return longest
    }
}

class SolutionTwo {
    /**
     * Refactored.
     * Time: O(n)
     * Space: O(1)
     */
    fun longestMountain(A: IntArray): Int {
        var longest = 0
        var base = 0
        var peak: Int
        var end: Int
        var inclineRange: IntRange?
        var declineRange: IntRange?

        while (base < A.lastIndex) {
            inclineRange = null

            // Until an incline is found (or end reached), try finding an incline
            while (inclineRange == null && base < A.lastIndex) {
                inclineRange = findIncline(A, base)
                if (inclineRange == null) base++        // try again from next index if no incline, else end loop
            }
            if (inclineRange == null) return longest    // can be null if base >= last index

            peak = inclineRange.endInclusive
            declineRange = findDecline(A, peak)
            if (declineRange == null) {
                base = peak + 1
                // start over with new base
                continue
            }
            end = declineRange.endInclusive

            // Compare to current longest
            longest = max(longest, end - base + 1)

            // Set base = end & repeat loop to find next mountain.
            base = end
        }
        return longest
    }

    internal fun findIncline(A: IntArray, base: Int): IntRange? {
        var end = base
        while (end + 1 <= A.lastIndex && A[end + 1] > A[end]) end++
        return if (end == base) null else base..end
    }

    internal fun findDecline(A: IntArray, peak: Int): IntRange? {
        var end = peak
        while (end + 1 <= A.lastIndex && A[end + 1] < A[end]) end++
        return if (peak == end) null else peak..end
    }
}