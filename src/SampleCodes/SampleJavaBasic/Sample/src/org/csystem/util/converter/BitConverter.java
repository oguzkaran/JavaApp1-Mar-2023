/*----------------------------------------------------------------------
	FILE        : BitConverter.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 15.10.2021

	BitConverter class for byte operations with built-in types and
	String class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.converter;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public final class BitConverter {
	private static ByteBuffer allocate(int capacity)
	{
		return ByteBuffer.allocate(capacity);
	}

	private static ByteBuffer wrap(byte [] data, int offset, int length)
	{
		return ByteBuffer.wrap(data, offset, length);
	}

	private static short changeEndian(short value,  ByteOrder byteOrder)
	{
		return allocate(2).putShort(value).order(byteOrder).getShort(0);
	}

	private static int changeEndian(int value, ByteOrder byteOrder)
	{
		return allocate(4).putInt(value).order(byteOrder).getInt(0);
	}

	private static long changeEndian(long value, ByteOrder byteOrder)
	{
		return allocate(8).putLong(value).order(byteOrder).getLong(0);
	}

	private BitConverter()
	{
	}

	public static byte [] getBytes(String str)
	{
		return getBytes(str, StandardCharsets.UTF_8);
	}

	public static byte [] getBytes(String str, Charset charset)
	{
		return str.getBytes(charset);
	}

	public static byte [] getBytes(byte value)
	{
		return new byte [] {value};
	}

	public static byte[] getBytes(short value)
	{
		return allocate(2).putShort(value).array();
	}

	public static byte[] getBytes(int value)
	{
		return allocate(4).putInt(value).array();
	}

	public static byte[] getBytes(long value)
	{
		return allocate(8).putLong(value).array();
	}

	public static byte[] getBytes(char value)
	{
		return allocate(2).putChar(value).array();
	}

	public static byte[] getBytes(double value)
	{
		return allocate(8).putDouble(value).array();
	}

	public static byte[] getBytes(float value)
	{
		return allocate(4).putFloat(value).array();
	}

	public static byte[] getBytes(boolean value)
	{
		return new byte[] {(byte)(value ? 1 : 0)};
	}

	public static byte [] getBytes(byte...bytes)
	{
		ByteBuffer bb = allocate(bytes.length * Byte.BYTES);

		for (byte val : bytes)
			bb.put(val);

		return bb.array();
	}

	public static byte [] getBytes(short...shorts)
	{
		ByteBuffer bb = allocate(shorts.length * Short.BYTES);

		for (short val : shorts)
			bb.putShort(val);

		return bb.array();
	}

	public static byte [] getBytes(int...ints)
	{
		ByteBuffer bb = allocate(ints.length * Integer.BYTES);

		for (int val : ints)
			bb.putInt(val);

		return bb.array();
	}

	public static byte [] getBytes(long...longs)
	{
		ByteBuffer bb = allocate(longs.length * Long.BYTES);

		for (long val : longs)
			bb.putLong(val);

		return bb.array();
	}

	public static byte [] getBytes(char...chars)
	{
		ByteBuffer bb = allocate(chars.length * Character.BYTES);

		for (char val : chars)
			bb.putChar(val);

		return bb.array();
	}

	public static byte [] getBytes(double...doubles)
	{
		ByteBuffer bb = allocate(doubles.length * Double.BYTES);

		for (double val : doubles)
			bb.putDouble(val);

		return bb.array();
	}

	public static byte [] getBytes(float...floats)
	{
		ByteBuffer bb = allocate(floats.length * Float.BYTES);

		for (float val : floats)
			bb.putFloat(val);

		return bb.array();
	}

	public static byte [] getBytes(boolean...booleans)
	{
		byte [] data = new byte[booleans.length];

		for (int i = 0; i < data.length; ++i)
			data[i] = (byte)(booleans[i] ? 1 : 0);

		return data;
	}

	public static String toString(byte [] data)
	{
		return toString(data, StandardCharsets.UTF_8);
	}

	public static String toString(byte [] data, Charset charset)
	{
		return toString(data, 0, data.length, charset);
	}

	public static String toString(byte [] data, int offset, int length)
	{
		return toString(data, offset, length, StandardCharsets.UTF_8);
	}

	public static String toString(byte [] data, int offset, int length, Charset charset)
	{
		return new String(data, offset, length, charset);
	}

	public static byte toByte(byte [] data)
	{
		return toByte(data, 0);
	}

	public static byte toByte(byte [] data, int startIndex)
	{
		return data[startIndex];
	}

	public static short toShort(byte [] data)
	{
		return toShort(data, 0);
	}

	public static short toShort(byte [] data, int startIndex)
	{
		return wrap(data, startIndex, 2).getShort();
	}

	public static int toInt(byte [] data)
	{
		return toInt(data, 0);
	}

	public static int toInt(byte [] data, int startIndex)
	{
		return wrap(data, startIndex, 4).getInt();
	}

	public static long toLong(byte [] data)
	{
		return toLong(data, 0);
	}

	public static long toLong(byte [] data, int startIndex)
	{
		return wrap(data, startIndex, 8).getLong();
	}

	public static char toChar(byte [] data)
	{
		return toChar(data, 0);
	}

	public static char toChar(byte [] data, int startIndex)
	{
		return wrap(data, startIndex, 2).getChar();
	}

	public static double toDouble(byte [] data)
	{
		return toDouble(data, 0);
	}

	public static double toDouble(byte [] data, int startIndex)
	{
		return wrap(data, startIndex, 8).getDouble();
	}

	public static float toFloat(byte [] data)
	{
		return toFloat(data, 0);
	}

	public static float toFloat(byte [] data, int startIndex)
	{
		return wrap(data, startIndex, 4).getFloat();
	}

	public static boolean toBoolean(byte [] data)
	{
		return toBoolean(data, 0);
	}

	public static boolean toBoolean(byte [] data, int startIndex)
	{
		return data[startIndex] != 0;
	}

	public static byte [] toByteArray(byte [] data, int startIndex, int count)
	{
		byte [] result = new byte[count];

		for (int i = 0, idx = startIndex; i < count; ++i, idx += Byte.BYTES)
			result[i] = toByte(data, idx);

		return result;
	}

	public static short [] toShortArray(byte [] data, int count)
	{
		return toShortArray(data, 0, count);
	}

	public static short [] toShortArray(byte [] data, int startIndex, int count)
	{
		short [] result = new short[count];

		for (int i = 0, idx = startIndex; i < count; ++i, idx += Short.BYTES)
			result[i] = toShort(data, idx);

		return result;
	}

	public static int [] toIntArray(byte [] data, int count)
	{
		return toIntArray(data, 0, count);
	}

	public static int [] toIntArray(byte [] data, int startIndex, int count)
	{
		int [] result = new int[count];

		for (int i = 0, idx = startIndex; i < count; ++i, idx += Integer.BYTES)
			result[i] = toInt(data, idx);

		return result;
	}

	public static long [] toLongArray(byte [] data, int count)
	{
		return toLongArray(data, 0, count);
	}

	public static long [] toLongArray(byte [] data, int startIndex, int count)
	{
		long [] result = new long[count];

		for (int i = 0, idx = startIndex; i < count; ++i, idx += Long.BYTES)
			result[i] = toLong(data, idx);

		return result;
	}

	public static char [] toCharArray(byte [] data, int count)
	{
		return toCharArray(data, 0, count);
	}

	public static char [] toCharArray(byte [] data, int startIndex, int count)
	{
		char [] result = new char[count];

		for (int i = 0, idx = startIndex; i < count; ++i, idx += Character.BYTES)
			result[i] = toChar(data, idx);

		return result;
	}

	public static double [] toDoubleArray(byte [] data, int count)
	{
		return toDoubleArray(data, 0, count);
	}

	public static double [] toDoubleArray(byte [] data, int startIndex, int count)
	{
		double [] result = new double[count];

		for (int i = 0, idx = startIndex; i < count; ++i, idx += Double.BYTES)
			result[i] = toDouble(data, idx);

		return result;
	}

	public static float [] toFloatArray(byte [] data, int count)
	{
		return toFloatArray(data, 0, count);
	}

	public static float [] toFloatArray(byte [] data, int startIndex, int count)
	{
		float [] result = new float[count];

		for (int i = 0, idx = startIndex; i < count; ++i, idx += Float.BYTES)
			result[i] = toFloat(data, idx);

		return result;
	}

	public static boolean [] toBooleanArray(byte [] data, int count)
	{
		return toBooleanArray(data, 0, count);
	}

	public static boolean [] toBooleanArray(byte [] data, int startIndex, int count)
	{
		boolean [] result = new boolean[count];

		for (int i = 0, idx = startIndex; i < count; ++i, ++idx)
			result[i] = toBoolean(data, idx);

		return result;
	}

	public static short toLittleEndian(short value)
	{
		return changeEndian(value, ByteOrder.LITTLE_ENDIAN);
	}

	public static short toBigEndian(short value)
	{
		return changeEndian(value, ByteOrder.BIG_ENDIAN);
	}

	public static int toLittleEndian(int value)
	{
		return changeEndian(value, ByteOrder.LITTLE_ENDIAN);
	}

	public static int toBigEndian(int value)
	{
		return changeEndian(value, ByteOrder.BIG_ENDIAN);
	}

	public static long toLittleEndian(long value)
	{
		return changeEndian(value, ByteOrder.LITTLE_ENDIAN);
	}

	public static long toBigEndian(long value)
	{
		return changeEndian(value, ByteOrder.BIG_ENDIAN);
	}
}
