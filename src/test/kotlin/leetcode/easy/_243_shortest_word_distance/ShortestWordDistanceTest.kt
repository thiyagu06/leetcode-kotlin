package leetcode.easy._243_shortest_word_distance

import org.junit.Test

import kotlin.test.assertEquals

class ShortestWordDistanceTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()

    @Test
    fun shortestDistance() {
        val words = arrayOf("practice", "makes", "perfect", "coding", "makes")
        assertEquals(
            3, solution.shortestDistance(
                words = words,
                word1 = "coding",
                word2 = "practice"
            )
        )

        assertEquals(
            1, solution.shortestDistance(
                words = words,
                word1 = "makes",
                word2 = "coding"
            )
        )

        assertEquals(
            1, solution.shortestDistance(
                words = arrayOf("foo", "baz", "bar", "foo", "bar"),
                word1 = "foo",  // 0, 3
                word2 = "bar"   // 2, 4
            )
        )
    }

    @Test
    fun shortestDistance2() {
        val words = arrayOf("practice", "makes", "perfect", "coding", "makes")
        assertEquals(
            3, solution2.shortestDistance(
                words = words,
                word1 = "coding",
                word2 = "practice"
            )
        )

        assertEquals(
            1, solution2.shortestDistance(
                words = words,
                word1 = "makes",
                word2 = "coding"
            )
        )

        assertEquals(
            1, solution2.shortestDistance(
                words = arrayOf("foo", "baz", "bar", "foo", "bar"),
                word1 = "foo",  // 0, 3
                word2 = "bar"   // 2, 4
            )
        )
    }
}