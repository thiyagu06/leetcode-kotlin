package datastructures.tree

import org.junit.Assert.*
import org.junit.Ignore
import org.junit.Test

/**
 * @author nrojiani
 * @date 11/18/17
 */
class TreeNodeTest {

    @Test
    fun dfs() {
        val values = arrayListOf<Int>()
        tree123.dfs { values += it.`val` }
        assertEquals(arrayListOf(2, 1, 3), values)

        val bstValues = arrayListOf<Int>()
        bst3LevelsFull.dfs { bstValues += it.`val` }
        assertEquals(listOf(1, 3, 4, 5, 6, 8, 9), bstValues.toList())
    }

    @Test
    fun bfs() {
        val nodesTree123 = arrayListOf<Int>()
        tree123.bfs { nodesTree123 += it.`val` }
        assertEquals(listOf(1, 2, 3), nodesTree123)

        val nodesTree1to5 = arrayListOf<Int>()
        tree1to5.bfs { nodesTree1to5 += it.`val` }
        assertEquals(listOf(1, 2, 3, 4, 5), nodesTree1to5)

        val nodesBst3LevelsFull = arrayListOf<Int>()
        bst3LevelsFull.bfs { nodesBst3LevelsFull += it.`val` }
        assertEquals(listOf(5, 3, 8, 1, 4, 6, 9), nodesBst3LevelsFull)

        val nodesBstWithNulls = arrayListOf<Int>()
        bstWithNulls.bfs { nodesBstWithNulls += it.`val` }
        assertEquals(listOf(7, 4, 9, 3, 8, 1), nodesBstWithNulls)
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

        val tree2 = buildTree(7, 4, 9, 3, null, 8, null, 1)
        assertEquals(bstWithNulls, tree2)
        assertEquals(6, tree2?.size)
        assertEquals(7, tree2?.`val`)
        assertEquals(4, tree2?.left?.`val`)
        assertEquals(9, tree2?.right?.`val`)
        assertEquals(3, tree2?.left?.left?.`val`)
        assertEquals(1, tree2?.left?.left?.left?.`val`)
        assertEquals(8, tree2?.right?.left?.`val`)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `buildTree throws exception if root is null`() {
        buildTree(null)
    }

    @Test
    fun buildBST() {
        val tree1 = buildBST(2, 1, 3)
        assertNotNull(tree1)
        assertEquals(3, tree1?.size)
        assertEquals(2, tree1?.`val`)
        assertEquals(1, tree1?.left?.`val`)
        assertEquals(3, tree1?.right?.`val`)

        val tree2 = buildBST(7, 4, 9, 3, null, 8, null, 1)
        assertEquals(bstWithNulls, tree2)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `buildBST throws exception if root is null`() {
        buildBST(null)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `buildBST throws exception if elements violate BST property`() {
        buildBST(1, 2, 3)
    }

    @Test
    fun rootToLeafPaths() {
        assertEquals(listOf(listOf(1, 2), listOf(1, 3)), tree123.rootToLeafPaths())
        assertEquals(listOf(listOf(5, 3, 1), listOf(5, 3, 4), listOf(5, 8, 6), listOf(5, 8, 9)),
                bst3LevelsFull.rootToLeafPaths())
        assertEquals(listOf(listOf(7, 4, 3, 1), listOf(7, 9, 8)), bstWithNulls.rootToLeafPaths())
    }

    @Test
    fun find() {
        (1..9).forEach { i ->
            if (i in setOf(2, 7))
                assertNull(bst3LevelsFull.find(i))
            else
                assertEquals(i, bst3LevelsFull.find(i)?.`val`)
        }

        (1..9).forEach { i ->
            if (i in setOf(2, 5, 6))
                assertNull(bstWithNulls.find(i))
            else
                assertEquals(i, bstWithNulls.find(i)?.`val`)
        }
    }

    @Test
    fun contains() {
        (1..9).forEach { i ->
            if (i in setOf(2, 7))
                assertFalse(bst3LevelsFull.contains(i))
            else
                assertTrue(bst3LevelsFull.contains(i))
        }

        (1..9).forEach { i ->
            if (i in setOf(2, 5, 6))
                assertFalse(bstWithNulls.contains(i))
            else
                assertTrue(bstWithNulls.contains(i))
        }
    }
}
