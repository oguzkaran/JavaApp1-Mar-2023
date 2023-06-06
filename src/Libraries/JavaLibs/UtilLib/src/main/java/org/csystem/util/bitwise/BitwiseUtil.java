/*----------------------------------------------------------------------
	FILE        : BitwiseUtil.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 06.06.2023

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

    public static void writeBits(int val)
    {
        writeBits(Integer.toBinaryString(val), Integer.SIZE);
    }

    public static void writeBits(long val)
    {
        writeBits(Long.toBinaryString(val), Long.SIZE);
    }
}
