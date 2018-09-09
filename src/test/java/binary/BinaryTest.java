package binary;

import org.junit.Test;
import utils.Binary;

import static extensions.math.BinaryKt.INT_BITS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryTest {

    @Test
    public void hasKthBitSet() {
        for (int k = 0; k < INT_BITS; k++) {
            if (k <= 3) {
                assertTrue(Binary.hasKthBitSet(15, k));
            } else {
                assertFalse(Binary.hasKthBitSet(15, k));
            }
        }

        for (int k = 0; k < INT_BITS; k++) {
            assertFalse(Binary.hasKthBitSet(0, k));
        }
        for (int k = 0; k < INT_BITS; k++) {
            assertTrue(Binary.hasKthBitSet(-1, k));
        }
    }

    @Test
    public void positionOfRightmost1Bit() {
        assertEquals(0, Binary.positionOfRightmost1Bit(15));
        assertEquals(1, Binary.positionOfRightmost1Bit(10));
        assertEquals(3, Binary.positionOfRightmost1Bit(8));
        assertEquals(-1, Binary.positionOfRightmost1Bit(0));
        assertEquals(0, Binary.positionOfRightmost1Bit(-5));
        assertEquals(1, Binary.positionOfRightmost1Bit(234));
    }

    @Test
    public void positionOfRightmost0Bit() {
        assertEquals(4, Binary.positionOfRightmost0Bit(15));
        assertEquals(0, Binary.positionOfRightmost0Bit(10));
        assertEquals(0, Binary.positionOfRightmost0Bit(8));
        assertEquals(0, Binary.positionOfRightmost0Bit(0));
        assertEquals(-1, Binary.positionOfRightmost0Bit(-1));
        assertEquals(2, Binary.positionOfRightmost0Bit(-5));
    }

    @Test
    public void swapBits() {
        assertEquals(15, Binary.swapBits(15, 0, 0));
        assertEquals(15, Binary.swapBits(15, 0, 1));
        assertEquals(15, Binary.swapBits(15, 0, 2));
        assertEquals(15, Binary.swapBits(15, 0, 3));
        assertEquals(30, Binary.swapBits(15, 0, 4));
        assertEquals(46, Binary.swapBits(15, 0, 5));

        assertEquals(7, Binary.swapBits(7, 0, 1));
        assertEquals(7, Binary.swapBits(7, 0, 2));
        assertEquals(14, Binary.swapBits(7, 0, 3));
        assertEquals(22, Binary.swapBits(7, 0, 4));

        assertEquals(9, Binary.swapBits(3, 1, 3));

        int x = 3;
        Binary.swapBits(x, 1, 3);
        assertEquals(3, x);
    }
}
