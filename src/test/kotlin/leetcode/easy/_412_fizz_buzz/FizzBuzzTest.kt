package leetcode.easy._412_fizz_buzz

import org.junit.Test

import kotlin.test.assertEquals

class FizzBuzzTest {

    private val solution = Solution()

    @Test
    fun fizzBuzz() {
        assertEquals(
            listOf(
                "1",
                "2",
                "Fizz",
                "4",
                "Buzz",
                "Fizz",
                "7",
                "8",
                "Fizz",
                "Buzz",
                "11",
                "Fizz",
                "13",
                "14",
                "FizzBuzz"
            ), solution.fizzBuzz(15)
        )
    }
}