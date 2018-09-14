package leetcode.easy._190_reverse_bits;

import static extensions.math.BinaryKt.INT_BITS;

/**
 * 190 - https://leetcode.com/problems/reverse-bits/description/
 * Note: treat n as an unsigned value
 */
class Solution {
    /**
     * Time: O(1)
     * Space: O(1)
     */
    public int reverseBits(int n) {
        int reversed = n;
        int i = 0;
        int j = INT_BITS - 1;
        while (i < j) {
            reversed = swapBits(reversed, i, j);
            i++;
            j--;
        }

        return reversed;
    }

    private int swapBits(int x, int i, int j) {
        final int iBit = (x >> i) & 1;
        final int jBit = (x >> j) & 1;

        if ((iBit ^ jBit) == 0) {   // both 0 or both 1
            return x;
        }

        return x ^ ((1 << i) | (1 << j));
    }


    // you need treat n as an unsigned value
    public int reverseBits2(int n) {
        return Integer.reverse(n);
    }

    /**
     * https://leetcode.com/problems/reverse-bits/discuss/54738/Sharing-my-2ms-Java-Solution-with-Explanation
     */
    public int reverseBits3(int n) {
        int reversed = 0;
        for (int i = 0; i < INT_BITS; i++) {
            reversed <<= 1;         // move bits in rev. up 1 to make room
            if ((n & 1) == 1) {
                reversed += 1;
            }
            n >>= 1;
        }
        return reversed;
    }
}