/*----------------------------------------------------------
	FILE			: Console.java
	AUTHOR			: Java-Nov-2022 Group
	LAST UPDATE		: 01.09.2023

	Utility class for standard input and standard output operations

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
------------------------------------------------------------*/
package org.csystem.util.console;

import java.util.Scanner;

public final class Console {
    private static final Scanner KB = new Scanner(System.in);

    private Console()
    {
    }

    public static int readInt()
    {
        return readInt("");
    }

    public static int readInt(String message)
    {
        return readInt(message, "");
    }

    public static int readInt(String message, String errorMessage)
    {
        while (true) {
            try {
                System.out.print(message);

                return Integer.parseInt(KB.nextLine());
            }
            catch (NumberFormatException ignore) {
                System.out.print(errorMessage);
            }
        }
    }

    public static double readDouble()
    {
        return readDouble("");
    }

    public static double readDouble(String message)
    {
        return readDouble(message, "");
    }

    public static double readDouble(String message, String errorMessage)
    {
        while (true) {
            try {
                System.out.print(message);

                return Double.parseDouble(KB.nextLine());
            }
            catch (NumberFormatException ignore) {
                System.out.print(errorMessage);
            }
        }
    }

    public static long readLong()
    {
        return readLong("");
    }

    public static long readLong(String message)
    {
        return readLong(message, "");
    }

    public static long readLong(String message, String errorMessage)
    {
        while (true) {
            try {
                System.out.print(message);

                return Long.parseLong(KB.nextLine());
            }
            catch (NumberFormatException ignore) {
                System.out.print(errorMessage);
            }
        }
    }

    public static String readString()
    {
        return readString("");
    }

    public static String readString(String message)
    {
        write(message);
        return KB.nextLine();
    }

    public static char readChar()
    {
        return readChar("");
    }

    public static char readChar(String message)
    {
        return readChar(message, "");
    }

    public static char readChar(String message, String errorMessage)
    {
        String str;

        while (!(str = readString(message)).isEmpty() && str.length() != 1)
            write(errorMessage);

        return str.isEmpty() ? '\n' : str.charAt(0);
    }

    public static void write(Object arg)
    {
        write("%s", arg);
    }

    public static void write(String format, Object...args)
    {
        System.out.printf(format, args);
    }
    public static void writeLine(Object arg)
    {
        writeLine("%s", arg);
    }

    public static void writeLine()
    {
        System.out.println();
    }



    public static void writeLine(String format, Object...args)
    {
        write(format + "\n", args);
    }

    public static void writeErrLine(String format, Object...args)
    {
        System.err.printf(format + "\n", args);
    }
    //...
}
