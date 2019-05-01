package leetcode.easy._401_binary_watch

class Solution {
    /**
     * Time: O(?)
     * Space: O(?)
     */
    fun readBinaryWatch(num: Int): List<String> {
        val possibleBitStrings = arrayListOf<String>()
        backtrack(n = num, index = 0, currentBits = WATCH_BITS_ALL_UNSET, bitStrings = possibleBitStrings)

        return possibleBitStrings.asSequence()
            .filter {
                it.isValidBitString()
            }.map {
                convertBitsToTime(it)
            }.toList()
    }

    private fun backtrack(n: Int, index: Int, currentBits: String, bitStrings: MutableList<String>) {
        when {
            n == 0 -> bitStrings += currentBits
            index >= NUM_WATCH_BITS -> return
            else -> {
                // don't set bit at index
                backtrack(n, index + 1, currentBits, bitStrings)

                // set bit at index
                val withBitSet = currentBits.replaceRange(index..index, "1")
                backtrack(n - 1, index + 1, withBitSet, bitStrings)
            }
        }
    }

    internal fun convertBitsToTime(bitString: String): String {
        val hourBits = bitString.take(4)
        val minBits = bitString.drop(4)

        val hours: String = convertHourBits(hourBits).toString()
        val minutes: String = formatMinutes(convertMinuteBits(minBits))

        return "$hours:$minutes"
    }

    internal fun convertHourBits(hourBits: String): Int {
        var indexValue = 8
        var hours = 0
        hourBits.forEach { bit ->
            hours += if (bit == '0') 0 else indexValue
            indexValue /= 2
        }
        return hours
    }

    internal fun convertMinuteBits(minBits: String): Int {
        var indexValue = 32
        var mins = 0
        minBits.forEach { bit ->
            mins += if (bit == '0') 0 else indexValue
            indexValue /= 2
        }
        return mins
    }

    /** Pad to 2 digits */
    private fun formatMinutes(minutes: Int): String = if (minutes in 0..9) "0$minutes" else "$minutes"

    /** The bit string's hours must be in 0..11, and minutes within 0..59 */
    private fun String.isValidBitString(): Boolean = length == 10 &&
            convertHourBits(take(4)) < 12 &&
            convertMinuteBits(drop(4)) < 60

    companion object {
        private val WATCH_BITS_ALL_UNSET = "0".repeat(10)
        private const val NUM_WATCH_BITS = 10
    }
}
