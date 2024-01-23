package com.alicankececi.rental.vehicle;

import com.karandev.app.tax.ITax;

public abstract class Vehicle implements ITax {
    private String m_id;
    private String m_plate;
    private String m_brand;
    private String m_model;
    private double m_cc;
    private int m_year;

    //...

    public String getId()
    {
        return m_id;
    }

    public void setId(String id)
    {
        //...
        m_id = id;
    }

    public String getPlate()
    {
        return m_plate;
    }

    public void setPlate(String plate)
    {
        //...
        m_plate = plate;
    }

    public String getBrand()
    {
        return m_brand;
    }

    public void setBrand(String brand)
    {
        m_brand = brand;
    }

    public String getModel()
    {
        return m_model;
    }

    public void setModel(String model)
    {
        //...
        m_model = model;
    }

    public double getCc()
    {
        return m_cc;
    }

    public void setCc(double cc)
    {
        m_cc = cc;
    }

    public int getYear()
    {
        return m_year;
    }

    public void setYear(int year)
    {
        m_year = year;
    }

}
