package leetcode.medium._077_combinations

/**
 * 77 - https://leetcode.com/problems/combinations/
 */
class Solution {
    /**
     * Approach 1: Generate Power Set, then filter k-sized sublists.
     * Time: O(?)
     * Space: O(?)
     */
    fun combine(n: Int, k: Int): List<List<Int>> {
        require(n >= 1) { "Invalid n: $n" }

        val list = (1..n).toList()
        if (list.size == k)
            return listOf(list)

        return powerSet(list, listOf(listOf())).filter { it.size == k }
    }
}

private tailrec fun <T> powerSet(list: List<T>, acc: List<List<T>>): List<List<T>> =
    if (list.isEmpty()) acc
    else powerSet(list.drop(1), acc + acc.map { it + list.first() })


class SolutionTwo {
    /**
     * Time: O(?)
     * Space: O(?)
     */
    fun combine(n: Int, k: Int): List<List<Int>> = combine(1..n, n, k)

    private fun combine(range: IntRange, n: Int, k: Int): List<List<Int>> = when {
        k == 0 || k > n -> listOf(emptyList())

        // k == n: n choose n
        k == n -> listOf((1..n).toList())

        // k = 1: Return single-element lists
        k == 1 -> range.fold(arrayListOf()) { acc, num ->
            acc.apply { acc.add(listOf(num)) }
        }

        else -> {
            val combinations = mutableListOf<List<Int>>()
            for (i in range) {
                val tailCombinations = combine(i + 1..n, n, k - 1)
                val newCombinations = tailCombinations.map { listOf(i) + it }
                combinations.addAll(newCombinations)
            }
            combinations
        }
    }
}

