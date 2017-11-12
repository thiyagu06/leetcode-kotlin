package datastructures

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

/**
 * @author nrojiani
 * @date 11/10/17
 */
class ListNodeTest {

    private var listA: ListNode? = null

    @Before
    fun setUp() {
        listA = ListNode(0)
        listA?.next = ListNode(1)
        listA?.next?.next = ListNode(2)
        listA?.next?.next?.next = ListNode(3)
    }

    @After
    fun tearDown() {
        listA = null
    }

    @Test
    fun from() {
        assertNull(ListNode.from(emptyList()))

        val createdList = ListNode.from(listOf(0, 1, 2, 3))
        assertNotNull(createdList?.toList())
        println(createdList?.toList())
        assertEquals(listA?.toList(), createdList?.toList())
    }

    @Test
    fun testLinkedListOf() {
        assertEquals(listOf(1), linkedListOf(1).toList())
        assertEquals(listOf(1, 2), linkedListOf(1, 2).toList())
        assertEquals(listOf(1, 2, 3), linkedListOf(1, 2, 3).toList())
        assertEquals(listOf(1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1), linkedListOf(1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1).toList())
    }

    @Test(expected = IllegalArgumentException::class)
    fun linkedListOfException() {
        val list = linkedListOf()
    }


    @Test
    fun size() {
        val createdList = ListNode.from(listOf(0, 1, 2, 3))
        assertEquals(4, createdList?.size)
    }

    @Test
    fun toIntArray() {
        val linkedList = ListNode.from(listOf(0, 1, 2, 3))
        val array = IntArray(4, { i -> i})
        val arrFromLL = linkedList?.toIntArray()
        assertEquals(4, arrFromLL?.size)
        assertEquals(array.contentToString(), arrFromLL?.contentToString())
    }

    @Test
    fun contentToString() {
        val linkedList = ListNode.from(listOf(0, 1, 2, 3))
        assertEquals("(0)->(1)->(2)->(3)", linkedList?.contentToString())
    }
}