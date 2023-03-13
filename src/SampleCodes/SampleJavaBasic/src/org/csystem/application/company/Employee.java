package org.csystem.application.company;

public abstract class Employee {
    private String m_name;
    private String m_citizenId;
    private String m_address;
    //...

    protected Employee(/*...*/)
    {
        //...
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

    public String getCitizenId()
    {
        return m_citizenId;
    }

    public void setCitizenId(String citizenId)
    {
        //...
        m_citizenId = citizenId;
    }

    public String getAddress()
    {
        return m_address;
    }

    public void setAddress(String address)
    {
        //...
        m_address = address;
    }

    public abstract double calculateInsurancePayment();

    //...
}
