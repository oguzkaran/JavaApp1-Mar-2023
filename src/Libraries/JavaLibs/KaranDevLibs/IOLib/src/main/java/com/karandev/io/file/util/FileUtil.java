/*----------------------------------------------------------------------
	FILE        : FileUtil.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 03.11.2021

	Utility class for files

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.io.file.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.function.Consumer;

public final class FileUtil {
    private FileUtil()
    {
    }

    public static boolean areSame(String first, String second) throws IOException
    {
        return areSame(new File(first), new File(second));
    }

    public static void walkDir(File path, Consumer<File> consumer)
    {
        for (File file : Objects.requireNonNull(path.listFiles())) {
            if (file.isDirectory())
                walkDir(file, consumer);

            consumer.accept(file);
        }
    }

    public static void walkDir(String path, Consumer<File> consumer)
    {
        walkDir(new File(path), consumer);
    }


    public static boolean areSame(File first, File second) throws IOException
    {
        if (first.length() != second.length())
            return false;

        try (var fosFirst = new FileInputStream(first); var fosSecond = new FileInputStream(second)) {
            int ch1;
            int ch2;

            while ((ch1 = fosFirst.read()) != -1 && (ch2 = fosSecond.read()) != -1 && ch1 == ch2)
                ;

            return ch1 == -1;
        }
    }

    //...
}
