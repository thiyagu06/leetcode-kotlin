package algorithms.easy._292_nim_game

/**
 * 292 - https://leetcode.com/problems/nim-game/description/
 */
class BruteForceSolution {
    /**
     * Time: O(n!)
     * Space: O(n)
     */
    fun canWinNim(n: Int): Boolean {
        require (n >= 0) { "n must be >= 0 but was $n"}
        return when (n) {
            0 -> false
            in 1..3 -> true
            4 -> false
            else -> !canWinNim(n - 1) || !canWinNim(n - 2) || !canWinNim(n - 3)
        }
    }
}

class SolutionMemo {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun canWinNim(n: Int,
                  cache: MutableMap<Int, Boolean> = mutableMapOf(
                          0 to false, 1 to true, 2 to true, 3 to true, 4 to false
                  )): Boolean {

        require (n >= 0) { "n must be >= 0 but was $n"}
        return when (n) {
            in 0..4 -> cache[n]!!
            else -> {
                val takeXWillWin: (Int) -> Boolean = { x -> cache.getOrPut(x) { canWinNim(x) } }
                return !takeXWillWin(n - 3) || !takeXWillWin(n - 2) || !takeXWillWin(n - 1)
            }
        }
    }
}

class SolutionTabulation {
    /**
     * Time: O(n)
     * Space: O(n) - could be done in constant space because you only ever need the last 3 results.
     */
    fun canWinNim(n: Int): Boolean {
        require (n >= 0) { "n must be >= 0 but was $n"}
        val outcomes = mutableMapOf(
                0 to false,
                1 to true,
                2 to true,
                3 to true,
                4 to false
        )

        outcomes[n]?.let { return it }

        (5..n).forEach { i ->
            outcomes[i] = !(outcomes[i - 3]!!) || !(outcomes[i - 2]!!) || !(outcomes[i - 1]!!)
        }

        return outcomes[n]!!
    }
}

class SolutionOptimal {
    /**
     * Time: O(1)
     * Space: O(1)
     */
    fun canWinNim(n: Int): Boolean = n % 4 != 0
}

