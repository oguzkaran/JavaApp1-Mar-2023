/*----------------------------------------------------------------------
	FILE        : AnalyticalCircle.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 16.03.2023

	AnalyticalCircle class that represents the analytical circle in geometry

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.math.geometry;

public class AnalyticalCircle extends Circle {
    private final MutablePoint m_center;

    public AnalyticalCircle()
    {
        this(0);
    }

    public AnalyticalCircle(double x, double y)
    {
        this(0, x, y);
    }

    public AnalyticalCircle(double r)
    {
        this(r, 0, 0);
    }

    public AnalyticalCircle(Point center)
    {
        this(0, center);
    }

    public AnalyticalCircle(double r, Point center)
    {
        this(r, center.getX(), center.getY());
    }

    public AnalyticalCircle(double r, double x, double y)
    {
        super(r);
        m_center =  MutablePoint.createCartesian(x, y);
    }

    public double getX()
    {
        return m_center.getX();
    }

    public void setX(double x)
    {
        m_center.setX(x);
    }

    public double getY()
    {
        return m_center.getY();
    }

    public void setY(double y)
    {
        m_center.setY(y);
    }

    public MutablePoint getCenter()
    {
        return MutablePoint.createCartesian(m_center.getX(), m_center.getY());
    }

    public void setCenter(MutablePoint center)
    {
        setCenter(center.getX(), center.getY());
    }

    public void setCenter(double x, double y)
    {
        setX(x);
        setY(y);
    }

    public void offset(double dx, double dy) //delegate method
    {
        m_center.offset(dx, dy);
    }

    public void offset(double dxy) //delegate method
    {
        offset(dxy, dxy);
    }

    public double centerDistance(AnalyticalCircle other)
    {
        return m_center.distance(other.m_center);
    }
}
