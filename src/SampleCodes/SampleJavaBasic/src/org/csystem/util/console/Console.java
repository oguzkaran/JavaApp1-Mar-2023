/*----------------------------------------------------------------------
	FILE        : StringUtil.java
	AUTHOR      : Java-May-2021 Group
	LAST UPDATE : 08.01.2022

	Console class that is used for standard input and output operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.console;

import java.util.Scanner;

public final class Console {
    private static final Scanner ms_kb;

    static {
        ms_kb = new Scanner(System.in);
    }
    private Console()
    {}

    public static int readInt()
    {
        return readInt("");
    }

    public static int readInt(String message)
    {
        return readInt(message, "");
    }

    public static int readInt(String message, String errMessage)
    {
        for (;;) {
            try {
                System.out.print(message);
                return Integer.parseInt(ms_kb.nextLine());
            }
            catch (NumberFormatException ignore) {
                System.out.print(errMessage);
            }
        }
    }

    public static int readIntLine(String message)
    {
        return readInt(message + '\n');
    }

    public static int readIntLine(String message, String errMessage)
    {
        return readInt(message + '\n', errMessage + '\n');
    }

    public static double readDouble()
    {
        return readDouble("");
    }

    public static double readDouble(String message)
    {
        return readDouble(message, "");
    }

    public static double readDouble(String message, String errMessage)
    {
        for (;;) {
            try {
                System.out.print(message);
                return Double.parseDouble(ms_kb.nextLine());
            }
            catch (NumberFormatException ignore) {
                System.out.print(errMessage);
            }
        }
    }

    public static double readDoubleLine(String message)
    {
        return readInt(message + '\n');
    }

    public static double readDoubleLine(String message, String errMessage)
    {
        return readInt(message + '\n', errMessage + '\n');
    }

    public static String read(String message)
    {
        System.out.print(message);
        return ms_kb.nextLine();
    }

    public static String readLine()
    {
        return ms_kb.nextLine();
    }

    //...
}
