package leetcode.medium._179_largest_number

class Solution {
    /**
     * Time: O(n log n)
     * Space: O(n)
     */
    fun largestNumber(nums: IntArray): String {
        val comparator = Comparator<Int> { a, b -> 
            "$a$b".compareTo("$b$a")
        }.reversed()

        return nums.sortedWith(comparator).joinToString("")
            .trimLeadingZeroes()
    }

    private fun String.trimLeadingZeroes(): String {
        val trimmed = dropWhile { it == '0' }
        return if (trimmed.isBlank()) "0" else trimmed
    }
}
