package leetcode.easy._191_number_of_1_bits;

/**
 * 191 - https://leetcode.com/problems/number-of-1-bits/
 */
class Solution {

    private static final int INT_BITS = 32;

    /**
     * Time: O(1) - The run time depends on the number of bits in n. Because n in this piece of code is a 32-bit integer,
     * the time complexity is O(1).
     * Space: O(1)
     * @param n An unsigned integer
     * @return The # of 1 bits in n
     */
    public int hammingWeight(int n) {
        int bitsSet = 0;
        int mask = 0b01;       // 0b0001

        for (int k = 0; k < INT_BITS; k++) {
            if ((n & mask) != 0) {
                bitsSet++;
            }

            mask <<= 1;         // shift the mask's set bit to the left
        }
        return bitsSet;
    }


    /**
     * Time: O(1) - The run time depends on the number of bits in n. Because n in this piece of code is a 32-bit integer,
     * the time complexity is O(1).
     * Space: O(1)
     * <p>
     * n &= (n - 1) removes the least significant 1 bit in n:
     * 1111 (15) ->
     * 1110 (14) ->
     * 1100 (12) ->
     * 1000 ( 8) ->
     * 0000 ( 0)
     * <p>
     * See https://leetcode.com/problems/number-of-1-bits/solution/ (Approach #2) for more info.
     * @param n An unsigned integer
     * @return The # of 1 bits in n
     */
    public int hammingWeightAlt(int n) {
        int bitsSet = 0;
        while (n != 0b0000) {
            bitsSet++;
            n &= (n - 1);
        }
        return bitsSet;
    }

}