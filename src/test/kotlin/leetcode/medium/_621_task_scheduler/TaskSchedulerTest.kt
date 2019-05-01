package leetcode.medium._621_task_scheduler

import org.junit.Test

import kotlin.test.assertEquals
import org.junit.Ignore

class TaskSchedulerTest {

    private val solution = Solution()

    @Ignore("Unimplemented")
    @Test
    fun leastInterval() {
        assertEquals(8, solution.leastInterval(charArrayOf('A', 'A', 'A', 'B', 'B', 'B'), n = 2))
        assertEquals(6, solution.leastInterval(charArrayOf('A', 'A', 'B', 'B', 'C', 'C'), n = 2))
    }
}