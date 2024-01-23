package com.fatihkarabulut.vehicle.commercial;

import com.boraserce.vehicle.CommercialVehicle;

public class Truck extends CommercialVehicle {
    private double m_length;
    private double m_maxCapacity;

    //...

    public Truck()
    {
        super(false);
    }

    public double getLength()
    {
        return m_length;
    }

    public void setLength(double length)
    {
        m_length = length;
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
        return m_maxCapacity * 1000;
    }
}
