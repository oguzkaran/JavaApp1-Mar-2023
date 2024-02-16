package org.csystem.app.payment.data.dto;

public class ActiveCustomerDTO {
    private String m_username;
    private String m_customerName;
    private String m_registerDate;

    public String getUsername()
    {
        return m_username;
    }

    public void setUsername(String username)
    {
        this.m_username = username;
    }

    public String getCustomerName()
    {
        return m_customerName;
    }

    public void setCustomerName(String customerName)
    {
        m_customerName = customerName;
    }

    public String getRegisterDate()
    {
        return m_registerDate;
    }

    public void setRegisterDate(String registerDate)
    {
        m_registerDate = registerDate;
    }

    @Override
    public int hashCode()
    {
        return m_username.hashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof ActiveCustomerDTO c && m_username.equals(c.m_username);
    }
}


