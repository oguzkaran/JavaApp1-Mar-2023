package org.csystem.app.payment.data.dto;


public class CustomerSaveDTO {
    public String username;

    public String name;

    public boolean active;

    @Override
    public int hashCode()
    {
        return username.hashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof CustomerSaveDTO c && username.equals(c.username);
    }
}


