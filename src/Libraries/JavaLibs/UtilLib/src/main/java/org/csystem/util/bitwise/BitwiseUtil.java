/*----------------------------------------------------------------------
	FILE        : BitwiseUtil.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 08.06.2023

	Utility class for bitwise operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.bitwise;

public final class BitwiseUtil {
    private BitwiseUtil()
    {
    }

    private static void writeBits(String bitStr, int bitsLength)
    {
        var zeroLength = bitsLength - bitStr.length();

        System.out.println(zeroLength != 0 ? String.format("%0" + zeroLength + "d%s", 0, bitStr) : bitStr);
    }

    public static int setBit(int val, int k) //[0, 31]
    {
        return val | 1 << k;
    }

    public static long setBit(long val, int k) //[0, 63]
    {
        return val | 1L << k;
    }

    public static void writeBits(int val)
    {
        writeBits(Integer.toBinaryString(val), Integer.SIZE);
    }

    public static void writeBits(long val)
    {
        writeBits(Long.toBinaryString(val), Long.SIZE);
    }
}
