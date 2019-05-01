package datastructures.list

import org.junit.After
import kotlin.test.assertEquals
import org.junit.Before
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class ListNodeTest {

    private var listA: ListNode? = linkedListOf(0, 1, 2, 3)
    private val palindromeList: ListNode = linkedListOf(1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1)

    @Before
    fun setUp() {
        listA = linkedListOf(0, 1, 2, 3)
    }

    @After
    fun tearDown() {
        listA = null
    }

    @Test
    fun from() {
        assertNull(ListNode.from(emptyList()))

        val createdList = ListNode.from(listOf(0, 1, 2, 3))
        assertNotNull(createdList)
        assertEquals(4, createdList?.size)
        assertEquals(listA, createdList)
    }

    @Test
    fun size() {
        val createdList = ListNode.from(listOf(0, 1, 2, 3))
        assertEquals(4, createdList?.size)
        val nullList: ListNode? = null
        assertEquals(0, nullList.size)
    }

    @Test
    fun tail() {
        val nullList: ListNode? = null
        assertNull(nullList.tail)

        val singleList = linkedListOf(1)
        assertNull(singleList.tail)

        val list12 = linkedListOf(1, 2)
        assertEquals(linkedListOf(2), list12.tail)

        val list123 = linkedListOf(1, 2, 3)
        assertEquals(linkedListOf(2, 3), list123.tail)
    }

    @Test
    fun equals() {
        val a = linkedListOf(1, 2, 3, 4)
        val b = linkedListOf(1, 2, 3, 5)
        assertFalse(a == b)
        assertNotEquals(a, b)

        val c = linkedListOf(1, 2, 3, 4)
        assertTrue(a == c)
        assertEquals(a, c)

        // 1->2->4
        a.next?.next = a.next?.next?.next
        c.next?.next = c.next?.next?.next
        assertEquals(listOf(1, 2, 4), a.toList())
        assertEquals(listOf(1, 2, 4), c.toList())
        assertEquals(linkedListOf(1, 2, 4), a)
        assertEquals(linkedListOf(1, 2, 4), c)
    }

    @Test
    fun middleNode() {
        val expected = mapOf(
            null to null,
            linkedListOf(1) to 1,
            linkedListOf(1, 2) to 2,
            linkedListOf(1, 2, 3) to 2,
            linkedListOf(1, 2, 3, 4) to 3,
            linkedListOf(1, 2, 3, 4, 5) to 3,
            linkedListOf(1, 2, 3, 4, 5, 6) to 4
        )

        expected.forEach { (list, middleValue) ->
            assertEquals(middleValue, list.middleNode?.`val`)
        }
    }

    @Test
    fun forEachNode() {
        val list = linkedListOf(1, 2, 3, 4, 5)
        val nodesInList = ArrayList<ListNode>()
        list.forEachNode { node ->
            nodesInList += node
        }

        assertEquals(list, nodesInList[0])
        assertEquals(linkedListOf(2, 3, 4, 5), nodesInList[1])
        assertEquals(linkedListOf(3, 4, 5), nodesInList[2])
        assertEquals(linkedListOf(4, 5), nodesInList[3])
        assertEquals(linkedListOf(5), nodesInList[4])
    }

    @Test
    fun reversed() {
        val original = linkedListOf(1, 2, 3, 4, 5)
        val copy = original.copyOf()

        assertEquals(linkedListOf(1, 2, 3, 4, 5), original)
        assertEquals(linkedListOf(1, 2, 3, 4, 5), copy)

        val reversedCopy = copy?.reversed()

        assertEquals(linkedListOf(1, 2, 3, 4, 5), original)
        assertEquals(linkedListOf(1, 2, 3, 4, 5), copy)
        assertEquals(linkedListOf(5, 4, 3, 2, 1), reversedCopy)
    }

    @Test
    fun copyOf() {
        val original = linkedListOf(1, 2, 3, 4, 5)
        val copy = original.copyOf()

        assertEquals(linkedListOf(1, 2, 3, 4, 5), original)
        assertEquals(linkedListOf(1, 2, 3, 4, 5), copy)

        copy?.next = null

        assertEquals(linkedListOf(1, 2, 3, 4, 5), original)
        assertEquals(linkedListOf(1), copy)
    }

    @Test
    fun testLinkedListOf() {
        assertEquals(listOf(1), linkedListOf(1).toList())
        assertEquals(listOf(1, 2), linkedListOf(1, 2).toList())
        assertEquals(listOf(1, 2, 3), linkedListOf(1, 2, 3).toList())
        assertEquals(listOf(1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1), palindromeList.toList())
    }

    @Test(expected = IllegalArgumentException::class)
    fun linkedListOfException() {
        linkedListOf()
    }

    @Test
    fun toSet() {
        assertEquals(setOf(1, 2, 3), linkedListOf(1, 1, 2, 3, 3).toSet())
        assertEquals(setOf(11, 11, 75, 75), linkedListOf(11, 75).toSet())
    }

    @Test
    fun toIntArray() {
        val linkedList = ListNode.from(listOf(0, 1, 2, 3))
        val array = IntArray(4) { i -> i }
        val arrFromLL = linkedList?.toIntArray()
        assertEquals(4, arrFromLL?.size)
        assertEquals(array.contentToString(), arrFromLL?.contentToString())
    }

    @Test
    fun contentToString() {
        val nullList: ListNode? = null
        assertEquals("(null)", nullList.contentToString())
        val linkedList = ListNode.from(listOf(0, 1, 2, 3))
        assertEquals("(0)->(1)->(2)->(3)", linkedList?.contentToString())
    }

    @Test
    fun iterator() {
        // Implementing iterator provides us with forEach, forEachIndexed, mapIndexed, & everything else in Iterable
        var sum = 0
        linkedListOf(99).forEach { sum += it }
        assertEquals(99, sum)

        sum = 0
        linkedListOf(1, 2, 3, 4).forEach { sum += it }
        assertEquals(10, sum)

        sum = 0
        linkedListOf(1, 1, 2, 3, 3, 1, 2, 3).forEach { sum += it }
        assertEquals(16, sum)

        val values = arrayListOf<Int>()
        linkedListOf(1, 2, 3, 4, 5).forEach { values += it }
        assertEquals(listOf(1, 2, 3, 4, 5), values)

        val palindromeListValues = palindromeList.toList()
        palindromeList.forEachIndexed { i, value ->
            assertEquals(value, palindromeListValues[i])
        }

        assertEquals(
            listOf(1 to 9, 2 to 8, 3 to 7, 4 to 6),
            linkedListOf(1, 2, 3, 4) zip linkedListOf(9, 8, 7, 6, 5)
        )
    }

}
