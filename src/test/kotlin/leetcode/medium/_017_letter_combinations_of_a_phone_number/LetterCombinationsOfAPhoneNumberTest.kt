package leetcode.medium._017_letter_combinations_of_a_phone_number

import kotlin.test.assertEquals
import org.junit.Test
import kotlin.test.assertTrue

class LetterCombinationsOfAPhoneNumberTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun letterCombinations() {
        assertTrue(solution.letterCombinations("23").containsAll(
            listOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")
        ))

        assertTrue(
            solution.letterCombinations("478").containsAll(
                listOf("gpt", "gpu", "gpv", "gqt", "gqu", "gqv", "grt", "gru", "grv", "gst", "gsu", "gsv", "hpt",
                    "hpu", "hpv", "hqt", "hqu", "hqv", "hrt", "hru", "hrv", "hst", "hsu", "hsv", "ipt", "ipu", "ipv",
                    "iqt", "iqu", "iqv", "irt", "iru", "irv", "ist", "isu", "isv")
            )
        )

        assertEquals(emptyList<String>(), solution.letterCombinations(""))
    }

    @Test
    fun letterCombinations2() {
        println(solution2.letterCombinations("23"))

        assertTrue(solution2.letterCombinations("23").containsAll(
            listOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")
        ))

        assertTrue(
            solution2.letterCombinations("478").containsAll(
                listOf("gpt", "gpu", "gpv", "gqt", "gqu", "gqv", "grt", "gru", "grv", "gst", "gsu", "gsv", "hpt",
                    "hpu", "hpv", "hqt", "hqu", "hqv", "hrt", "hru", "hrv", "hst", "hsu", "hsv", "ipt", "ipu", "ipv",
                    "iqt", "iqu", "iqv", "irt", "iru", "irv", "ist", "isu", "isv")
            )
        )

        assertEquals(emptyList<String>(), solution2.letterCombinations(""))
    }
}