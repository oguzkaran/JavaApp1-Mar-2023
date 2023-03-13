/*----------------------------------------------------------------------
	FILE        : FileUtil.java
	AUTHOR      : Java-May-2021 Group
	LAST UPDATE : 08.01.2022

	Utility class that is used for file operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class FileUtil {
    private FileUtil()
    {
    }

    public static boolean areSame(String path1, String path2) throws IOException
    {
        File file1 = new File(path1);
        File file2 = new File(path2);

        if (file1.length() != file2.length())
            return false;

        try (FileInputStream fis1 = new FileInputStream(file1); FileInputStream fis2 = new FileInputStream(file2)) {
            int b1;
            while ((b1 = fis1.read()) != -1) {
                int b2 = fis2.read();

                if (b1 != b2)
                    return false;
            }
        }

        return true;
    }

    //...
}
