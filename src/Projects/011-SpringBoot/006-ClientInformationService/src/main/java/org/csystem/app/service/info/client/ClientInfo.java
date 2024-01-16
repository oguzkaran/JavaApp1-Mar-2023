package org.csystem.app.service.info.client;

import java.time.LocalDateTime;

public class ClientInfo {
    private final String m_host;
    private final String m_localHost;
    private final int m_port;
    private final int m_localPort;

    private final LocalDateTime m_requestDateTime;

    public ClientInfo(String host, String localHost, int port, int localPort, LocalDateTime requestDateTime)
    {
        m_host = host;
        m_localHost = localHost;
        m_port = port;
        m_localPort = localPort;
        m_requestDateTime = requestDateTime;
    }

    public String getHost()
    {
        return m_host;
    }

    public String getLocalHost()
    {
        return m_localHost;
    }

    public int getPort()
    {
        return m_port;
    }

    public int getLocalPort()
    {
        return m_localPort;
    }

    public LocalDateTime getRequestDateTime()
    {
        return m_requestDateTime;
    }

    //...
}

