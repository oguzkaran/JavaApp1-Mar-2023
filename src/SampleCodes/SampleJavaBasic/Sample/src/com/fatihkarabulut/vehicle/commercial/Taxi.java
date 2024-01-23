package com.fatihkarabulut.vehicle.commercial;

import com.boraserce.vehicle.CommercialVehicle;

public class Taxi extends CommercialVehicle {
    private String m_city;

    //...

    public Taxi()
    {
        super(true);
    }

    public String getCity()
    {
        return m_city;
    }

    public void setCity(String city)
    {
        m_city = city;
    }

    //...

    public double calculateTax()
    {
        return 1500;
    }
}
