package com.bartucankaya.device;

import org.csystem.util.console.Console;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Device implements Closeable {
	private final String m_url;
	private boolean m_open;

	public Device(String url)
	{
		//...
		RandomGenerator randomGenerator = new Random();

		if (randomGenerator.nextBoolean())
			throw new IllegalArgumentException("Url not found");

		m_url = url;
		m_open = true;
		Console.writeLine("Connected to '%s'", m_url);
	}

	public boolean isOpen()
	{
		return m_open;
	}

	public String getUrl()
	{
		return m_url;
	}

	public void doWork() throws IOException
	{
		//...
		RandomGenerator randomGenerator = new Random();

		if (randomGenerator.nextBoolean())
			throw new IllegalStateException(String.format("Illegal state for device at '%s'", m_url));

		if (randomGenerator.nextBoolean())
			throw new IOException("IO problem occurs!...");

		Console.writeLine("Working on device at '%s'", m_url);
	}

	public void close() throws IOException
	{
		Console.writeLine("Device at '%s'%sclosed", m_url, m_open ? " " : " already ");
		m_open = false;
	}
}
