package leetcode.medium._039_combination_sum

/**
 * 39 - https://leetcode.com/problems/combination-sum/
 */
class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val solutionSet = arrayListOf<List<Int>>()
        combinationSum(candidates.toList(), target, listOf(), solutionSet)
        return solutionSet
    }

    private fun combinationSum(
        candidates: List<Int>,
        target: Int,
        currentSolution: List<Int>,
        solutionSet: MutableList<List<Int>>
    ) {
        when {
            target < 0 || candidates.isEmpty() -> return
            target == 0 -> {
                solutionSet += currentSolution
            }
            else -> {
                combinationSum(
                    candidates = candidates.drop(1), target = target,
                    currentSolution = currentSolution, solutionSet = solutionSet
                )

                combinationSum(
                    candidates = candidates, target = target - candidates.first(),
                    currentSolution = currentSolution + candidates.first(), solutionSet = solutionSet
                )
            }
        }
    }
}


class Solution2 {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val solutionSet = hashSetOf<List<Int>>()
        backtrack(solutionSet, arrayListOf(), candidates.toList(), target)
        return solutionSet.toList()
    }

    private fun backtrack(
        solutionSet: MutableSet<List<Int>>,
        currentSolution: List<Int>,
        candidates: List<Int>,
        remaining: Int
    ) {
        when {
            remaining < 0 -> return
            remaining == 0 -> {
                solutionSet += currentSolution
            }
            else ->
                candidates.forEachIndexed { i, n  ->
                    if (!solutionSet.contains(currentSolution + n)) {
                        backtrack(
                            solutionSet = solutionSet,
                            currentSolution = currentSolution + n,
                            candidates = candidates.drop(i),
                            remaining = remaining - n
                        )
                    }
                }
        }
    }
}
