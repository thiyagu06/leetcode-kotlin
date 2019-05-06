package leetcode.easy._160_intersection_linked_list

import datastructures.list.linkedListOf
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class IntersectionOf2LinkedListsTest {

    private val solution = Solution()

    @Test
    fun `intersect - no intersection - solution 1`() {
        val head1 = linkedListOf(29, 23, 82, 11, 12, 27)
        val head2 = linkedListOf(13, 4)
        assertNull(solution.getIntersectionNode(head1, head2))
    }

    @Test
    fun `intersect - has intersection - solution 1`() {
        val shared = linkedListOf(12, 27)
        val head1 = linkedListOf(29, 23, 82, 11)
        head1.next?.next?.next?.next = shared

        val head2 = linkedListOf(13, 4)
        head2.next?.next = shared

        assertEquals(linkedListOf(29, 23, 82, 11, 12, 27), head1)
        assertEquals(linkedListOf(13, 4, 12, 27), head2)

        assertEquals(
            shared,
            solution.getIntersectionNode(head1, head2)
        )
    }

    @Test
    fun `intersect - has intersection, equal size - solution 1`() {
        val shared = linkedListOf(27)
        val head1 = linkedListOf(12)
        head1.next = shared

        val head2 = linkedListOf(13)
        head2.next = shared

        assertEquals(linkedListOf(12, 27), head1)
        assertEquals(linkedListOf(13, 27), head2)

        assertEquals(
            shared,
            solution.getIntersectionNode(head1, head2)
        )
    }

    @Test
    fun `intersect - no intersection - solution 2`() {
        val head1 = linkedListOf(29, 23, 82, 11, 12, 27)
        val head2 = linkedListOf(13, 4)
        assertNull(solution.getIntersectionNode2(head1, head2))
    }

    @Test
    fun `intersect - has intersection - solution 2`() {
        val shared = linkedListOf(12, 27)
        val head1 = linkedListOf(29, 23, 82, 11)
        head1.next?.next?.next?.next = shared

        val head2 = linkedListOf(13, 4)
        head2.next?.next = shared

        assertEquals(linkedListOf(29, 23, 82, 11, 12, 27), head1)
        assertEquals(linkedListOf(13, 4, 12, 27), head2)

        assertEquals(
            shared,
            solution.getIntersectionNode2(head1, head2)
        )
    }

    @Test
    fun `intersect - has intersection, equal size - solution 2`() {
        val shared = linkedListOf(27)
        val head1 = linkedListOf(12)
        head1.next = shared

        val head2 = linkedListOf(13)
        head2.next = shared

        assertEquals(linkedListOf(12, 27), head1)
        assertEquals(linkedListOf(13, 27), head2)

        assertEquals(
            shared,
            solution.getIntersectionNode2(head1, head2)
        )
    }

    @Test
    fun `intersect - no intersection - solution 3`() {
        val head1 = linkedListOf(29, 23, 82, 11, 12, 27)
        val head2 = linkedListOf(13, 4)
        assertNull(solution.getIntersectionNode3(head1, head2))
    }

    @Test
    fun `intersect - has intersection - solution 3`() {
        val shared = linkedListOf(12, 27)
        val head1 = linkedListOf(29, 23, 82, 11)
        head1.next?.next?.next?.next = shared

        val head2 = linkedListOf(13, 4)
        head2.next?.next = shared

        assertEquals(linkedListOf(29, 23, 82, 11, 12, 27), head1)
        assertEquals(linkedListOf(13, 4, 12, 27), head2)

        assertEquals(
            shared,
            solution.getIntersectionNode3(head1, head2)
        )
    }

    @Test
    fun `intersect - has intersection, equal size - solution 3`() {
        val shared = linkedListOf(27)
        val head1 = linkedListOf(12)
        head1.next = shared

        val head2 = linkedListOf(13)
        head2.next = shared

        assertEquals(linkedListOf(12, 27), head1)
        assertEquals(linkedListOf(13, 27), head2)

        assertEquals(
            shared,
            solution.getIntersectionNode3(head1, head2)
        )
    }
}