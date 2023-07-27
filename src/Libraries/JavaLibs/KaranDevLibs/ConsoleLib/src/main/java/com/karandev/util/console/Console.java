/*----------------------------------------------------------------------
	FILE        : Console.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 12.04.2023

	Utility class for standard input, standard output and standard error

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.util.console;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public final class Console {
    private static final Scanner ms_kb;

    static {
        ms_kb = new Scanner(System.in);
    }

    private Console() {}

    public static final class Error {
        private Error() {}

        public static void write(boolean b)
        {
            write("%b", b);
        }

        public static void write(int val)
        {
            write("%d", val);
        }

        public static void write(int val, int radix)
        {
            write("%s", Integer.toString(val, radix));
        }

        public static void write(long val)
        {
            write("%d", val);
        }

        public static void write(long val, int radix)
        {
            write("%s", Long.toString(val, radix));
        }

        public static void write(char ch)
        {
            write("%c", ch);
        }

        public static void write(double val)
        {
            write("%f", val);
        }

        public static void write(float val)
        {
            write("%d", val);
        }

        public static void write(String s)
        {
            write("%s", s);
        }

        public static void write(char [] c)
        {
            for (char ch : c)
                write(ch);
        }

        public static void write(Object obj)
        {
            write("%s", obj);
        }

        public static void write(String fmt, Object...objects)
        {
            System.err.printf(fmt, objects);
        }

        public static void writeLine()
        {
            write("\n");
        }

        public static void writeLine(boolean b)
        {
            writeLine("%b", b);
        }

        public static void writeLine(int val)
        {
            writeLine("%d", val);
        }

        public static void writeLine(long val)
        {
            writeLine("%d", val);
        }

        public static void writeLine(char ch)
        {
            writeLine("%c", ch);
        }

        public static void writeLine(double val)
        {
            writeLine("%f", val);
        }

        public static void writeLine(float val)
        {
            writeLine("%d", val);
        }

        public static void writeLine(String s)
        {
            writeLine("%s", s);
        }

        public static void writeLine(char [] c)
        {
            for (char ch : c)
                writeLine(ch);
        }

        public static void writeLine(Object obj)
        {
            writeLine("%s", obj);
        }

        public static void writeLine(String fmt, Object...objects)
        {
            write(fmt + "\n", objects);
        }

        public static void writeBits(char val)
        {
            for (int k = 15; k >= 0; --k)
                write((val & 1 << k) != 0 ? 1 : 0);

            writeLine();
        }

        public static void writeBits(byte val)
        {
            for (int k = 7; k >= 0; --k)
                write((val & 1 << k) != 0 ? 1 : 0);

            writeLine();
        }

        public static void writeBits(short val)
        {
            for (int k = 15; k >= 0; --k)
                write((val & 1 << k) != 0 ? 1 : 0);

            writeLine();
        }

        public static void writeBits(int val)
        {
            for (int k = 31; k >= 0; --k)
                write((val & 1 << k) != 0 ? 1 : 0);

            writeLine();
        }

        public static void writeBits(long val)
        {
            for (int k = 63; k >= 0; --k)
                write((val & 1L << k) != 0 ? 1 : 0);

            writeLine();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //byte
    public static byte readByte()
    {
        return readByte("");
    }

    public static byte readByte(String msg)
    {
        return readByte(msg, "");
    }

    public static byte readByte(String msg, String errMsg)
    {
        return readByte(msg, 10, errMsg);
    }

    public static byte readByteLine(String msg)
    {
        return readByte(msg + "\n", "");
    }

    public static byte readByteLine(String msg, String errMsg)
    {
        return readByte(msg + "\n", errMsg + "\n");
    }

    ///////////////////////////////////////////////////////
    public static byte readByte(int radix)
    {
        return readByte("", radix);
    }

    public static byte readByte(String msg, int radix)
    {
        return readByte(msg, radix, "");
    }

    public static byte readByte(String msg, int radix, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return Byte.parseByte(ms_kb.nextLine(), radix);
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    public static byte readByteLine(String msg, int radix)
    {
        return readByte(msg + "\n", radix, "");
    }

    public static byte readByteLine(String msg, int radix, String errMsg)
    {
        return readByte(msg + "\n", radix, errMsg + "\n");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //short
    public static short readShort()
    {
        return readShort("");
    }

    public static short readShort(String msg)
    {
        return readShort(msg, "");
    }

    public static short readShort(String msg, String errMsg)
    {
        return readShort(msg, 10, errMsg);
    }

    public static short readShortLine(String msg)
    {
        return readShort(msg + "\n", "");
    }

    public static short readShortLine(String msg, String errMsg)
    {
        return readShort(msg + "\n", errMsg + "\n");
    }

    ///////////////////////////////////////////////////////
    public static short readShort(int radix)
    {
        return readShort("", radix);
    }

    public static short readShort(String msg, int radix)
    {
        return readShort(msg, radix, "");
    }

    public static short readShort(String msg, int radix, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return Short.parseShort(ms_kb.nextLine(), radix);
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    public static short readShortLine(String msg, int radix)
    {
        return readShort(msg + "\n", radix, "");
    }

    public static short readShortLine(String msg, int radix, String errMsg)
    {
        return readShort(msg + "\n", radix, errMsg + "\n");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //int
    public static int readInt()
    {
        return readInt("");
    }

    public static int readInt(String msg)
    {
        return readInt(msg, "");
    }

    public static int readInt(String msg, String errMsg)
    {
        return readInt(msg, 10, errMsg);
    }

    public static int readIntLine(String msg)
    {
        return readInt(msg + "\n", "");
    }

    public static int readIntLine(String msg, String errMsg)
    {
        return readInt(msg + "\n", errMsg + "\n");
    }

    ///////////////////////////////////////////////////////
    public static int readInt(int radix)
    {
        return readInt("", radix);
    }

    public static int readInt(String msg, int radix)
    {
        return readInt(msg, radix, "");
    }

    public static int readInt(String msg, int radix, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return Integer.parseInt(ms_kb.nextLine(), radix);
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    public static int readIntLine(String msg, int radix)
    {
        return readInt(msg + "\n", radix, "");
    }

    public static int readIntLine(String msg, int radix, String errMsg)
    {
        return readInt(msg + "\n", radix, errMsg + "\n");
    }

    ////////////////////////////////////////////

    public static int readUInt()
    {
        return readUInt("");
    }

    public static int readUInt(String msg)
    {
        return readUInt(msg, "");
    }

    public static int readUInt(String msg, String errMsg)
    {
        return readUInt(msg, 10, errMsg);
    }

    public static int readUIntLine(String msg)
    {
        return readUInt(msg + "\n", "");
    }

    public static int readUIntLine(String msg, String errMsg)
    {
        return readUInt(msg + "\n", errMsg + "\n");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static int readUInt(int radix)
    {
        return readUInt("", radix);
    }

    public static int readUInt(String msg, int radix)
    {
        return readUInt(msg, radix, "");
    }

    public static int readUInt(String msg, int radix, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return Integer.parseUnsignedInt(ms_kb.nextLine(), radix);
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    public static int readUIntLine(String msg, int radix)
    {
        return readUInt(msg + "\n", radix, "");
    }

    public static int readUIntLine(String msg, int radix, String errMsg)
    {
        return readUInt(msg + "\n", radix, errMsg + "\n");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //long

    public static long readLong()
    {
        return readLong("");
    }


    public static long readLong(String msg)
    {
        return readLong(msg, "");
    }

    public static long readLong(String msg, String errMsg)
    {
        return readLong(msg, 10, errMsg);
    }

    public static long readLongLine(String msg)
    {
        return readLong(msg + "\n", "");
    }

    public static long readLongLine(String msg, String errMsg)
    {
        return readLong(msg + "\n", errMsg + "\n");
    }

    ///////////////////////////////////////////////////////

    public static long readLong(int radix)
    {
        return readLong("", radix);
    }

    public static long readLong(String msg, int radix)
    {
        return readLong(msg, radix, "");
    }

    public static long readLong(String msg, int radix, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return Long.parseLong(ms_kb.nextLine(), radix);
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    public static long readLongLine(String msg, int radix)
    {
        return readLong(msg + "\n", radix, "");
    }

    public static long readLongLine(String msg, int radix, String errMsg)
    {
        return readLong(msg + "\n", radix, errMsg + "\n");
    }

    ////////////////////////////////////////////////////////////////////////////////////

    public static long readULong()
    {
        return readULong("");
    }

    public static long readULong(String msg)
    {
        return readULong(msg, "");
    }

    public static long readULong(String msg, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return Long.parseUnsignedLong(ms_kb.nextLine());
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    public static long readULongLine(String msg)
    {
        return readULong(msg + "\n", "");
    }

    public static long readULongLine(String msg, String errMsg)
    {
        return readULong(msg + "\n", errMsg + "\n");
    }

    //double
    public static double readDouble()
    {
        return readDouble("");
    }

    public static double readDouble(String msg)
    {
        return readDouble(msg, "");
    }

    public static double readDouble(String msg, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return Double.parseDouble(ms_kb.nextLine());
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    public static double readDoubleLine(String msg)
    {
        return readDouble(msg + "\n", "");
    }

    public static double readDoubleLine(String msg, String errMsg)
    {
        return readDouble(msg + "\n", errMsg + "\n");
    }

    //float
    public static float readFloat()
    {
        return readFloat("");
    }

    public static float readFloat(String msg)
    {
        return readFloat(msg, "");
    }

    public static float readFloat(String msg, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return Float.parseFloat(ms_kb.nextLine());
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    public static float readFloatLine(String msg)
    {
        return readFloat(msg + "\n", "");
    }

    public static float readFloatLine(String msg, String errMsg)
    {
        return readFloat(msg + "\n", errMsg + "\n");
    }

    ////////////////////readChar////////////////////////////////////////////////////

    public static char readChar()
    {
        return readChar("");
    }

    public static char readChar(String msg)
    {
        return readChar(msg, "");
    }

    public static char readChar(String msg, String errMsg)
    {
        for (;;) {
            write(msg);
            var str = ms_kb.nextLine();

            if (str.length() == 1)
                return str.charAt(0);
            write(errMsg);
        }
    }

    public static char readCharLine(String msg)
    {
        return readChar(msg + "\n", "");
    }

    public static char readCharLine(String msg, String errMsg)
    {
        return readChar(msg + "\n", errMsg + "\n");
    }

    //String
    public static String read(String msg)
    {
        System.out.print(msg);

        return ms_kb.nextLine();
    }

    public static String readLine()
    {
        return read("");
    }

    public static String readLine(String msg)
    {
        return read(msg + "\n");
    }

    //BigDecimal
    public static BigDecimal readBigDecimal()
    {
        return readBigDecimal("");
    }

    public static BigDecimal readBigDecimal(String msg)
    {
        return readBigDecimal(msg, "");
    }

    public static BigDecimal readBigDecimal(String msg, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return new BigDecimal(ms_kb.nextLine());
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    public static BigDecimal readBigDecimalLine(String msg)
    {
        return readBigDecimal(msg + "\n", "");
    }

    public static BigDecimal readBigDecimalLine(String msg, String errMsg)
    {
        return readBigDecimal(msg + "\n", errMsg + "\n");
    }

    //BigInteger
    public static BigInteger readBigInteger()
    {
        return readBigInteger("");
    }

    public static BigInteger readBigInteger(String msg)
    {
        return readBigInteger(msg, "");
    }

    public static BigInteger readBigInteger(String msg, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return new BigInteger(ms_kb.nextLine());
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    public static BigInteger readBigIntegerLine(String msg)
    {
        return readBigInteger(msg + "\n", "");
    }

    public static BigInteger readBigIntegerLine(String msg, String errMsg)
    {
        return readBigInteger(msg + "\n", errMsg + "\n");
    }

    public static BigInteger readBigInteger(int radix)
    {
        return readBigInteger("", radix);
    }

    public static BigInteger readBigInteger(String msg, int radix)
    {
        return readBigInteger(msg, "", radix);
    }

    public static BigInteger readBigInteger(String msg, String errMsg, int radix)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return new BigInteger(ms_kb.nextLine(), radix);
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    public static BigInteger readBigIntegerLine(String msg, int radix)
    {
        return readBigInteger(msg + "\n", "", radix);
    }

    public static BigInteger readBigIntegerLine(String msg, String errMsg, int radix)
    {
        return readBigInteger(msg + "\n", errMsg + "\n", radix);
    }

    //write methods
    public static void write(boolean b)
    {
        write("%b", b);
    }

    public static void write(int val)
    {
        write("%d", val);
    }

    public static void write(int val, int radix)
    {
        write("%s", Integer.toString(val, radix));
    }

    public static void write(long val)
    {
        write("%d", val);
    }

    public static void write(long val, int radix)
    {
        write("%s", Long.toString(val, radix));
    }

    public static void write(char ch)
    {
        write("%c", ch);
    }

    public static void write(int n, char ch)
    {
        for (int i = 0; i < n; ++i)
            System.out.print(ch);
    }

    public static void write(double val)
    {
        write("%f", val);
    }

    public static void write(float val)
    {
        write("%d", val);
    }

    public static void write(String s)
    {
        write("%s", s);
    }

    public static void write(char [] c)
    {
        for (char ch : c)
            write(ch);
    }

    public static void write(Object obj)
    {
        write("%s", obj);
    }

    public static void write(String fmt, Object...objects)
    {
        System.out.printf(fmt, objects);
    }

    public static void writeLine()
    {
        write("\n");
    }

    public static void writeLine(boolean b)
    {
        writeLine("%b", b);
    }

    public static void writeLine(int val)
    {
        writeLine("%d", val);
    }

    public static void writeLine(int val, int radix)
    {
        writeLine("%s", Integer.toString(val, radix));
    }

    public static void writeLine(long val)
    {
        writeLine("%d", val);
    }

    public static void writeLine(long val, int radix)
    {
        writeLine("%s", Long.toString(val, radix));
    }

    public static void writeLine(char ch)
    {
        writeLine("%c", ch);
    }

    public static void writeLine(int n, char ch)
    {
        write(n, ch);
        System.out.println();
    }

    public static void writeLine(double val)
    {
        writeLine("%f", val);
    }

    public static void writeLine(float val)
    {
        writeLine("%d", val);
    }

    public static void writeLine(String s)
    {
        writeLine("%s", s);
    }

    public static void writeLine(char [] c)
    {
        for (char ch : c)
            writeLine(ch);
    }

    public static void writeLine(Object obj)
    {
        writeLine("%s", obj);
    }

    public static void writeLine(String fmt, Object...objects)
    {
        write(fmt + "\n", objects);
    }

    public static void writeBits(char val)
    {
        for (int k = 15; k >= 0; --k)
            write((val & 1 << k) != 0 ? 1 : 0);

        writeLine();
    }

    public static void writeBits(byte val)
    {
        for (int k = 7; k >= 0; --k)
            write((val & 1 << k) != 0 ? 1 : 0);

        writeLine();
    }

    public static void writeBits(short val)
    {
        for (int k = 15; k >= 0; --k)
            write((val & 1 << k) != 0 ? 1 : 0);

        writeLine();
    }

    public static void writeBits(int val)
    {
        for (int k = 31; k >= 0; --k)
            write((val & 1 << k) != 0 ? 1 : 0);

        writeLine();
    }

    public static void writeBits(long val)
    {
        for (int k = 63; k >= 0; --k)
            write((val & 1L << k) != 0 ? 1 : 0);

        writeLine();
    }
}
