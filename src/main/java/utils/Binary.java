package utils;

/**
 * Static functions for dealing with binary and bit manipulation.
 * Mostly just for practice, not actual use.
 * <p>
 * Kth bit = from right (least significant), starting from 0
 */
public class Binary {

    /* CHECKING THE VALUE OF BITS */
    public static boolean hasKthBitSet(int x, int k) {
        return (x & (1 << k)) != 0;
    }

    public static int kthBit(int x, int k) {
        return hasKthBitSet(x, k) ? 1 : 0;
    }

    /* CHECKING BIT-BASED PROPERTIES */
    public static boolean isOdd(int x) {
        return (x & 1) == 1;
    }

    public static boolean isEven(int x) {
        return (x & 1) == 0;
    }

    /* SETTING BITS */
    public static int withKthBitSet(int x, int k) {
        return x | (1 << k);
    }

    public static int withKthBitUnset(int x, int k) {
        return x & ~(1 << k);
    }

    public static int withKthBitToggled(int x, int k) {
        return x ^ (1 << k);
    }

    public static int extractRightmost1Bit(int x) {
        if (x == 0) {
            return -1;  // otherwise will return Integer.MIN_VALUE
        }

        return x & (-x);
    }

    public static int positionOfRightmost1Bit(int x) {
        if (x == 0) {
            return -1;  // otherwise will return Integer.MIN_VALUE
        }

        final int valueOfLowestSetBit = x & (-x);
        return (int) (Math.log2((double) valueOfLowestSetBit));
    }

    public static int extractRightmost0Bit(int x) {
        if (x == -1) {
            return -1;  // otherwise will return 0, but 0th bit not set.
        }

        return ~x & (x + 1);
    }


    public static int positionOfRightmost0Bit(int x) {
        if (x == -1) {
            return -1;  // otherwise will return 0, but 0th bit not set.
        }

        final int valueOfLowest0Bit = ~x & (x + 1);
        final int position = (int) (Math.log2((double) valueOfLowest0Bit));
        return position;
    }

    public static int unsetRightmost1Bit(int x) {
        return x & (x - 1);
    }
    public static int setRightmost0Bit(int x) {
        if (x == -1)
            return -1;

        int valueOfLowest0Bit = extractRightmost0Bit(x);
        return x ^ valueOfLowest0Bit;
    }


    public static int incremented(int x) {
        return -(~x);
    }

    public static int decremented(int x) {
        return ~(-x);
    }


}
