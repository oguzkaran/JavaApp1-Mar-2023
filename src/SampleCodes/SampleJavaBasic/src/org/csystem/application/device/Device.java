package org.csystem.application.device;

public class Device {
    private long m_id;
    private String m_name;
    private String m_host;

    public Device(String name, String host)
    {
        this(0, name, host);
    }

    public Device(long id, String name, String host)
    {
        m_id = id;
        m_name = name;
        m_host = host;
    }

    public long getId()
    {
        return m_id;
    }

    public void setId(long id)
    {
        m_id = id;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public String getHost()
    {
        return m_host;
    }

    public void setHost(String host)
    {
        m_host = host;
    }

    public String toString()
    {
        return String.format("[%s]%s-%s", m_id, m_name, m_host);
    }
}
