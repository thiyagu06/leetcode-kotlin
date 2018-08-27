package algorithms.easy._070_climbing_stairs

/**
 * 70 - https://leetcode.com/problems/climbing-stairs/description/
 */
class NaiveSolution {


    /**
     * Time: O()
     * Space: O(?)
     */
    fun climbStairs(n: Int): Int {
        require(n > 0) { "n must be a positive integer" }

        return when (n) {
            in 1..2 -> n
            else -> climbStairs(n - 1) + climbStairs(n - 2)
        }
    }
}

class MemoizedSolution {

    private val cache = hashMapOf<Int, Int>()

    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun climbStairs(n: Int): Int {
        require(n > 0) { "n must be a positive integer" }

        return when (n) {
            in 1..2 -> n
            else -> {
                if (!cache.containsKey(n)) {
                    cache[n] = climbStairs(n - 1) + climbStairs(n - 2)
                }
                cache[n]!!
            }
        }
    }
}

class TabulationSolution {

    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun climbStairs(n: Int): Int {
        require(n > 0) { "n must be a positive integer" }

        val cache = hashMapOf(
            1 to 1,
            2 to 2
        )

        if (n in 1..2) return cache[n]!!

        (3..n).forEach { i ->
            cache[i] = cache[i - 1]!! + cache[i - 2]!!
        }

        return cache[n]!!
    }
}

class OptimalSolution {

    /**
     * Time: O(n)
     * Space: O(1)
     */
    fun climbStairs(n: Int): Int {
        require(n > 0) { "n must be a positive integer" }

        return when (n) {
            in 1..2 -> n
            else -> {
                var minus1 = 2  // f(2)
                var minus2 = 1  // f(1)
                var current = minus1 + minus2

                (3..n).forEach {
                    current = minus1 + minus2
                    minus2 = minus1
                    minus1 = current
                }

                current
            }
        }

    }
}