package org.csystem.application.company;

public class SalesManager extends Manager {
    private double m_extra;
    //...


    public double getExtra()
    {
        return m_extra;
    }

    public void setExtra(double extra)
    {
        //...
        m_extra = extra;
    }

    public double calculateInsurancePayment()
    {
        return super.calculateInsurancePayment() + m_extra;
    }
}
