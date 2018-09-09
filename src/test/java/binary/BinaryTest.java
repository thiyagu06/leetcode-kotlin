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
}
