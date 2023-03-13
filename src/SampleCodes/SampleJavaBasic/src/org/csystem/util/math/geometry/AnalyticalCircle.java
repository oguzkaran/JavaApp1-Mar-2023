/*----------------------------------------------------------------------
	FILE        : AnalyticalCircle.java
	AUTHOR      : Java-May-2021 Group
	LAST UPDATE : 06.11.2021

	AnalyticalCircle class that represents the analytical circle in geometry

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.math.geometry;

public class AnalyticalCircle extends Circle {
    private final Point m_center;

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
        this(r, center.x, center.y);
    }

    public AnalyticalCircle(double r, double x, double y)
    {
        super(r);
        m_center =  Point.createCartesian(x, y);
    }

    public double getX()
    {
        return m_center.x;
    }

    public void setX(double x)
    {
        m_center.x = x;
    }

    public double getY()
    {
        return m_center.y;
    }

    public void setY(double y)
    {
        m_center.y = y;
    }

    public Point getCenter()
    {
        return new Point(m_center);
    }

    public void setCenter(Point center)
    {
        setCenter(center.x, center.y);
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
