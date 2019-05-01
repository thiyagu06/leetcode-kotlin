package leetcode.easy._258_add_digits

/**
 * 258 - https://leetcode.com/problems/add-digits/
 */
class Solution {
    /**
     * Time: O(?)
     * Space: O(?)
     */
    fun addDigits(num: Int): Int {
        if (num < 10) return num

        var sum = sumDigits(num)
        while (sum >= 10) {
            sum = sumDigits(sum)
        }

        return sum
    }

    private fun sumDigits(n: Int): Int {
        var sum = 0
        var x = n
        while (x > 0) {
            sum += (x % 10)
            x /= 10
        }
        return sum
    }
}

class SolutionTwo {
    /**
     * Time: O(1)
     * Space: O(1)
     */
    fun addDigits(num: Int): Int = when {
        num == 0 -> 0
        num % 9 == 0 -> 9
        else -> num % 9
    }
}

class SolutionThree {
    /**
     * Time: O(1)
     * Space: O(1)
     */
    fun addDigits(num: Int): Int = if (num == 0) 0 else ((num - 1) % 9) + 1
}