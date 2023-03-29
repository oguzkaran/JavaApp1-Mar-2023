/*----------------------------------------------------------------
	FILE		: Point.java
	AUTHOR		: JavaApp1-Mar-2023 Group
	LAST UPDATE	: 29.03.2023

	Immutable Point class that represents 2 dimensional point in
	Cartesian plane

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.math.geometry;

public class Point {
	private final double m_x;
	private final double m_y;

	private Point(double a, double b, boolean polar)
	{
		m_x = PointCommon.createX(a, b, polar);
		m_y = PointCommon.createY(a, b, polar);
	}

	public static Point createCartesian()
	{
		return createCartesian(0);
	}

	public static Point createCartesian(double x)
	{
		return createCartesian(x, 0);
	}

	public static Point createCartesian(double x, double y)
	{
		return new Point(x, y, false);
	}

	public static Point createPolar(double radius)
	{
		return new Point(radius, 0, true);
	}

	public static Point createPolar(double radius, double theta)
	{
		return new Point(radius, theta, true);
	}

	public double getX()
	{
		return m_x;
	}

	public double getY()
	{
		return m_y;
	}

	public double distance()
	{
		return distance(0, 0);			
	}
	
	public double distance(Point other)
	{
		return distance(other.m_x, other.m_y);
	}
	
	public double distance(double x, double y)
	{
		return PointCommon.distance(m_x, m_y, x, y);
	}
	
	public String toString()
	{
		return PointCommon.toString(m_x, m_y);
	}
}
