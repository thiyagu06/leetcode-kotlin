package leetcode.easy._190_reverse_bits;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseBitsTest {

    private final Solution solution = new Solution();

    @Test
    public void reverseBits() {
        assertEquals(-1342177280, solution.reverseBits(13));

        assertEquals(1342177280, solution.reverseBits(10));
        // 15:          11110000000000000000000000000000
        // 15 reversed: 00000000000000000000000000001111
        assertEquals(-268435456, solution.reverseBits(15));

        assertEquals(964176192, solution.reverseBits(43261596));
        assertEquals(43261596, solution.reverseBits(964176192));

        assertEquals(-1, solution.reverseBits(-1));
        assertEquals(0, solution.reverseBits(0));
        assertEquals(Integer.MIN_VALUE, solution.reverseBits(1));
        assertEquals(1, solution.reverseBits(Integer.MIN_VALUE));

        assertEquals(-2, solution.reverseBits(Integer.MAX_VALUE));
        assertEquals(Integer.MAX_VALUE, solution.reverseBits(-2));
        assertEquals(-536870912, solution.reverseBits(7));
    }

    @Test
    public void reverseBits2() {
        assertEquals(-1342177280, solution.reverseBits2(13));

        assertEquals(1342177280, solution.reverseBits2(10));
        assertEquals(-268435456, solution.reverseBits2(15));

        assertEquals(964176192, solution.reverseBits2(43261596));
        assertEquals(43261596, solution.reverseBits2(964176192));

        assertEquals(-1, solution.reverseBits2(-1));
        assertEquals(0, solution.reverseBits2(0));
        assertEquals(Integer.MIN_VALUE, solution.reverseBits2(1));
        assertEquals(1, solution.reverseBits2(Integer.MIN_VALUE));

        assertEquals(-2, solution.reverseBits2(Integer.MAX_VALUE));
        assertEquals(Integer.MAX_VALUE, solution.reverseBits2(-2));
        assertEquals(-536870912, solution.reverseBits2(7));
    }

    @Test
    public void reverseBits3() {
        assertEquals(-1342177280, solution.reverseBits3(13));

        assertEquals(1342177280, solution.reverseBits3(10));

        assertEquals(-268435456, solution.reverseBits3(15));

        assertEquals(-268435456, solution.reverseBits3(15));

        assertEquals(964176192, solution.reverseBits3(43261596));
        assertEquals(43261596, solution.reverseBits3(964176192));

        assertEquals(-1, solution.reverseBits3(-1));
        assertEquals(0, solution.reverseBits3(0));
        assertEquals(Integer.MIN_VALUE, solution.reverseBits3(1));
        assertEquals(1, solution.reverseBits3(Integer.MIN_VALUE));

        assertEquals(-2, solution.reverseBits3(Integer.MAX_VALUE));
        assertEquals(Integer.MAX_VALUE, solution.reverseBits3(-2));
        assertEquals(-536870912, solution.reverseBits3(7));
    }
}