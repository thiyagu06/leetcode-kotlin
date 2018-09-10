package leetcode.easy._884_uncommon_words

import org.junit.Assert.assertArrayEquals
import org.junit.Test


class UncommonWordsTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun uncommonFromSentences() {
        assertArrayEquals(
            arrayOf("sweet", "sour"),
            solution.uncommonFromSentences("this apple is sweet", "this apple is sour")
        )

        assertArrayEquals(
                arrayOf("banana"),
        solution.uncommonFromSentences("apple apple", "banana")
        )

        assertArrayEquals(
            arrayOf("banana"),
            solution.uncommonFromSentences("apple apple", "banana apple")
        )

        assertArrayEquals(
            emptyArray<String>(),
            solution.uncommonFromSentences("apple apple", "banana banana")
        )

        assertArrayEquals(
            emptyArray<String>(),
            solution.uncommonFromSentences("apple banana", "apple banana")
        )

        assertArrayEquals(
            arrayOf("apple", "banana"),
            solution.uncommonFromSentences("apple", "banana").sorted().toTypedArray()
        )
    }


    @Test
    fun uncommonFromSentences2() {
        assertArrayEquals(
            arrayOf("sweet", "sour"),
            solution2.uncommonFromSentences("this apple is sweet", "this apple is sour")
        )

        assertArrayEquals(
            arrayOf("banana"),
            solution2.uncommonFromSentences("apple apple", "banana")
        )

        assertArrayEquals(
            arrayOf("banana"),
            solution2.uncommonFromSentences("apple apple", "banana apple")
        )

        assertArrayEquals(
            emptyArray<String>(),
            solution2.uncommonFromSentences("apple apple", "banana banana")
        )

        assertArrayEquals(
            emptyArray<String>(),
            solution2.uncommonFromSentences("apple banana", "apple banana")
        )

        assertArrayEquals(
            arrayOf("apple", "banana"),
            solution2.uncommonFromSentences("apple", "banana").sorted().toTypedArray()
        )
    }
}