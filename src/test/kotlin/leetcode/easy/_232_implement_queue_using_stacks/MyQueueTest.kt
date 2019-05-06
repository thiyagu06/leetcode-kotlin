package leetcode.easy._232_implement_queue_using_stacks

import org.junit.Test
import java.util.EmptyStackException
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MyQueueTest {

    private val q1 = MyQueue()

    @Test
    fun test() {
        assertEquals(0, q1.size)
        assertTrue(q1.empty())
        q1.push(1)
        assertEquals(1, q1.size)
        assertFalse(q1.empty())
        q1.push(2)
        q1.push(3)
        assertEquals(3, q1.size)

        assertEquals(q1.toList(), listOf(1, 2, 3))
        assertEquals(1, q1.peek())

        val one = q1.pop()
        assertEquals(1, one)
        assertEquals(2, q1.size)
        val two = q1.pop()
        assertEquals(2, two)
        assertEquals(1, q1.size)
        assertEquals(q1.toList(), listOf(3))

        val three = q1.pop()
        assertEquals(3, three)

        assertEquals(0, q1.size)
        assertTrue(q1.empty())
    }

    @Test(expected = EmptyStackException::class)
    fun testEmptyStackPeek() {
        q1.peek()
    }

    @Test(expected = EmptyStackException::class)
    fun testEmptyStackPop() {
        q1.pop()
    }
}