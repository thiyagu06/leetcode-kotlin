package leetcode.medium._567_permutation_in_a_string

import extensions.strings.characterFrequencies

class Solution {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun checkInclusion(s1: String, s2: String): Boolean {
        var count = s1.length
        val n = s2.length
        var hash = s1.characterFrequencies().toMutableMap()
        var l = 0
        var r = 0

        println("s1: $s1")
        println("s2: $s2")

        while (l < n && r < n && count > 0) {
//            if (hash.values.all { it == 0 }) return true

            val (charL, charR) = (s2[l] to s2[r])
            println("\n(l, r) = ($l, $r), (charL, charR) = ($charL, $charR)")
            println("s2[l:r] = ${s2.substring(l..r)}")
            println("hash: $hash")
            when {
                // charR is in s1
                hash.containsKey(charR) -> {
                    println("hash.contains($charR) -> T")
                    // and is not an overuse
                    if (hash[charR]!! > 0) {
                        println("not an overuse of $charR (hash[charR] == ${hash[charR]})")
                        hash[charR] = hash[charR]!! - 1
                        count--
                        println("count-- -> now $count")
                        r++     // widen window (l stays at same index)
                    } else {
                        println("overuse of $charR (hash[charR] == ${hash[charR]})")
                        // charR is overused. window contains more of the char than s1 does.
                        // evict left
                        if (hash.containsKey(charL)) {
                            hash[charL] = hash[charL]!! + 1
                            println("count++ -> now $count")
                            count++
                        }
                        l++     // r will be rechecked
                    }
                }
                // charR not in s1
                else -> {
                    println("hash.contains($charR) -> F")
                    // evict left
                    if (hash.containsKey(charL)) {  // charL was in s1.
                        println("hash.contains($charL) -> T. hash[$charL]++, count++")
                        hash[charL] = hash[charL]!! + 1
                        println("count++ -> now $count")
                        count++
                    }
                    r++
                    l++
                }
            }
            println("(END LOOP) -> hash: $hash, count: $count")
        }
        println("\n(END) -> hash: $hash, count: $count")

        return count == 0
    }
}


class SolutionTwo {
    /**
     * Time: O(n)
     * Space: O(n)
     */
    fun checkInclusion(s1: String, s2: String): Boolean {
        var count = s1.length
        val n = s2.length
        var hash = s1.characterFrequencies().toMutableMap()
        var l = 0
        var r = 0

        println("s1: $s1")
        println("s2: $s2")

        while (l < n && r < n && count > 0) {
            val (charL, charR) = (s2[l] to s2[r])
            println("\n(l, r) = ($l, $r), (charL, charR) = ($charL, $charR)")
            println("s2[l:r] = ${s2.substring(l..r)}")
            println("hash: $hash")
            when {
                // charR is in s1
                hash.containsKey(charR) -> {
                    println("hash.contains($charR) -> T")
                    // and is not an overuse
                    if (hash[charR]!! > 0) {
                        println("not an overuse of $charR (hash[charR] == ${hash[charR]})")
                        hash[charR] = hash[charR]!! - 1
                        count--
                        r++     // widen window (l stays at same index)
                    } else {
                        println("overuse of $charR (hash[charR] == ${hash[charR]})")
                        // charR is overused. window contains more of the char than s1 does.
                        // evict left
                        if (hash.containsKey(charL)) {
                            hash[charL] = hash[charL]!! + 1
                            count++
                        }
                        l++     // r will be rechecked
                    }
                }
                // charR not in s1
                else -> {
                    println("hash.contains($charR) -> F")
                    // evict left
                    if (hash.containsKey(charL)) {  // charL was in s1.
                        println("hash.contains($charL) -> T. hash[$charL]++, count++")
                        hash[charL] = hash[charL]!! + 1
                    }
                    count++
                    r++
                    // we know the rest of the window can't be used since the last isn't in s1
                    // evict all in [l, r)
                    (l until r).forEach { i ->
                        if (hash.containsKey(s2[i])) {
                            hash[s2[i]] = hash[s2[i]]!! + 1
                        }
                    }
                    l = r
                    count = s1.length
                    println("(AFTER l->r EVICTIONS:) -> hash: $hash, count: $count")
                }
            }
            println("(END LOOP) -> hash: $hash, count: $count")
        }
        println("\n\n(END) -> hash: $hash, count: $count")

        return count == 0
    }
}