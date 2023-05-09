/*----------------------------------------------------------------------
	FILE        : CommandLineUtil.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 09.05.2023

	Utility class for command line operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.util.console.commandline;

import com.karandev.util.console.Console;

public final class CommandLineUtil {
    private CommandLineUtil()
    {
    }

    public static void checkLengthEquals(String [] args, int count, String message)
    {
        checkLengthEquals(args.length, count, message, 1);
    }

    public static void checkLengthEquals(String [] args, int count, String message, int status)
    {
        checkLengthEquals(args.length, count, message, status);
    }

    public static void checkLengthEquals(int length, int count, String message)
    {
        checkLengthEquals(length, count, message, 1);
    }

    public static void checkLengthEquals(int length, int count, String message, int status)
    {
        if (length != count) {
            Console.Error.writeLine(message);
            System.exit(status);
        }
    }

    public static void checkLengthGreater(String [] args, int count, String message)
    {
        checkLengthGreater(args.length, count, message, 1);
    }

    public static void checkLengthGreater(String [] args, int count, String message, int status)
    {
        checkLengthGreater(args.length, count, message, status);
    }

    public static void checkLengthGreater(int length, int count, String message)
    {
        checkLengthGreater(length, count, message, 1);
    }

    public static void checkLengthGreater(int length, int count, String message, int status)
    {
        if (length <= count) {
            Console.Error.writeLine(message);
            System.exit(status);
        }
    }

    public static void checkLengthLess(String [] args, int count, String message)
    {
        checkLengthLess(args.length, count, message, 1);
    }

    public static void checkLengthLess(String [] args, int count, String message, int status)
    {
        checkLengthLess(args.length, count, message, status);
    }

    public static void checkLengthLess(int length, int count, String message)
    {
        checkLengthLess(length, count, message, 1);
    }

    public static void checkLengthLess(int length, int count, String message, int status)
    {
        if (length >= count) {
            Console.Error.writeLine(message);
            System.exit(status);
        }
    }

    public static void checkLengthLessOrEquals(String [] args, int count, String message)
    {
        checkLengthLessOrEquals(args.length, count, message, 1);
    }

    public static void checkLengthLessOrEquals(String [] args, int count, String message, int status)
    {
        checkLengthLessOrEquals(args.length, count, message, status);
    }

    public static void checkLengthLessOrEquals(int length, int count, String message)
    {
        checkLengthLessOrEquals(length, count, message, 1);
    }

    public static void checkLengthLessOrEquals(int length, int count, String message, int status)
    {
        if (length > count) {
            Console.Error.writeLine(message);
            System.exit(status);
        }
    }

    public static void checkLengthGreaterOrEquals(String [] args, int count, String message)
    {
        checkLengthGreaterOrEquals(args.length, count, message, 1);
    }

    public static void checkLengthGreaterOrEquals(String [] args, int count, String message, int status)
    {
        checkLengthGreaterOrEquals(args.length, count, message, status);
    }

    public static void checkLengthGreaterOrEquals(int length, int count, String message)
    {
        checkLengthGreaterOrEquals(length, count, message, 1);
    }

    public static void checkLengthGreaterOrEquals(int length, int count, String message, int status)
    {
        if (length < count) {
            Console.Error.writeLine(message);
            System.exit(status);
        }
    }
}
