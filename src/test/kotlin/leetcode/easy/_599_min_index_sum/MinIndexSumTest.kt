package leetcode.easy._599_min_index_sum

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class MinIndexSumTest {

    private val solution = Solution()

    @Test
    fun findRestaurant() {
        assertArrayEquals(
            arrayOf("Shogun", "KFC"), solution.findRestaurant(
                arrayOf("Shogun", "KFC"),
                arrayOf("KFC", "Shogun")
            )
        )

        assertArrayEquals(
            arrayOf("Shogun"), solution.findRestaurant(
                arrayOf("Shogun", "Tapioca Express", "Burger King", "KFC"),
                arrayOf("Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun")
            )
        )

        assertArrayEquals(
            arrayOf("Shogun"), solution.findRestaurant(
                arrayOf("Shogun", "Tapioca Express", "Burger King", "KFC"),
                arrayOf("KFC", "Shogun", "Burger King")
            )
        )
    }
}