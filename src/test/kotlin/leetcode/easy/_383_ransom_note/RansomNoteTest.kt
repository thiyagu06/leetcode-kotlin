package leetcode.easy._383_ransom_note

import org.junit.Test

import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RansomNoteTest {

    private val solution = Solution()

    @Test
    fun canConstruct() {
        assertFalse(solution.canConstruct("a", "b"))
        assertFalse(solution.canConstruct("aa", "ab"))
        assertTrue(solution.canConstruct("aa", "aab"))
    }
}