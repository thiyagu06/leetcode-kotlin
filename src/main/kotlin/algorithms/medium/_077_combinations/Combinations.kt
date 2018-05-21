package algorithms.medium._077_combinations

/**
 * 77 - https://leetcode.com/problems/combinations/description/
 */
class Solution {
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
