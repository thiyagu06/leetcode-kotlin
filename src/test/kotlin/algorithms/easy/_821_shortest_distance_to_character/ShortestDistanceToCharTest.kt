package algorithms.easy._821_shortest_distance_to_character

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class ShortestDistanceToCharTest {

    private val solution = Solution()

    @Test
    fun shortestToChar() {
        assertArrayEquals(intArrayOf(3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0), solution.shortestToChar("loveleetcode", 'e'))
    }
}