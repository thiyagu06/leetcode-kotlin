package leetcode.easy._070_climbing_stairs

/**
 * 70 - https://leetcode.com/problems/climbing-stairs/
 */
class NaiveSolution {

    /**
     * Naive recursive solution
     * Time: O(2^n)
     * Space: O(n)
     */
    fun climbStairs(n: Int): Int = when (n) {
        in 0..2 -> n
        else -> climbStairs(n - 1) + climbStairs(n - 2)
    }
}

class MemoizedSolutionOne {

    private val cache = mutableMapOf(
        0 to 0,
        1 to 1,
        2 to 2
    )

    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun climbStairs(n: Int): Int {
        if (n !in cache) {
            cache[n] = climbStairs(n - 1) + climbStairs(n - 2)
        }
        return cache.getValue(n)
    }
}

class MemoizedSolutionTwo {

    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun climbStairs(
        n: Int,
        cache: MutableMap<Int, Int> = hashMapOf(0 to 1, 1 to 1, 2 to 2)
    ): Int {
        if (n !in cache) {
            cache[n] = climbStairs(n - 1, cache) + climbStairs(n - 2, cache)
        }
        return cache.getValue(n)
    }
}

class MemoizedSolutionThree {

    private val cache = mutableMapOf(
        0 to 0,
        1 to 1,
        2 to 2
    )

    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun climbStairs(n: Int): Int = cache.getOrPut(
        key = n,
        defaultValue = { climbStairs(n - 1) + climbStairs(n - 2) }
    )
}

class TabulationSolution {
    /**
     * Tabulation solution with HashTable
     * Time: O(n)
     * Space: O(n)
     */
    fun climbStairs(n: Int): Int {
        val cache = mutableMapOf(
            0 to 0,
            1 to 1,
            2 to 2
        )

        (3..n).forEach { x ->
            cache[x] = cache.getValue(x - 1) + cache.getValue(x - 2)
        }

        return cache.getValue(n)
    }
}

class OptimalSolution {
    /**
     * Tabulation solution, only keep track of last 2 results.
     * Time: O(n)
     * Space: O(1)
     */
    fun climbStairs(n: Int): Int {
        if (n in 0..2) return n

        var minus2 = 1              // climbStairs(1)
        var minus1 = 2              // climbStairs(2)
        var waysToClimbN = 1 + 2    // climbStairs(3)

        (3..n).forEach { _ ->
            waysToClimbN = minus1 + minus2
            minus2 = minus1
            minus1 = waysToClimbN
        }

        return waysToClimbN
    }
}