package leetcode.easy._412_fizz_buzz

/**
 * 412 - https://leetcode.com/problems/fizz-buzz/
 */
class Solution {
    fun fizzBuzz(n: Int): List<String> = (1..n).map { x ->
        when {
            x.isMultipleOf(3 * 5) -> "FizzBuzz"
            x.isMultipleOf(3) -> "Fizz"
            x.isMultipleOf(5) -> "Buzz"
            else -> "$x"
        }
    }

    private fun Int.isMultipleOf(n: Int) = this % n == 0
}
