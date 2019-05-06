package leetcode.medium._049_group_anagrams

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GroupAnagramsTest {

    private val solution = Solution()
    private val solution2 = SolutionTwo()
    private val largeInput = arrayOf(
        "hos", "boo", "nay", "deb", "wow", "bop", "bob", "brr", "hey", "rye", "eve", "elf", "pup", "bum",
        "iva", "lyx", "yap", "ugh", "hem", "rod", "aha", "nam", "gap", "yea", "doc", "pen", "job", "dis",
        "max", "oho", "jed", "lye", "ram", "pup", "qua", "ugh", "mir", "nap", "deb", "hog", "let", "gym",
        "bye", "lon", "aft", "eel", "sol", "jab"
    )

    @Test
    fun groupAnagrams() {
        val expected = listOf(listOf("ate", "eat", "tea"), listOf("nat", "tan"), listOf("bat"))
        val actual = solution.groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
            .map { it.sorted() }

        assertEquals(expected.size, actual.size)
        expected.forEach { sublist ->
            assertTrue(sublist in actual)
        }

        val expectedLargeInputResult = listOf(
            listOf("sol"),
            listOf("wow"),
            listOf("gap"),
            listOf("hem"),
            listOf("yap"),
            listOf("bum"),
            listOf("ugh", "ugh"),
            listOf("aha"),
            listOf("jab"),
            listOf("eve"),
            listOf("bop"),
            listOf("lyx"),
            listOf("jed"),
            listOf("iva"),
            listOf("rod"),
            listOf("boo"),
            listOf("brr"),
            listOf("hog"),
            listOf("nay"),
            listOf("mir"),
            listOf("deb", "deb"),
            listOf("aft"),
            listOf("dis"),
            listOf("yea"),
            listOf("hos"),
            listOf("rye"),
            listOf("hey"),
            listOf("doc"),
            listOf("bob"),
            listOf("eel"),
            listOf("pen"),
            listOf("job"),
            listOf("max"),
            listOf("oho"),
            listOf("lye"),
            listOf("ram"),
            listOf("nap"),
            listOf("elf"),
            listOf("qua"),
            listOf("pup", "pup"),
            listOf("let"),
            listOf("gym"),
            listOf("nam"),
            listOf("bye"),
            listOf("lon")
        )
        val actualLargeResult = solution.groupAnagrams(largeInput).map { it.sorted() }
        assertEquals(expectedLargeInputResult.size, actualLargeResult.size)
        expectedLargeInputResult.forEach { sublist ->
            assertTrue(sublist in actualLargeResult)
        }
    }

    @Test
    fun groupAnagrams2() {
        val expected = listOf(listOf("ate", "eat", "tea"), listOf("nat", "tan"), listOf("bat"))
        val actual = solution2.groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
            .map { it.sorted() }
        assertEquals(expected.size, actual.size)
        expected.forEach { sublist ->
            assertTrue(sublist in actual)
        }

        val expectedLargeInputResult = listOf(
            listOf("sol"),
            listOf("wow"),
            listOf("gap"),
            listOf("hem"),
            listOf("yap"),
            listOf("bum"),
            listOf("ugh", "ugh"),
            listOf("aha"),
            listOf("jab"),
            listOf("eve"),
            listOf("bop"),
            listOf("lyx"),
            listOf("jed"),
            listOf("iva"),
            listOf("rod"),
            listOf("boo"),
            listOf("brr"),
            listOf("hog"),
            listOf("nay"),
            listOf("mir"),
            listOf("deb", "deb"),
            listOf("aft"),
            listOf("dis"),
            listOf("yea"),
            listOf("hos"),
            listOf("rye"),
            listOf("hey"),
            listOf("doc"),
            listOf("bob"),
            listOf("eel"),
            listOf("pen"),
            listOf("job"),
            listOf("max"),
            listOf("oho"),
            listOf("lye"),
            listOf("ram"),
            listOf("nap"),
            listOf("elf"),
            listOf("qua"),
            listOf("pup", "pup"),
            listOf("let"),
            listOf("gym"),
            listOf("nam"),
            listOf("bye"),
            listOf("lon")
        )
        val actualLargeResult = solution2.groupAnagrams(largeInput).map { it.sorted() }
        assertEquals(expectedLargeInputResult.size, actualLargeResult.size)
        expectedLargeInputResult.forEach { sublist ->
            assertTrue(sublist in actualLargeResult)
        }
    }
}
