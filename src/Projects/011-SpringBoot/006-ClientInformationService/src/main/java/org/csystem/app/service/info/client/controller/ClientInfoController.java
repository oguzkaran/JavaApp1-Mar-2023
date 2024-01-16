package org.csystem.app.service.info.client.controller;

import com.karandev.io.util.console.Console;
import jakarta.servlet.http.HttpServletRequest;
import org.csystem.app.service.info.client.ClientInfo;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/client")
@Scope("request")
public class ClientInfoController {
    private final HttpServletRequest m_httpServletRequest;
    private final LocalDateTime m_requestDateTime;

    public ClientInfoController(HttpServletRequest httpServletRequest, LocalDateTime requestDateTime)
    {
        m_httpServletRequest = httpServletRequest;
        m_requestDateTime = requestDateTime;
    }

    //@RequestMapping(value = "info", method = RequestMethod.GET)
    @GetMapping("info")
    public ClientInfo getClientInfo()
    {
        var host = m_httpServletRequest.getRemoteHost();
        var remotePort = m_httpServletRequest.getRemotePort();
        var localPort = m_httpServletRequest.getLocalPort();

        Console.writeLine("Host:%s, RemotePort:%d, LocalPort:%s", host, remotePort, localPort);

        return new ClientInfo("Unnamed", host, remotePort, localPort, m_requestDateTime);
    }

    @GetMapping("info/user/demo")
    public ClientInfo getClientInfoWithUsername()
    {
        var name = m_httpServletRequest.getParameter("name");
        var host = m_httpServletRequest.getRemoteHost();
        var remotePort = m_httpServletRequest.getRemotePort();
        var localPort = m_httpServletRequest.getLocalPort();

        Console.writeLine("Name:%s, Host:%s, RemotePort:%d, LocalPort:%s", name, host, remotePort, localPort);

        return new ClientInfo(name, host, remotePort, localPort, m_requestDateTime);
    }

    @GetMapping("info/user")
    public ClientInfo getClientInfoWithUsername(@RequestParam(name = "name") String username)
    {
        var host = m_httpServletRequest.getRemoteHost();
        var remotePort = m_httpServletRequest.getRemotePort();
        var localPort = m_httpServletRequest.getLocalPort();

        Console.writeLine("Name:%s, Host:%s, RemotePort:%d, LocalPort:%s", username, host, remotePort, localPort);

        return new ClientInfo(username, host, remotePort, localPort, m_requestDateTime);
    }
}
