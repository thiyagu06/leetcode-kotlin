package leetcode.easy._914_x_of_a_kind_in_a_deck_of_cards

/**
 * 914 - https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/description/
 */
class Solution {
    fun hasGroupsSizeX(deck: IntArray): Boolean {
        if (deck.size < 2) return false

        val sortedDeck = deck.sorted()
        val n = deck.size
        for (k in 1..n) {   // k: number of groups
            val x = n / k   // x: cards per group
            if (n % x == 0) {
                val grouped = sortedDeck.chunked(k)
                val firstGroupSize = grouped.first().size
                val splittable = grouped.all { group ->
                    group.size >= 2
                            && group.size == firstGroupSize
                            && group.all { element -> element == group.first() }
                }
                if (splittable) return true
            }
        }

        return false
    }
}