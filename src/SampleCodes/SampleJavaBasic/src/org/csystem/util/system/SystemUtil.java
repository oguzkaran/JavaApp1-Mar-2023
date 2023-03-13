/*----------------------------------------------------------------------
	FILE        : SystemUtil.java
	AUTHOR      : Java-May-2021 Group
	LAST UPDATE : 02.01.2022

	Utility class for system operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.system;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class SystemUtil {
    private SystemUtil()
    {
    }

    public static ByteOrder getEndian(ByteBuffer byteBuffer)
    {
        return byteBuffer.order();
    }

    public static void toLittleEndian(ByteBuffer byteBuffer)
    {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    public static String getEndianText()
    {
        return ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN ? "Little Endian" : "Big Endian";
    }
}
