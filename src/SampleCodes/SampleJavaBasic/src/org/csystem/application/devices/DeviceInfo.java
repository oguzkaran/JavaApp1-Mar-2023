package org.csystem.application.devices;

public class DeviceInfo {
	private String m_name;
	private String m_host;
	private int m_port;
	private boolean m_open;

	public DeviceInfo(String name, String host, int port)
	{
		this(name, host, port, true);
	}

	public DeviceInfo(String name, String host, int port, boolean open)
	{
		//...
		m_name = name;
		m_host = host;
		m_port = port;
		m_open = open;
	}

	public String getName()
	{
		return m_name;
	}

	public void setName(String name)
	{
		//...
		m_name = name;
	}

	public String getHost()
	{
		return m_host;
	}

	public void setHost(String host)
	{
		//...
		m_host = host;
	}

	public int getPort()
	{
		return m_port;
	}

	public void setPort(int port)
	{
		//...
		m_port = port;
	}

	public boolean isOpen()
	{
		return m_open;
	}

	public void setOpen(boolean open)
	{
		//...
		m_open = open;
	}

	public String toString()
	{
		return String.format("[%s]%s:%d %s", m_name, m_host, m_port, m_open ? "OPEN" : "CLOSED");
	}
}

