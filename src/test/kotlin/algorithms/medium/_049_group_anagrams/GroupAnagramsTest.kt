package algorithms.medium._049_group_anagrams

import org.junit.Test

import org.junit.Assert.*
import kotlin.system.measureTimeMillis

class GroupAnagramsTest {

    private val solution = Solution()

    @Test
    fun groupAnagrams() {
        val ms = measureTimeMillis {
            assertEquals(
                    listOf(listOf("ate", "eat","tea"), listOf("nat","tan"), listOf("bat")),
                    solution.groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))
        }
        println("$ms ms")
    }
}
