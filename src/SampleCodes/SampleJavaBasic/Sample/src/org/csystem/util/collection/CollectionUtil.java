/*----------------------------------------------------------
	FILE			: CollectionUtil.java
	AUTHOR			: Java-Nov-2022 Group
	LAST UPDATE		: 29.07.2023

	Utility class for collection operations

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
------------------------------------------------------------*/
package org.csystem.util.collection;

import org.csystem.util.console.Console;

import java.util.ArrayList;

public final class CollectionUtil {
    private CollectionUtil()
    {
    }

    public static <T> void print(ArrayList<? extends T> list)
    {
        print(list, " ", "\n");
    }

    public static <T> void print(ArrayList<? extends T> list, String sep, String end)
    {
        for (T t : list)
            Console.write("%s%s", t, sep);

        Console.write("%s", end);
    }

    //...
}
