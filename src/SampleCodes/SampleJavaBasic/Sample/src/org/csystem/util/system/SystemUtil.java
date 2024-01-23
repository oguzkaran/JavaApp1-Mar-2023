/*----------------------------------------------------------------------
	FILE        : SystemUtil.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 22.11.2023

	Utility class for system information

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.system;

import java.nio.ByteOrder;

public final class SystemUtil {
    private SystemUtil()
    {}

    public static boolean isLittleEndian()
    {
        return ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN;
    }

    public static boolean isBigEndian()
    {
        return !isLittleEndian();
    }

    public static boolean isLittleEndian(ByteOrder byteOrder)
    {
        return byteOrder == ByteOrder.LITTLE_ENDIAN;
    }

    public static boolean isBigEndian(ByteOrder byteOrder)
    {
        return !isLittleEndian(byteOrder);
    }

    public static String endianText()
    {
        return isLittleEndian() ? "LITTLE ENDIAN" : "BIG ENDIAN";
    }

    public static String endianText(ByteOrder byteOrder)
    {
        return isLittleEndian(byteOrder) ? "LITTLE ENDIAN" : "BIG ENDIAN";
    }
}
