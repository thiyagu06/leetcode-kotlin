package leetcode.hard._273_integer_to_english_words

import org.junit.Test

import kotlin.test.assertEquals

class IntegerToEnglishWordsTest {

    private val solution = Solution()

    @Test
    fun numberToWords() {
        assertEquals("Zero", solution.numberToWords(0))
        assertEquals("Ten", solution.numberToWords(10))
        assertEquals("Eleven", solution.numberToWords(11))
        assertEquals("Twelve", solution.numberToWords(12))
        assertEquals("Thirteen", solution.numberToWords(13))
        assertEquals("Fourteen", solution.numberToWords(14))
        assertEquals("Fifteen", solution.numberToWords(15))
        assertEquals("Sixteen", solution.numberToWords(16))
        assertEquals("Seventeen", solution.numberToWords(17))
        assertEquals("Eighteen", solution.numberToWords(18))
        assertEquals("Nineteen", solution.numberToWords(19))
        assertEquals("Twenty", solution.numberToWords(20))
        assertEquals("Twenty Five", solution.numberToWords(25))
        assertEquals("Eighty Seven", solution.numberToWords(87))
        assertEquals("One Hundred", solution.numberToWords(100))
        assertEquals("One Hundred One", solution.numberToWords(101))
        assertEquals("One Hundred Twenty Three", solution.numberToWords(123))
        assertEquals("Nine Hundred Seventy Two", solution.numberToWords(972))
        assertEquals("One Thousand", solution.numberToWords(1000))
        assertEquals("One Thousand One", solution.numberToWords(1001))
        assertEquals("One Thousand Two Hundred Thirty Four", solution.numberToWords(1234))
        assertEquals("Twelve Thousand Three Hundred Forty Five", solution.numberToWords(12345))
        assertEquals(
            "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven",
            solution.numberToWords(1234567)
        )
        assertEquals(
            "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One",
            solution.numberToWords(1234567891)
        )
        assertEquals(
            "Two Billion One Hundred Forty Seven Million Four Hundred Eighty Three Thousand Six Hundred Forty Seven",
            solution.numberToWords(Int.MAX_VALUE)
        )
    }
}