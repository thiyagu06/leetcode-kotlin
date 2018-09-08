package algorithms.easy._191_number_of_1_bits;

public class Solution {

    private static final int INT_BITS = 32;

    /**
     * Time: O(n)
     * Space: O(1)
     *
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
     * Time: O(n)
     * Space: O(1)
     *
     * n &= (n - 1) removes the least significant 1 bit in n:
     * 1111 (15) ->
     * 1110 (14) ->
     * 1100 (12) ->
     * 1000 ( 8) ->
     * 0000 ( 0)
     *
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