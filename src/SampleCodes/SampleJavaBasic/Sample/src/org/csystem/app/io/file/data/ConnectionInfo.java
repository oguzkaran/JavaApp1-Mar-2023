package org.csystem.app.io.file.data;

public class ConnectionInfo {
    private int m_portNum;
    private String m_host;

    public ConnectionInfo(int portNum, String host)
    {
        m_portNum = portNum;
        m_host = host;
    }

    public int getPortNum()
    {
        return m_portNum;
    }

    public void setPortNum(int portNum)
    {
        m_portNum = portNum;
    }

    public String getHost()
    {
        return m_host;
    }

    public void setHost(String host)
    {
        m_host = host;
    }

    //...
}
