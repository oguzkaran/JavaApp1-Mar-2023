/*----------------------------------------------------------------------
	FILE        : IOUtil.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 01.11.2020

	IOUtil class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.io;

import java.io.*;

public final class IOUtil {
	private IOUtil()
	{}

	public static void copy(InputStream src, OutputStream dest, int blockSize, boolean flush) throws IOException
	{
		int read;

		byte[] buf = new byte[blockSize];

		while ((read = src.read(buf)) > 0)
			dest.write(buf, 0, read);

		if (flush)
			dest.flush();
    }
	
	public static void copy(InputStream src, OutputStream dest, int blockSize) throws IOException
	{
		copy(src, dest, blockSize, true);
    }

	@SuppressWarnings("unchecked")
	public static <T> T deserialize(InputStream is)
	{
		try {
			ObjectInputStream ois = new ObjectInputStream(is);

			return (T)ois.readObject();
		}
		catch (Throwable ex) {
			throw new StreamException("IOUtil.deserialize", ex);
		}
	}

	public static <T> void serialize(OutputStream os, T t)
	{
		try {
			ObjectOutputStream oos = new ObjectOutputStream(os);

			oos.writeObject(t);
		}
		catch (Throwable ex) {
			throw new StreamException("IOUtil.serialize", ex);
		}
	}
}
