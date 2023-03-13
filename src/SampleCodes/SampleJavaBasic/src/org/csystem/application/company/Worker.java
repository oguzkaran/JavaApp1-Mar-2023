package org.csystem.application.company;

public class Worker extends Employee {
    private int m_hourPerDay;
    private double m_feePerHour;
    //...


    public int getHourPerDay()
    {
        return m_hourPerDay;
    }

    public void setHourPerDay(int hourPerDay)
    {
        //...
        m_hourPerDay = hourPerDay;
    }

    public double getFeePerHour()
    {
        return m_feePerHour;
    }

    public void setFeePerHour(double feePerHour)
    {
        //...
        m_feePerHour = feePerHour;
    }

    public double calculateInsurancePayment()
    {
        return m_feePerHour * m_hourPerDay * 30;
    }
}
