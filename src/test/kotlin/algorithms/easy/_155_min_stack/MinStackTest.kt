package algorithms.easy._155_min_stack

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class MinStackTest {

    private val stack = MinStack()
    private val emptyStack = MinStack()

    @Before
    fun setUp() {
        stack.apply {
            push(7)
            push(8)
            push(9)
        }
    }

    @Test
    fun push() {
        assertEquals(3, stack.size)
        stack.push(10)
        assertEquals(4, stack.size)
        assertEquals(10, stack.top())
    }

    @Test
    fun pop() {
        assertEquals(3, stack.size)
        stack.pop()
        assertEquals(2, stack.size)
        stack.pop()
        assertEquals(1, stack.size)
        stack.pop()
        assertEquals(0, stack.size)
        assertTrue(stack.isEmpty())
    }

    @Test(expected = NoSuchElementException::class)
    fun popWhenEmpty() {
        emptyStack.pop()
    }

    @Test
    fun top() {
        assertEquals(3, stack.size)
        assertEquals(9, stack.top())
        assertEquals(3, stack.size)
        stack.push(10)
        assertEquals(10, stack.top())
    }

    @Test(expected = NoSuchElementException::class)
    fun topWhenEmpty() {
        emptyStack.top()
    }

    @Test
    fun getMin() {
        assertEquals(3, stack.size)
        assertEquals(7, stack.getMin())
        assertEquals(3, stack.size)
        assertEquals(7, stack.getMin())
        stack.push(1)
        assertEquals(1, stack.getMin())
    }

    @Test(expected = NoSuchElementException::class)
    fun getMinWhenEmpty() {
        emptyStack.getMin()
    }

    @Test
    fun isEmpty() {
        assertTrue(emptyStack.isEmpty())
        assertEquals(0, emptyStack.size)
        assertFalse(stack.isEmpty())
        assertEquals(3, stack.size)
    }

    @Test
    fun isNotEmpty() {
        assertFalse(emptyStack.isNotEmpty())
        assertEquals(0, emptyStack.size)
        assertTrue(stack.isNotEmpty())
        assertEquals(3, stack.size)
    }
}