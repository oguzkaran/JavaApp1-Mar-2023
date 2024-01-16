package org.csystem.app.service.info.client.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.csystem.app.service.info.client.ClientInfo;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        return new ClientInfo(m_httpServletRequest.getRemoteAddr(), m_httpServletRequest.getLocalAddr(),
                m_httpServletRequest.getRemotePort(), m_httpServletRequest.getLocalPort(), m_requestDateTime);
    }
}
