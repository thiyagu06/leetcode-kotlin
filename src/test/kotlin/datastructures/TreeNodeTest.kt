package datastructures

import org.junit.Assert.*
import org.junit.Ignore
import org.junit.Test

/**
 * @author nrojiani
 * @date 11/18/17
 */
class TreeNodeTest {

    @Test
    fun depthFirstSearch() {
        val values = arrayListOf<Int>()
        tree123.depthFirstSearch { values += it.`val` }
        assertEquals(arrayListOf(2, 1, 3), values)

        val bstValues = arrayListOf<Int>()
        bst3LevelsFull.depthFirstSearch { bstValues += it.`val` }
        assertEquals(listOf(1, 3, 4, 5, 6, 8, 9), bstValues.toList())
    }

    @Test
    fun toList() {
        assertEquals(listOf(1, 3, 4, 5, 6, 8, 9), bst3LevelsFull.toList())
    }

    @Test
    fun collect() {
        assertEquals(arrayListOf(2, 1, 3), tree123.collect())
        assertEquals(listOf(1, 3, 4, 5, 6, 8, 9), bst3LevelsFull.collect())
    }


    @Test
    fun collectWithTransform() {
        assertEquals(listOf(1, 3, 4, 5, 6, 8, 9).map { it * 2 },
                bst3LevelsFull.collect { it.`val` * 2 })
    }

    @Test
    fun buildTree() {
        val tree = buildTree(1, 2, 3)
        assertNotNull(tree)
        assertEquals(3, tree?.size)
        assertEquals(1, tree?.`val`)
        assertEquals(2, tree?.left?.`val`)
        assertEquals(3, tree?.right?.`val`)

        val tree2 = buildTree(5, 3, 8, 1, 4, 6, 9)
        assertNotNull(tree2)
        assertEquals(7, tree2?.size)
        assertEquals(bst3LevelsFull, tree2)
    }

    @Test
    fun buildTreeWithNulls() {
        val tree = buildTree(1, null, 2, 3)
        assertNotNull(tree)
        assertEquals(3, tree?.size)
        assertEquals(1, tree?.`val`)
        assertNull(tree?.left?.`val`)
        assertEquals(2, tree?.right?.`val`)
        assertEquals(3, tree?.right?.left?.`val`)
        assertNull(tree?.right?.left?.right)

        val tree2 = buildTree(7, 4, 9, 3, null, 6, null, 1)
        assertEquals(bstWithNulls, tree2)
        assertEquals(6, tree2?.size)
        assertEquals(7, tree2?.`val`)
        assertEquals(4, tree2?.left?.`val`)
        assertEquals(9, tree2?.right?.`val`)
        assertEquals(3, tree2?.left?.left?.`val`)
        assertEquals(1, tree2?.left?.left?.left?.`val`)
        assertEquals(6, tree2?.right?.left?.`val`)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Exception if root is null`() {
        buildTree(null)
    }

    @Ignore
    @Test
    fun contains() {
        TODO()
    }

    @Ignore
    @Test
    fun find() {
        TODO()
    }
}
