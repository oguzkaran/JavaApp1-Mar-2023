/*----------------------------------------------------------
	FILE			: FileUtil.java
	AUTHOR			: Java-Nov-2022 Group
	LAST UPDATE		: 06.01.2024

	Utility class for general IO operations

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
------------------------------------------------------------*/
package org.csystem.util.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class FileUtil {
    private FileUtil()
    {
    }

    public static boolean areSame(File file1, File file2) throws IOException
    {
        if (file1.length() != file2.length())
            return false;

        try (FileInputStream fis1 = new FileInputStream(file1); FileInputStream fis2 = new FileInputStream(file2)) {
            int b;

            while ((b = fis1.read()) != -1)
                if (b != fis2.read())
                    return false;
        }

        return true;
    }

    public static boolean areSame(String file1, String file2) throws IOException
    {
        return areSame(new File(file1), new File(file2));
    }
}
