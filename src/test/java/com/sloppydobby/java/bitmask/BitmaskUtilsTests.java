package com.sloppydobby.java.bitmask;

import org.junit.Assert;
import org.junit.Test;

public final class BitmaskUtilsTests {

    @Test
    public void testGenerateBackwardBitmask() {
        int expected;
        int actual;

        expected = 0b1;
        actual = BitmaskUtils.generateBackwardBitmask(1, 0);
        Assert.assertEquals(expected, actual);

        expected = 0b10;
        actual = BitmaskUtils.generateBackwardBitmask(1, 1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGenerateForwardBitmask() {
        int expected;
        int actual;

        expected = 0b10;
        actual = BitmaskUtils.generateForwardBitmask(2, 1, 0);
        Assert.assertEquals(expected, actual);

        expected = 0b1;
        actual = BitmaskUtils.generateForwardBitmask(2, 1, 1);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGenerateBitmask() {
        int expected;
        int actual;

        expected = 0b1;

        actual = BitmaskUtils.generateBitmask(2, 1, 0, BitmaskUtils.TYPE_BACKWARD);
        Assert.assertEquals(expected, actual);

        actual = BitmaskUtils.generateBitmask(2, 1, 1, BitmaskUtils.TYPE_FORWARD);
        Assert.assertEquals(expected, actual);

        expected = 0b10;

        actual = BitmaskUtils.generateBitmask(2, 1, 1, BitmaskUtils.TYPE_BACKWARD);
        Assert.assertEquals(expected, actual);

        actual = BitmaskUtils.generateBitmask(2, 1, 0, BitmaskUtils.TYPE_FORWARD);
        Assert.assertEquals(expected, actual);

        final byte unknownType = BitmaskUtils.TYPE_BACKWARD >> 1;
        BitmaskUtils.generateBitmask(1, 1, 0, unknownType);
    }

}
