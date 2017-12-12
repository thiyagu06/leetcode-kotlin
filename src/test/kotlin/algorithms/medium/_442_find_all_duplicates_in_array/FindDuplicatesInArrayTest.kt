package algorithms.medium._442_find_all_duplicates_in_array

import org.junit.Test

import org.junit.Assert.*
import kotlin.system.measureTimeMillis

class FindDuplicatesInArrayTest {

    private val solution = Solution()
    private val solution2 = Solution2()
    private val followup = FollowUpSolution()

    @Test
    fun findDuplicates() {
        val ms = measureTimeMillis {
            assertEquals(listOf(2, 3), solution.findDuplicates(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)))
        }
        println("$ms ms")
    }

    @Test
    fun findDuplicates2() {
        val ms = measureTimeMillis {
            assertEquals(listOf(2, 3), solution2.findDuplicates(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)))
        }
        println("$ms ms")
    }

    @Test
    fun findDuplicatesFollowup() {
        val ms = measureTimeMillis {
            assertEquals(listOf(2, 3), followup.findDuplicates(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)))
        }
        println("$ms ms")
    }
}