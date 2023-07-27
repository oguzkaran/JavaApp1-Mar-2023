/*----------------------------------------------------------------
	FILE		: MutablePoint.java
	AUTHOR		: JavaApp1-Mar-2023 Group
	LAST UPDATE	: 29.03.2023

	MutablePoint class that represents 2 dimensional point in
	Cartesian plane

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.math.geometry;

public class MutablePoint {
	private double m_x;
	private double m_y;

	private MutablePoint(double a, double b, boolean polar)
	{
		m_x = PointCommon.createX(a, b, polar);
		m_y = PointCommon.createY(a, b, polar);
	}

	public static MutablePoint createCartesian()
	{
		return createCartesian(0);
	}

	public static MutablePoint createCartesian(double x)
	{
		return createCartesian(x, 0);
	}

	public static MutablePoint createCartesian(double x, double y)
	{
		return new MutablePoint(x, y, false);
	}

	public static MutablePoint createPolar(double radius)
	{
		return new MutablePoint(radius, 0, true);
	}

	public static MutablePoint createPolar(double radius, double theta)
	{
		return new MutablePoint(radius, theta, true);
	}

	public double getX()
	{
		return m_x;
	}

	public void setX(double x)
	{
		m_x = x;
	}

	public double getY()
	{
		return m_y;
	}

	public void setY(double y)
	{
		m_y = y;
	}

	public double distance()
	{
		return distance(0, 0);			
	}
	
	public double distance(MutablePoint other)
	{
		return distance(other.m_x, other.m_y);
	}
	
	public double distance(double x, double y)
	{
		return PointCommon.distance(m_x, m_y, x, y);
	}

	public void offset(double dxy)
	{
		offset(dxy, dxy);
	}

	public void offset(double dx, double dy)
	{
		m_x += dx;
		m_y += dy;
	}
	
	public String toString()
	{
		return PointCommon.toString(m_x, m_y);
	}
}
