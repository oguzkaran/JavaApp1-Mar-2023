/*----------------------------------------------------------
	FILE			: IOUtil.java
	AUTHOR			: Java-Nov-2022 Group
	LAST UPDATE		: 10.09.2023

	Utility class for general IO operations

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
------------------------------------------------------------*/
package org.csystem.util.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class IOUtil {
    private IOUtil()
    {
    }

    public static void copyAndClose(InputStream inputStream, OutputStream outputStream, int blockSize) throws IOException
    {
        try (inputStream; outputStream) {
            copy(inputStream, outputStream, blockSize);
        }
    }

    public static void copy(InputStream inputStream, OutputStream outputStream, int blockSize) throws IOException
    {
        copy(inputStream, outputStream, blockSize, false);
    }

    public static void copy(InputStream inputStream, OutputStream outputStream, int blockSize, boolean flush) throws IOException
    {
        byte [] data = new byte[blockSize];
        int result;

        while ((result = inputStream.read(data)) > 0)
            outputStream.write(data, 0, result);

        if (flush)
            outputStream.flush();
    }
}
