package leetcode.easy._292_nim_game

/**
 * 292 - https://leetcode.com/problems/nim-game/
 */
class BruteForceSolution {
    /**
     * Time: O(n!)
     * Space: O(n)
     */
    fun canWinNim(n: Int): Boolean = when (n) {
        0 -> false
        in 1..3 -> true
        else -> !canWinNim(n - 1) || !canWinNim(n - 2) || !canWinNim(n - 3)
    }
}

class SolutionMemo {
    /**
     * Memoization
     * Time: O(n)
     * Space: O(n)
     */
    fun canWinNim(
        n: Int,
        memo: MutableMap<Int, Boolean> = hashMapOf(
            0 to false, 1 to true, 2 to true, 3 to true
        )
    ): Boolean {
        if (n !in memo) {
            memo[n] = !canWinNim(n - 3) || !canWinNim(n - 2) || !canWinNim(n - 1)
        }
        return memo[n]!!
    }
}

class SolutionTabulation {
    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun canWinNim(n: Int): Boolean {
        if (n == 0) return false
        if (n in 1..3) return true

        var minus3 = true    // canWinNim(1)
        var minus2 = true    // canWinNim(2)
        var minus1 = true    // canWinNim(3)
        var canWinN = false  // canWinNim(4)

        for (i in (4..n)) {
            canWinN = !minus1 || !minus2 || !minus3
            minus1 = minus2
            minus2 = minus3
            minus3 = canWinN
        }

        return canWinN
    }
}

class SolutionOptimal {
    /**
     * Time: O(1)
     * Space: O(1)
     */
    fun canWinNim(n: Int): Boolean = n % 4 != 0
}
