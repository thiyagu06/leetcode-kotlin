package leetcode.easy._292_nim_game

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Ignore
import org.junit.Test
import kotlin.system.measureTimeMillis

class NimGameTest {

    private val bruteForce = BruteForceSolution()
    private val memo = SolutionMemo()
    private val tabulated = SolutionTabulation()
    private val optimal = SolutionOptimal()

    @Ignore
    @Test
    fun canWinNimBruteForce() {
        val ms = measureTimeMillis {
            assertFalse(bruteForce.canWinNim(0))
            assertTrue(bruteForce.canWinNim(1))
            assertTrue(bruteForce.canWinNim(2))
            assertTrue(bruteForce.canWinNim(3))
            assertFalse(bruteForce.canWinNim(4))
            assertTrue(bruteForce.canWinNim(5))
            assertTrue(bruteForce.canWinNim(6))
            assertTrue(bruteForce.canWinNim(7))
            assertFalse(bruteForce.canWinNim(8))
            assertTrue(bruteForce.canWinNim(9))
            assertTrue(bruteForce.canWinNim(10))
            assertTrue(bruteForce.canWinNim(11))
            assertFalse(bruteForce.canWinNim(44))
        }
        println("$ms ms")
    }

    @Test
    fun canWinNimMemo() {
        val ms = measureTimeMillis {
            assertFalse(memo.canWinNim(0))
            assertTrue(memo.canWinNim(1))
            assertTrue(memo.canWinNim(2))
            assertTrue(memo.canWinNim(3))
            assertFalse(memo.canWinNim(4))
            assertTrue(memo.canWinNim(5))
            assertTrue(memo.canWinNim(6))
            assertTrue(memo.canWinNim(7))
            assertFalse(memo.canWinNim(8))
            assertTrue(memo.canWinNim(9))
            assertTrue(memo.canWinNim(10))
            assertTrue(memo.canWinNim(11))
            assertFalse(memo.canWinNim(44))
        }
        println("$ms ms")
    }

    @Test
    fun canWinNimTab() {
        val ms = measureTimeMillis {
            assertFalse(tabulated.canWinNim(0))
            assertTrue(tabulated.canWinNim(1))
            assertTrue(tabulated.canWinNim(2))
            assertTrue(tabulated.canWinNim(3))
            assertFalse(tabulated.canWinNim(4))
            assertTrue(tabulated.canWinNim(5))
            assertTrue(tabulated.canWinNim(6))
            assertTrue(tabulated.canWinNim(7))
            assertFalse(tabulated.canWinNim(8))
            assertTrue(tabulated.canWinNim(9))
            assertTrue(tabulated.canWinNim(10))
            assertTrue(tabulated.canWinNim(11))
            assertFalse(tabulated.canWinNim(44))
        }
        println("$ms ms")
    }

    @Test
    fun canWinNimOptimal() {
        val ms = measureTimeMillis {
            assertFalse(optimal.canWinNim(0))
            assertTrue(optimal.canWinNim(1))
            assertTrue(optimal.canWinNim(2))
            assertTrue(optimal.canWinNim(3))
            assertFalse(optimal.canWinNim(4))
            assertTrue(optimal.canWinNim(5))
            assertTrue(optimal.canWinNim(6))
            assertTrue(optimal.canWinNim(7))
            assertFalse(optimal.canWinNim(8))
            assertTrue(optimal.canWinNim(9))
            assertTrue(optimal.canWinNim(10))
            assertTrue(optimal.canWinNim(11))
            assertFalse(optimal.canWinNim(44))
        }
        println("$ms ms")
    }

}