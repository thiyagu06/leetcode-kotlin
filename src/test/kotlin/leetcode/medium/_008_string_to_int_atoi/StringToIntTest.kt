package leetcode.medium._008_string_to_int_atoi

import org.junit.Assert.*
import org.junit.Test
import java.math.BigInteger

class StringToIntTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun myAtoi() {
        assertEquals(42, solution.myAtoi("42"))
        assertEquals(42, solution.myAtoi("+42"))
        assertEquals(-42, solution.myAtoi("-42"))
        assertEquals(-42, solution.myAtoi("   -42"))
        assertEquals(4193, solution.myAtoi("4193 with words"))
        assertEquals(4193, solution.myAtoi("4193withwords"))
        assertEquals(0, solution.myAtoi("words and 987"))
        assertEquals(0, solution.myAtoi(" a 42"))
        assertEquals(0, solution.myAtoi(" + 42"))
        assertEquals(0, solution.myAtoi("     "))
        assertEquals(0, solution.myAtoi("     +"))
        assertEquals(0, solution.myAtoi("     -"))
        assertEquals(4193, solution.myAtoi("4193 with words"))
        assertEquals(4193, solution.myAtoi("4193 444"))
        assertEquals(1, solution.myAtoi("1-2"))
    }

    @Test
    fun `myAtoi - Overflow`() {
        assertEquals(Int.MAX_VALUE, solution.myAtoi("2147483647"))
        assertEquals(Int.MAX_VALUE, solution.myAtoi("2147483648"))
        assertEquals(Int.MIN_VALUE, solution.myAtoi("-2147483648"))
        assertEquals(Int.MIN_VALUE, solution.myAtoi("-2147483649"))
        assertEquals(Int.MIN_VALUE, solution.myAtoi("-91283472332"))
        assertEquals(Int.MIN_VALUE, solution.myAtoi("-9223372036854775808000000"))
    }

    @Test
    fun readDigits() {
        assertEquals("", solution.readDigits("-91283472332"))
        assertEquals("", solution.readDigits("+91283472332"))
        assertEquals("91283472332", solution.readDigits("91283472332"))
        assertEquals("4193", solution.readDigits("4193 with words"))
        assertEquals("4193", solution.readDigits("4193withwords"))
        assertEquals("", solution.readDigits("words and 987"))
        assertEquals("", solution.readDigits(" 987"))
    }

    @Test
    fun digitStringToInt() {
        assertEquals(Int.MAX_VALUE, solution.digitStringToInt("2147483647", isNegative = false))
        assertEquals(Int.MAX_VALUE, solution.digitStringToInt("2147483648", isNegative = false))
        assertEquals(Int.MIN_VALUE, solution.digitStringToInt("2147483648", isNegative = true))
        assertEquals(Int.MIN_VALUE, solution.digitStringToInt("2147483649", isNegative = true))
        assertEquals(Int.MAX_VALUE, solution.digitStringToInt("91283472332", isNegative = false))
        assertEquals(Int.MIN_VALUE, solution.digitStringToInt("91283472332", isNegative = true))

        assertEquals(433, solution.digitStringToInt("433", isNegative = false))
        assertEquals(4193, solution.digitStringToInt("4193", isNegative = false))
        assertEquals(-4193, solution.digitStringToInt("4193", isNegative = true))
    }


    @Test
    fun myAtoi2() {
        assertEquals(42, solution2.myAtoi("42"))
        assertEquals(42, solution2.myAtoi("+42"))
        assertEquals(-42, solution2.myAtoi("-42"))
        assertEquals(-42, solution2.myAtoi("   -42"))
        assertEquals(4193, solution2.myAtoi("4193 with words"))
        assertEquals(4193, solution2.myAtoi("4193withwords"))
        assertEquals(0, solution2.myAtoi("words and 987"))
        assertEquals(0, solution2.myAtoi(" a 42"))
        assertEquals(0, solution2.myAtoi(" + 42"))
        assertEquals(0, solution2.myAtoi("     "))
        assertEquals(0, solution2.myAtoi("     +"))
        assertEquals(0, solution2.myAtoi("     -"))
        assertEquals(4193, solution2.myAtoi("4193 with words"))
        assertEquals(4193, solution2.myAtoi("4193 444"))
        assertEquals(1, solution2.myAtoi("1-2"))
    }

    @Test
    fun `myAtoi2 - Overflow`() {
        assertEquals(Int.MAX_VALUE, solution2.myAtoi("2147483647"))
        assertEquals(Int.MAX_VALUE, solution2.myAtoi("2147483648"))
        assertEquals(Int.MIN_VALUE, solution2.myAtoi("-2147483648"))
        assertEquals(Int.MIN_VALUE, solution2.myAtoi("-2147483649"))
        assertEquals(Int.MIN_VALUE, solution2.myAtoi("-91283472332"))
        assertEquals(Int.MIN_VALUE, solution2.myAtoi("-9223372036854775808000000"))
    }

    @Test
    fun parseSignAndDigits() {
        assertEquals("1", solution2.parseSignAndDigits("1"))
        assertEquals("123", solution2.parseSignAndDigits("123"))
        assertEquals("123", solution2.parseSignAndDigits("123   "))
        assertEquals("123", solution2.parseSignAndDigits("123 werijoa "))
        assertEquals("1", solution2.parseSignAndDigits("1-2"))
        assertEquals("123", solution2.parseSignAndDigits("+123"))
        assertEquals("-2147483649", solution2.parseSignAndDigits("-2147483649"))
    }

    @Test
    fun parseBigInteger() {
        assertEquals(Int.MAX_VALUE.toBigInteger(), solution2.parseBigInteger("2147483647"))
        assertEquals(Int.MAX_VALUE.toBigInteger(), solution2.parseBigInteger("+2147483647"))
        assertEquals((Int.MAX_VALUE.toBigInteger() + BigInteger.ONE), solution2.parseBigInteger("2147483648"))
        assertEquals((Int.MAX_VALUE.toBigInteger() + BigInteger.ONE), solution2.parseBigInteger("+2147483648"))
        assertEquals(91283472332L.toBigInteger(), solution2.parseBigInteger("91283472332"))
        assertEquals(91283472332L.toBigInteger(), solution2.parseBigInteger("+91283472332"))

        assertEquals(Int.MIN_VALUE.toBigInteger(), solution2.parseBigInteger("-2147483648"))
        assertEquals((Int.MIN_VALUE.toBigInteger() - BigInteger.ONE), solution2.parseBigInteger("-2147483649"))
        assertEquals((-91283472332L).toBigInteger(), solution2.parseBigInteger("-91283472332"))

        assertEquals(433.toBigInteger(), solution2.parseBigInteger("433"))
        assertEquals(4193.toBigInteger(), solution2.parseBigInteger("4193"))
        assertEquals((-4193).toBigInteger(), solution2.parseBigInteger("-4193"))

        assertNull(solution2.parseBigInteger("++42"))
        assertNull(solution2.parseBigInteger("+ 42"))
        assertNull(solution2.parseBigInteger("foo 42"))
        assertNull(solution2.parseBigInteger("    42"))
        assertNull(solution2.parseBigInteger("    "))
    }

}