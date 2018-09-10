package leetcode.easy._412_fizz_buzz

/**
 * 412 - https://leetcode.com/problems/fizz-buzz/description/
 */
class Solution {
    fun fizzBuzz(n: Int): List<String> =
            (1..n).fold(emptyList()) { acc, i ->
                acc + when {
                    i.isMultipleOf(3, 5) -> "FizzBuzz"
                    i.isMultipleOf(3) -> "Fizz"
                    i.isMultipleOf(5) -> "Buzz"
                    else -> "$i"
                }
            }

    private fun Int.isMultipleOf(vararg elements: Int) = elements.all { this % it == 0 }
}
