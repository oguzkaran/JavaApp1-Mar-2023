/*----------------------------------------------------------
	FILE			: AnalyticalCircle.java
	AUTHOR			: Java-Nov-2022 Group
	LAST UPDATE		: 22.07.2023

	AnalyticalCircle class that represents a circle
	int cartesian plane

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
------------------------------------------------------------*/
package com.bartucankaya;

import org.csystem.math.geometry.Circle;
import org.csystem.math.geometry.MutablePoint;

public class AnalyticalCircle extends Circle {
    private static final double DELTA = 0.00001;

    private final MutablePoint m_center;

    public AnalyticalCircle()
    {
        this(0);
    }

    public AnalyticalCircle(double radius)
    {
       this(radius, 0, 0);
    }

    public AnalyticalCircle(double x, double y)
    {
        this(0, x, y);
    }

    public AnalyticalCircle(double radius, double x, double y)
    {
        super(radius);
        m_center = MutablePoint.ofCartesian(x, y);
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

    public void set(double x, double y)
    {
        setX(x);
        setY(y);
    }

    public double centerDistance(AnalyticalCircle other)
    {
        return m_center.distance(other.m_center);
    }

    public boolean isTangent(AnalyticalCircle other)
    {
        return Math.abs(centerDistance(other) - getRadius() - other.getRadius()) < DELTA;
    }

    public void offset(double dx, double dy)
    {
        m_center.offset(dx, dy);
    }

    public void offset(double dxy)
    {
        offset(dxy, dxy);
    }

    public boolean equals(Object other)
    {
        return other instanceof AnalyticalCircle ac && super.equals(other) && m_center.equals(ac.m_center);
    }

    public String toString()
    {
        return String.format("%s, Center:%s", super.toString(), m_center);
    }
}
