package com.onurozcan.vehicle;

import com.haticekubraulusoy.vehicle.PersonalVehicle;

public class Car extends PersonalVehicle {
    private String m_type;
    //...

    public Car()
    {
        super(2);
    }

    public String getType()
    {
        return m_type;
    }

    public void setType(String type)
    {
        m_type = type;
    }
    //...

    public double calculateTax()
    {
        return 2000;
    }
}
