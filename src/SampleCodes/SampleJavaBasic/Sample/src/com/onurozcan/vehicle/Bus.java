package com.onurozcan.vehicle;

import com.boraserce.vehicle.CommercialVehicle;

public class Bus extends CommercialVehicle {
    private double m_length;
    private int m_passengerCount;
    //...

    public Bus()
    {
        super(true);
    }

    public double getLength()
    {
        return m_length;
    }

    public void setLength(double length)
    {
        m_length = length;
    }

    public int getPassengerCount()
    {
        return m_passengerCount;
    }

    public void setPassengerCount(int passengerCount)
    {
        m_passengerCount = passengerCount;
    }

    public double calculateTax()
    {
        return m_passengerCount * 1000;
    }
}
