package com.sloppydobby.java.bitmask;

/**
 * Bitmask utilities class.
 *
 * @author Sergey Grigorov
 * @since Added in 0.0.1
 */
public class BitmaskUtils {

    /**
     * This constant represent the unspecified direction of bitmask generation as byte <code>0000 0001</code>.
     *
     * @since Added in 0.0.1
     */
    private static final byte NO_TYPE = 0b1; // 0000 0001

    /**
     * This constant represent backward bitmask (with right-to-left high bits placing) type as byte <code>0000 0010</code>.
     * This direction calculates of <code>NO_TYPE</code> constant with left offset to 1 bit.
     *
     * @since Added in 0.0.1
     */
    public static final byte TYPE_BACKWARD = NO_TYPE << 1; // 0000 0010

    /**
     * This constant represent forward bitmask (with left-to-right high bits placing) type as byte <code>0000 0100</code>.
     * This direction calculates of <code>NO_TYPE</code> constant with left offset to 2 bits.
     *
     * @since Added in 0.0.1
     */
    public static final byte TYPE_FORWARD = TYPE_BACKWARD << 1; // 0000 0100

    /**
     * This method generates backward bitmask (with right-to-left high bits placing) by specified parameters.
     *
     * @param highBitsCount Bitmask high bits count (less than or equal to 32)
     * @param leftOffset High bits left offset (less than or equals to 32)
     *
     * @return Generated backward bitmask
     *
     * @since Added in 0.0.1
     */
    public static int generateBackwardBitmask(
            final int highBitsCount,
            final int leftOffset
    ) {
        return (1 << highBitsCount) - 1 << leftOffset;
    }

    /**
     * This method generates forward bitmask (with left-to-right bits placing) by specified parameters.
     *
     * @param size Bitmask size (less than or equal to 32)
     * @param highBitsCount Bitmask high bits count (less than or equal to 32)
     * @param rightOffset High bits right offset (less than or equal to 32)
     *
     * @return Generated forward bitmask
     *
     * @since Added in 0.0.1
     */
    public static int generateForwardBitmask(
            final int size,
            final int highBitsCount,
            final int rightOffset
    ) {
        final int leftOffset = size - highBitsCount - rightOffset;
        return generateBackwardBitmask(highBitsCount, leftOffset);
    }

    /**
     * This method generates a bitmask by specified parameters and type.
     *
     * @param size Bitmask size (only for <code>TYPE_FORWARD</code> bitmasks, less than or equal to 32)
     * @param highBitsCount Bitmask high bits count (less than or equal to 32)
     * @param offset Bitmask high bits offset (start from left for <code>TYPE_FORWARD</code> or from right for <code>TYPE_BACKWARD</code>, less than or equal to 32)
     * @param type Bitmask type (<code>TYPE_FORWARD</code> or <code>TYPE_BACKWARD</code>)
     *
     * @return Generated bitmask
     *
     * @throws IllegalArgumentException This exception throws when <code>type</code> parameter is not <code>TYPE_BACKWARD</code> or <code>TYPE_FORWARD</code>
     *
     * @since Added in 0.0.1
     */
    public static int generateBitmask(
            final int size,
            final int highBitsCount,
            final int offset,
            final byte type
    ) throws IllegalArgumentException {
        switch (type) {
            case TYPE_BACKWARD:
                return generateBackwardBitmask(highBitsCount, offset);

            case TYPE_FORWARD:
                return generateForwardBitmask(size, highBitsCount, offset);

            default:
                throw new IllegalArgumentException("Unknown bitmask type");
        }
    }

}
