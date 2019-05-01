package leetcode.easy._681_next_closest_time

import extensions.chars.numericValue

class Solution {
    /**
     * Time: O(1) - several O(n) operations but n is constant (4 digits)
     * Space: O(1)
     */
    fun nextClosestTime(time: String): String {
        // If all digits are the same there is no solution - return time.
        if (time in setOf("00:00", "11:11", "22:22")) return time

        val digits = TimeDigits(
            time[0].numericValue,
            time[1].numericValue,
            time[3].numericValue,
            time[4].numericValue
        )

        // 1. HH:M?
        val solutionHHM = nextTimeWith2ndMinDigitChanged(digits)
        if (solutionHHM != null) return solutionHHM.toClockTime()

        // 2. HH:??
        val solutionHH = nextTimeWithBothMinDigitsChanged(digits)
        if (solutionHH != null) return solutionHH.toClockTime()

        // 3. H?:??
        val solutionH = nextTimeWith2ndHourDigitChanged(digits)
        if (solutionH != null) return solutionH.toClockTime()

        // 4. ??:??
        return nextTimeAllNewDigits(digits)!!.toClockTime()
    }

    private fun nextTimeWith2ndMinDigitChanged(digits: TimeDigits): TimeDigits? {
        // Take the first digit greater than m2.
        val new2ndMinutesDigit = digits.sortedDigits.firstOrNull {
            it > digits.m2
        } ?: return null

        return digits.copy(m2 = new2ndMinutesDigit)
    }

    private fun nextTimeWithBothMinDigitsChanged(digits: TimeDigits): TimeDigits? {
        // M1 - must be greater than m1 and in 0..5
        val newM1 = digits.sortedDigits.firstOrNull { it > digits.m1 && it <= 5 } ?: return null
        // M2 - if M1 found, M2 should be the smallest digit
        val newM2 = digits.sortedDigits.first()
        return digits.copy(m1 = newM1, m2 = newM2)
    }

    private fun nextTimeWith2ndHourDigitChanged(digits: TimeDigits): TimeDigits? {
        // H2 - must be greater than h2, and form a valid hour when combined with h1
        val newH2 = digits.sortedDigits.firstOrNull { it > digits.h2 } ?: return null
        if ("${digits.h1}$newH2".toInt() !in 0..23) return null

        // M1 = M2 = smallest digit
        val newMinDigit = digits.sortedDigits.first()
        return digits.copy(h2 = newH2, m1 = newMinDigit, m2 = newMinDigit)
    }

    private fun nextTimeAllNewDigits(digits: TimeDigits): TimeDigits? {
        // H1 = H2 = M1 = M2 = min of all digits
        val digit = digits.sortedDigits.first()
        return TimeDigits(h1 = digit, h2 = digit, m1 = digit, m2 = digit)
    }
}

/** Stores time digits. */
data class TimeDigits(val h1: Int, val h2: Int, val m1: Int, val m2: Int) {
    val sortedDigits: List<Int> by lazy { listOf(h1, h2, m1, m2).sorted() }

    fun toClockTime(): String = "$h1$h2:$m1$m2"
    override fun toString(): String = "TimeDigits(\"$h1$h2:$m1$m2\")"
}

typealias DigitsLambda = (TimeDigits) -> TimeDigits?

class SolutionTwo {
    /**
     * Time: O(1) - several O(n) operations but n is constant (4 digits)
     * Space: O(1)
     */
    fun nextClosestTime(time: String): String {
        // If all digits are the same there is no solution - return time.
        if (time in setOf("00:00", "11:11", "22:22")) return time

        val digits = TimeDigits(
            time[0].numericValue,
            time[1].numericValue,
            time[3].numericValue,
            time[4].numericValue
        )

        val operations: List<DigitsLambda> = listOf(
            this::nextTimeWith2ndMinDigitChanged,
            this::nextTimeWithBothMinDigitsChanged,
            this::nextTimeWith2ndHourDigitChanged,
            this::nextTimeAllNewDigits
        )

        var solution: TimeDigits? = null

        var i = 0
        while (solution == null) {
            solution = operations[i](digits)
            i++
        }

        return solution.toClockTime()
    }

    private fun nextTimeWith2ndMinDigitChanged(digits: TimeDigits): TimeDigits? {
        // Take the first digit greater than m2.
        val new2ndMinutesDigit = digits.sortedDigits.firstOrNull {
            it > digits.m2
        } ?: return null

        return digits.copy(m2 = new2ndMinutesDigit)
    }

    private fun nextTimeWithBothMinDigitsChanged(digits: TimeDigits): TimeDigits? {
        // M1 - must be greater than m1 and in 0..5
        val newM1 = digits.sortedDigits.firstOrNull { it > digits.m1 && it <= 5 } ?: return null
        // M2 - if M1 found, M2 should be the smallest digit
        val newM2 = digits.sortedDigits.first()
        return digits.copy(m1 = newM1, m2 = newM2)
    }

    private fun nextTimeWith2ndHourDigitChanged(digits: TimeDigits): TimeDigits? {
        // H2 - must be greater than h2, and form a valid hour when combined with h1
        val newH2 = digits.sortedDigits.firstOrNull { it > digits.h2 } ?: return null
        if ("${digits.h1}$newH2".toInt() !in 0..23) return null

        // M1 = M2 = smallest digit
        val newMinDigit = digits.sortedDigits.first()
        return digits.copy(h2 = newH2, m1 = newMinDigit, m2 = newMinDigit)
    }

    private fun nextTimeAllNewDigits(digits: TimeDigits): TimeDigits? {
        // H1 = H2 = M1 = M2 = min of all digits
        val digit = digits.sortedDigits.first()
        return TimeDigits(h1 = digit, h2 = digit, m1 = digit, m2 = digit)
    }
}
