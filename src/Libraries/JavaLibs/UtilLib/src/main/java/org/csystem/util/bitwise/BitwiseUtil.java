/*----------------------------------------------------------------------
	FILE        : BitwiseUtil.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 13.06.2023

	Utility class for bitwise operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.bitwise;

public final class BitwiseUtil {
    private BitwiseUtil()
    {
    }

    public static int clearBit(int val, int k) //[0, 31]
    {
        return val & ~(1 << k);
    }

    public static long clearBit(long val, int k) //[0, 63]
    {
        return val & ~(1L << k);
    }

    public static int countClearBits(int val)
    {
        return Integer.SIZE - countSetBits(val);
    }

    public static int countClearBits(long val)
    {
        return Long.SIZE - countSetBits(val);
    }

    public static int countClearBits(short val)
    {
        return Short.SIZE - countSetBits(val);
    }

    public static int countClearBits(byte val)
    {
        return Byte.SIZE - countSetBits(val);
    }

    public static int countClearBits(char val)
    {
        return Character.SIZE - countSetBits(val);
    }

    public static int countSetBits(int val)
    {
        var count = 0;

        for (var k = 0; k < Integer.SIZE; ++k)
            if (isSet(val, k))
                ++count;
        return count;
    }

    public static int countSetBits(long val)
    {
        var count = 0;

        for (var k = 0; k < Long.SIZE; ++k)
            if (isSet(val, k))
                ++count;
        return count;
    }

    public static int countSetBits(short val)
    {
        var count = 0;

        for (var k = 0; k < Short.SIZE; ++k)
            if (isSet(val, k))
                ++count;
        return count;
    }

    public static int countSetBits(byte val)
    {
        var count = 0;

        for (var k = 0; k < Byte.SIZE; ++k)
            if (isSet(val, k))
                ++count;
        return count;
    }

    public static int countSetBits(char val)
    {
        var count = 0;

        for (var k = 0; k < Character.SIZE; ++k)
            if (isSet(val, k))
                ++count;
        return count;
    }

    public static int [] indicesOfSetBits(int val)
    {
        var indices = new int[countSetBits(val)];
        var idx = 0;

        for (var k = 0; k < Integer.SIZE; ++k)
            if (isSet(val, k))
                indices[idx++] = k;

        return indices;
    }

    public static int [] indicesOfSetBits(long val)
    {
        var indices = new int[countSetBits(val)];
        var idx = 0;

        for (var k = 0; k < Long.SIZE; ++k)
            if (isSet(val, k))
                indices[idx++] = k;

        return indices;
    }

    public static int [] indicesOfSetBits(short val)
    {
        var indices = new int[countSetBits(val)];
        var idx = 0;

        for (var k = 0; k < Short.SIZE; ++k)
            if (isSet(val, k))
                indices[idx++] = k;

        return indices;
    }

    public static int [] indicesOfSetBits(byte val)
    {
        var indices = new int[countSetBits(val)];
        var idx = 0;

        for (var k = 0; k < Byte.SIZE; ++k)
            if (isSet(val, k))
                indices[idx++] = k;

        return indices;
    }

    public static int [] indicesOfSetBits(char val)
    {
        var indices = new int[countSetBits(val)];
        var idx = 0;

        for (var k = 0; k < Character.SIZE; ++k)
            if (isSet(val, k))
                indices[idx++] = k;

        return indices;
    }

    public static boolean isClear(int val, int k) //[0, 31]
    {
        return !isSet(val, k);
    }

    public static boolean isClear(long val, int k) //[0, 63]
    {
        return !isSet(val, k);
    }

    public static boolean isPowerOfTwo(int val)
    {
        return val != 0 && (val & (val - 1)) == 0;
    }

    public static boolean isPowerOfTwo(long val)
    {
        return val != 0 && (val & (val - 1L)) == 0;
    }

    public static boolean isSet(int val, int k) //[0, 31]
    {
        return (val & 1 << k) != 0;
    }

    public static boolean isSet(long val, int k) //[0, 63]
    {
        return (val & 1L << k) != 0;
    }

    public static int setBit(int val, int k) //[0, 31]
    {
        return val | 1 << k;
    }

    public static long setBit(long val, int k) //[0, 63]
    {
        return val | 1L << k;
    }

    public static String toBitsStr(int val)
    {
        var bits = new char[Integer.SIZE];

        for (var k = Integer.SIZE - 1; k >= 0; --k)
            bits[Integer.SIZE - 1 - k] = isSet(val, k) ? '1' : '0';

        return String.valueOf(bits);
    }

    public static String toBitsStr(long val)
    {
        var bits = new char[Long.SIZE];

        for (var k = Long.SIZE - 1; k >= 0; --k)
            bits[Long.SIZE - 1 - k] = isSet(val, k) ? '1' : '0';

        return String.valueOf(bits);
    }

    public static String toBitsStr(short val)
    {
        var bits = new char[Short.SIZE];

        for (var k = Short.SIZE - 1; k >= 0; --k)
            bits[Short.SIZE - 1 - k] = isSet(val, k) ? '1' : '0';

        return String.valueOf(bits);
    }

    public static String toBitsStr(byte val)
    {
        var bits = new char[Byte.SIZE];

        for (var k = Byte.SIZE - 1; k >= 0; --k)
            bits[Byte.SIZE - 1 - k] = isSet(val, k) ? '1' : '0';

        return String.valueOf(bits);
    }

    public static String toBitsStr(char val)
    {
        var bits = new char[Character.SIZE];

        for (var k = Character.SIZE - 1; k >= 0; --k)
            bits[Character.SIZE - 1 - k] = isSet(val, k) ? '1' : '0';

        return String.valueOf(bits);
    }

    public static int toggleBit(int val, int k) //[0, 31]
    {
        return val ^ 1 << k;
    }

    public static long toggleBit(long val, int k) //[0, 63]
    {
        return val ^ 1L << k;
    }

    public static void writeBits(int val)
    {
        System.out.println(toBitsStr(val));
    }

    public static void writeBits(long val)
    {
        System.out.println(toBitsStr(val));
    }

    public static void writeBits(short val)
    {
        System.out.println(toBitsStr(val));
    }

    public static void writeBits(byte val)
    {
        System.out.println(toBitsStr(val));
    }

    public static void writeBits(char val)
    {
        System.out.println(toBitsStr(val));
    }
}
