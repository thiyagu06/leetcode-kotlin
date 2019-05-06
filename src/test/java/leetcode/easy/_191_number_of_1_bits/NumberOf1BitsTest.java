package leetcode.easy._191_number_of_1_bits;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("NumericOverflow")
public class NumberOf1BitsTest {

    private final Solution solution = new Solution();

    @Test
    public void hammingWeight() {
        // 00000000000000000000000000001011
        assertEquals(3, solution.hammingWeight(11));
        // 00000000000000000000000010000000
        assertEquals(1, solution.hammingWeight(128));

        // 00000000000000000000000000001111
        assertEquals(4, solution.hammingWeight(15));
        // 00000000000000000000000000000111
        assertEquals(3, solution.hammingWeight(7));

        assertEquals(0, solution.hammingWeight(0));

        assertEquals(1, solution.hammingWeight(1));
    }

    @Test
    public void edgeCases() {
        // 2147483647 (01111111111111111111111111111111)
        assertEquals(31, solution.hammingWeight(Integer.MAX_VALUE));

        // -2147483648 (10000000000000000000000000000000)
        assertEquals(1, solution.hammingWeight(Integer.MIN_VALUE));

        // Integer.MAX_VALUE + 1 == Integer.MIN_VALUE
        // 2147483648 (10000000000000000000000000000000)
        assertEquals(1, solution.hammingWeight(Integer.MAX_VALUE + 1));

        // Integer.MIN_VALUE - 1 == Integer.MAX_VALUE
        // 00000000000000000000000010000000
        assertEquals(31, solution.hammingWeight(Integer.MIN_VALUE - 1));
    }

    @Test
    public void hammingWeightAlt() {
        // 00000000000000000000000000001011
        assertEquals(3, solution.hammingWeightAlt(11));
        // 00000000000000000000000010000000
        assertEquals(1, solution.hammingWeightAlt(128));

        // 00000000000000000000000000001111
        assertEquals(4, solution.hammingWeightAlt(15));
        // 00000000000000000000000000000111
        assertEquals(3, solution.hammingWeightAlt(7));

        assertEquals(0, solution.hammingWeightAlt(0));

        assertEquals(1, solution.hammingWeightAlt(1));
    }

    @Test
    public void edgeCasesAlt() {
        // 2147483647 (01111111111111111111111111111111)
        assertEquals(31, solution.hammingWeightAlt(Integer.MAX_VALUE));

        // -2147483648 (10000000000000000000000000000000)
        assertEquals(1, solution.hammingWeightAlt(Integer.MIN_VALUE));

        // Integer.MAX_VALUE + 1 == Integer.MIN_VALUE
        // 2147483648 (10000000000000000000000000000000)
        assertEquals(1, solution.hammingWeightAlt(Integer.MAX_VALUE + 1));

        // Integer.MIN_VALUE - 1 == Integer.MAX_VALUE
        // 00000000000000000000000010000000
        assertEquals(31, solution.hammingWeightAlt(Integer.MIN_VALUE - 1));
    }
}