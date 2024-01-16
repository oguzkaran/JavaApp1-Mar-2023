package org.csystem.app.service.info.client;

import java.time.LocalDateTime;

public class ClientInfo {
    private final String m_username;
    private final String m_host;
    private final int m_port;
    private final int m_localPort;

    private final LocalDateTime m_requestDateTime;


    public ClientInfo(String username, String host, int port, int localPort, LocalDateTime requestDateTime)
    {
        m_username = username;
        m_host = host;
        m_port = port;
        m_localPort = localPort;
        m_requestDateTime = requestDateTime;
    }

    public String getUsername()
    {
        return m_username;
    }

    public String getHost()
    {
        return m_host;
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

