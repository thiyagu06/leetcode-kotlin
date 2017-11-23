package datastructures.queue

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * @author nrojiani
 * @date 11/17/17
 */
class ListQueueTest {
    private val queue = ListQueue<Int>()

    @Test
    fun test() {
        assertEquals(0, queue.size)
        assertTrue(queue.isEmpty())
        queue.enqueue(1)
        assertEquals(1, queue.size)
        assertFalse(queue.isEmpty())
        queue.enqueue(2)
        queue.enqueue(3)
        assertEquals(3, queue.size)

        assertEquals(queue.toList(), listOf(1, 2, 3))
        assertEquals(1, queue.peek())

        val one = queue.dequeue()
        assertEquals(1, one)
        assertEquals(2, queue.size)
        val two = queue.dequeue()
        assertEquals(2, two)
        assertEquals(1, queue.size)
        assertEquals(queue.toList(), listOf(3))

        val three = queue.dequeue()
        assertEquals(3, three)

        assertEquals(0, queue.size)
        assertTrue(queue.isEmpty())

        assertNull(queue.peek())
        assertNull(queue.dequeue())
    }
}