package datastructures

import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Ignore
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
}