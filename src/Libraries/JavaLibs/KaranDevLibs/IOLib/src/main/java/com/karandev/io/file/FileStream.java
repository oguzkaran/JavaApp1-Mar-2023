/*----------------------------------------------------------------------
	FILE        : FileStream.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 30.09.2020

	FileStream class for general file operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.io.file;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Arrays;

public final class FileStream implements Closeable, DataOutput, DataInput {
	private final RandomAccessFile m_raf;
	private final BufferedReader m_br;
	private final BufferedWriter m_bw;

	private int findNullCharacter(byte [] data)
	{
		for (int i = 0; i < data.length; ++i)
			if (data[i] == 0)
				return i;

		return -1;
	}

	public static String readAllText(File file, Charset charset) throws IOException
	{
		return readAllText(file.getAbsolutePath(), charset);
	}

	public static String readAllText(File file) throws IOException
	{
		return readAllText(file, Charset.defaultCharset());
	}

	public static String readAllText(String filePath, Charset charset) throws IOException
	{
		return readAllText(new FileInputStream(filePath), charset);
	}

	public static String readAllText(String filePath) throws IOException
	{
		return readAllText(filePath, Charset.defaultCharset());
	}

	public static String readAllText(InputStream is) throws IOException
	{
		return readAllText(is, Charset.defaultCharset());
	}

	public static String readAllText(InputStream is, Charset charset) throws IOException
	{
		byte [] data = new byte[1024];
		StringBuilder sb = new StringBuilder();
		int n;

		while ((n = is.read(data)) > 0)
			sb.append(new String(data, 0, n, charset));

		return sb.toString();
	}

	public FileStream(String filePath) throws IOException
	{
		this(filePath, FileAccess.READWRITE);
	}

	public FileStream(File file) throws IOException
	{
		this(file.getAbsolutePath());
	}
	
	public FileStream(String filePath, boolean append) throws IOException
	{
		this(filePath, FileAccess.READWRITE);
		
		if (append)
			m_raf.seek(m_raf.length());
	}
	
	public FileStream(File file, boolean append) throws IOException
	{
		this(file.getAbsolutePath(), append);
	}
	
	public FileStream(String filePath, FileAccess fileAccess) throws IOException
	{
		if (filePath == null || fileAccess == null)
			throw new IllegalArgumentException("null value is not accepted");
		
		m_raf = new RandomAccessFile(filePath, fileAccess == FileAccess.READ ? "r" : "rw");
		m_br = new BufferedReader(new FileReader(m_raf.getFD()));
		m_bw = new BufferedWriter(new FileWriter(m_raf.getFD()));
	}
	
	public FileStream(File file, FileAccess fileAccess) throws IOException
	{
		this(file.getAbsolutePath(), fileAccess);
	}

	public FileChannel getChannel()
	{
		return m_raf.getChannel();
	}

	public FileDescriptor getFD() throws IOException
	{
		return m_raf.getFD();
	}

	public long getFilePointer() throws IOException
	{
		return m_raf.getFilePointer();
	}

	public InputStream getInputStream() throws IOException
	{
		return  new FileInputStream(m_raf.getFD());
	}

	public OutputStream getOutputStream() throws IOException
	{
		return new FileOutputStream(m_raf.getFD());
	}

	public int hashCode()
	{
		return m_raf.hashCode();
	}

	public long length() throws IOException
	{
		return m_raf.length();
	}

	public int read() throws IOException
	{
		return m_raf.read();
	}

	public int read(byte[] b, int off, int len) throws IOException
	{
		return m_raf.read(b, off, len);
	}

	public int read(byte[] b) throws IOException
	{
		return m_raf.read(b);
	}

	public boolean readBoolean() throws IOException
	{
		return m_raf.readBoolean();
	}

	public byte readByte() throws IOException
	{
		return m_raf.readByte();
	}

	public char readChar() throws IOException
	{
		return m_raf.readChar();
	}

	public double readDouble() throws IOException
	{
		return m_raf.readDouble();
	}

	public float readFloat() throws IOException
	{
		return m_raf.readFloat();
	}

	public void readFully(byte[] b, int off, int len) throws IOException
	{
		m_raf.readFully(b, off, len);
	}

	public void readFully(byte[] b) throws IOException
	{
		m_raf.readFully(b);
	}

	public int readInt() throws IOException
	{
		return m_raf.readInt();
	}

	public String readLine() throws IOException
	{
		return m_br.readLine();
	}

	public long readLong() throws IOException
	{
		return m_raf.readLong();
	}
	
	@SuppressWarnings("resource")
	public Object readObject() throws IOException, ClassNotFoundException
	{		
		return new ObjectInputStream(new FileInputStream(m_raf.getFD())).readObject();
	}

	public short readShort() throws IOException
	{
		return m_raf.readShort();
	}

	public String readUTF() throws IOException
	{
		return m_raf.readUTF();
	}

	public String readFixedUTF(int size) throws IOException
	{
		byte [] data = new byte[size];

		if (read(data) < size)
			throw new IOException();

		int index = findNullCharacter(data);

		return index == -1 ? "" : new String(data, 0, index);
	}

	public int readUnsignedByte() throws IOException
	{
		return m_raf.readUnsignedByte();
	}

	public int readUnsignedShort() throws IOException
	{
		return m_raf.readUnsignedShort();
	}

	public void seek(long pos) throws IOException
	{
		m_raf.seek(pos);
	}

	public void seekEnd() throws IOException
	{
		seek(length());
	}

	public void seekSet() throws IOException
	{
		seek(0);
	}
	public void setLength(long newLength) throws IOException
	{
		m_raf.setLength(newLength);
	}

	public int skipBytes(int n) throws IOException
	{
		return m_raf.skipBytes(n);
	}

	public void newLine() throws IOException
	{
		m_bw.newLine();
	}

	public void write(byte[] b, int off, int len) throws IOException
	{
		m_raf.write(b, off, len);
	}

	public void write(byte[] b) throws IOException
	{
		m_raf.write(b);
	}

	public void write(int b) throws IOException
	{
		m_raf.write(b);
	}
	
	public void write(String s) throws IOException
	{		
		m_bw.write(s);
		m_bw.flush();		
	}

	public void writeBoolean(boolean v) throws IOException
	{
		m_raf.writeBoolean(v);
	}

	public void writeByte(int v) throws IOException
	{
		m_raf.writeByte(v);
	}

	public void writeBytes(String s) throws IOException
	{
		m_raf.writeBytes(s);
	}

	public void writeChar(int v) throws IOException
	{
		m_raf.writeChar(v);
	}

	public void writeChars(String s) throws IOException
	{
		m_raf.writeChars(s);
	}

	public void writeDouble(double v) throws IOException
	{
		m_raf.writeDouble(v);
	}

	public void writeFloat(float v) throws IOException
	{
		m_raf.writeFloat(v);
	}

	public void writeInt(int v) throws IOException
	{
		m_raf.writeInt(v);
	}
	
	public void writeLine(String s) throws IOException	
	{		
		m_bw.write(s);
		m_bw.newLine();
		m_bw.flush();
	}

	public void writeLong(long v) throws IOException
	{
		m_raf.writeLong(v);
	}
	
	@SuppressWarnings("resource")
	public void writeObject(Object o) throws IOException
	{		
		new ObjectOutputStream(new FileOutputStream(m_raf.getFD())).writeObject(o);
	}

	public void writeShort(int v) throws IOException
	{
		m_raf.writeShort(v);
	}

	public void writeUTF(String str) throws IOException
	{
		m_raf.writeUTF(str);
	}

	public void writeFixedUTF(String str, int size) throws IOException
	{
		if (str.length() > size)
			throw new IOException();

		write(Arrays.copyOf(str.getBytes(), size));
	}

	@Override
	public void close() throws IOException
	{
		m_raf.close();		
	}

	@Override
	public String toString()
	{
		return m_raf.toString();
	}
}
