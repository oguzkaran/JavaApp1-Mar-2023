package com.fatihkarabulut.vehicle.commercial;

import com.boraserce.vehicle.CommercialVehicle;

public class LightTruck extends CommercialVehicle {
    private double m_maxCapacity;

    //...

    public LightTruck()
    {
        super(false);
    }

    public double getMaxCapacity()
    {
        return m_maxCapacity;
    }

    public void setMaxCapacity(double maxCapacity)
    {
        m_maxCapacity = maxCapacity;
    }
    public double calculateTax()
    {
        return m_maxCapacity * 500;
    }
}
